package com.flipperplz.dayzdev.vfs;

import com.flipperplz.bisutils.pbo.PboFile;
import com.flipperplz.bisutils.pbo.entry.entries.PboDataEntry;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.vfs.impl.ArchiveHandler;
import com.intellij.openapi.vfs.impl.ZipHandler;
import com.intellij.util.io.FileAccessorCache;
import com.intellij.util.io.ResourceHandle;
import com.jetbrains.qodana.sarif.model.Run;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class PboHandler extends ArchiveHandler {
    private static final Logger LOG = Logger.getInstance(PboHandler.class);
    private static final FileAccessorCache<PboHandler, PboFile> pboFileAccessorCache = new FileAccessorCache<PboHandler, PboFile>(20, 10) {
        @Override
        protected @NotNull PboFile createAccessor(PboHandler handler) throws IOException {
            var file = handler.getFile();
            BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            handler.pboTimestamp = attributes.lastModifiedTime().toMillis();
            handler.pboLength = attributes.size();
            var pbo = new PboFile(file.toPath());
            var defaultPrefix = DayZFilesystemUtils.normalizePboPrefix(FilenameUtils.getBaseName(file.getName()));

            var versionEntry = pbo.getVersionEntry();
            if(versionEntry == null) {
                handler.pboPrefix = defaultPrefix;
                return pbo;
            }

            var prefix = versionEntry.getPrefix();
            if(prefix == null) {
                handler.pboPrefix = defaultPrefix;
                return pbo;
            }

            handler.pboPrefix = DayZFilesystemUtils.normalizePboPrefix(prefix);
            return pbo;
        }

        @Override
        protected void disposeAccessor(@NotNull PboFile fileAccessor) throws IOException {
            fileAccessor.close();
        }

        @Override
        public boolean isEqual(PboHandler val1, PboHandler val2) {
            return val1 == val2;
        }
    };

    private static final URI ROOT_URI = URI.create("pbo:/");
    private volatile String pboPrefix;
    private volatile long pboTimestamp;
    private volatile long pboLength;


    protected PboHandler(@NotNull String path) {
        super(path);
    }

    private @NotNull ResourceHandle<PboFile> acquirePboHandle() throws IOException {
        try {
            FileAccessorCache.Handle<PboFile> handle = pboFileAccessorCache.get(this);

            File file = getFile();
            BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            if (attrs.lastModifiedTime().toMillis() != pboTimestamp || attrs.size() != pboLength) {
                //PBO was edited
                clearCaches();
                handle.release();
                handle = pboFileAccessorCache.get(this);
            }

            return handle;
        } catch (RuntimeException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) throw (IOException)cause;
            throw e;
        }
    }

    @Override
    public void clearCaches() {
        pboFileAccessorCache.remove(this);
        super.clearCaches();
    }


    @Override
    protected @NotNull Map<String, EntryInfo> createEntriesMap() throws IOException {
        try (ResourceHandle<PboFile> pboRef = acquirePboHandle()) {
            return buildEntryMapForPboFile(pboRef.get());
        }
    }

    @Override
    public byte @NotNull [] contentsToByteArray(@NotNull String relativePath) throws IOException {
        try (ResourceHandle<PboFile> pboRef = acquirePboHandle()) {
            var pbo = pboRef.get();
            var path = DayZFilesystemUtils.normalizePboPath(relativePath);
            path = DayZFilesystemUtils.removePboPrefix(pboPrefix, path);
            var entries = pbo.getDataEntries();

            for (var entry : entries) {
                if (!DayZFilesystemUtils.normalizePboPath(entry.getEntryName()).equals(path)) continue;
                return  pbo.getEntryData(entry, true);
            }
        }
        throw new FileNotFoundException("File not found in pbo archive: " + relativePath);
    }


    private @NotNull Map<String, EntryInfo> buildEntryMapForPboFile(PboFile pboFile) {
        Map<String, EntryInfo> entryMap = new HashMap<>();
        var entryRoot = createRootEntry();
        var entries = pboFile.getDataEntries();
        for (var dataEnt: entries) {
            processEntry(entryMap, LOG, DayZFilesystemUtils.buildPboPath(pboPrefix, dataEnt.getEntryName()),
                    (parent, name) -> new EntryInfo(name, false, dataEnt.getOriginalSize(), dataEnt.getTimestamp(), parent));
        }

        return entryMap;
    }
}
