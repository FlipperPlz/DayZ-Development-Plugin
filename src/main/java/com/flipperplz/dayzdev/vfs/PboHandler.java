package com.flipperplz.dayzdev.vfs;

import com.flipperplz.bisutils.pbo.PboFile;
import com.flipperplz.bisutils.pbo.entry.entries.PboDataEntry;
import com.intellij.openapi.vfs.impl.ArchiveHandler;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PboHandler extends ArchiveHandler {
    private static final URI ROOT_URI = URI.create("");
    private String pboPrefix;

    protected PboHandler(@NotNull String path) {
        super(path);
    }

    @Override
    protected @NotNull Map<String, EntryInfo> createEntriesMap() throws IOException {
        Map<String, EntryInfo> map = new HashMap<>();
        List<EntryInfo> infoList = new ArrayList<>();
        var pboFile = new PboFile(Path.of(getFile().getAbsolutePath()));
        var entryRoot = createRootEntry();
        map.put("", entryRoot);
        var split = getPboPrefix().split("\\\\");

        var prefix = getPboPrefix().toLowerCase();
        if(!prefix.endsWith("\\")) prefix += '\\';

        for (var dataEnt: pboFile.getDataEntries()) {
            getOrCreateFile(map, prefix + dataEnt.getEntryName(), entryRoot, dataEnt.getPackedSize(), false);
        }
        pboFile.close();

        return map;

    }

    private EntryInfo getOrCreateFile(Map<String, EntryInfo> map, String entryPath, EntryInfo parent, int entryLength, boolean isDir) {
        if(!entryPath.contains("\\")) {
            var data = new EntryInfo(entryPath, isDir, entryLength, System.currentTimeMillis(), parent);
            map.put(entryPath, data);
            return data;
        }

        var tree = entryPath.split(entryPath);

        EntryInfo currentParent = parent;
        for (int i = 0, treeLength = tree.length; i < treeLength; i++) {
            boolean isLast = !((i + 1) < treeLength);

            var path = getFullPath(currentParent) + '\\' + tree[i];
            if(!map.containsKey(path) || (isLast && map.get(path).isDirectory != isDir)) {
                var data = new EntryInfo(tree[i], isLast ? isDir : true, entryLength, System.currentTimeMillis(), currentParent);
                currentParent = data;
                map.put(path, data);
            } else currentParent = map.get(path);
        }

        return currentParent;
    }

    private static String getFullPath(EntryInfo entryInfo) {
        StringBuilder path = new StringBuilder();
        EntryInfo current = entryInfo;
        while (current != null) {
            path.insert(0, current.shortName);
            current = current.parent;
            if (current != null) {
                path.insert(0, '\\');
            }
        }
        return path.toString();
    }


    @Override
    public byte @NotNull [] contentsToByteArray(@NotNull String relativePath) throws IOException {
        EntryInfo entry = getEntryInfo(relativePath);
        if (entry == null) throw new FileNotFoundException(getFile() + " : " + relativePath);
        String entryName = relativePath.substring(getPboPrefix().length());
        var pboFile = new PboFile(Path.of(getFile().getAbsolutePath()));

        for (var dataEntry : pboFile.getDataEntries()) {
            if (normalizePboPath(dataEntry.getEntryName()).equals(entryName)) {
                var data = pboFile.getEntryData(dataEntry, true);
                pboFile.close();
                return data;
            }
        }

        pboFile.close();
        throw new FileNotFoundException("File not found in pbo archive: " + relativePath);
    }


    private String getPboPrefix() throws IOException {
        if(pboPrefix != null) return pboPrefix;
        var pboFile = new PboFile(Path.of(getFile().getAbsolutePath()));
        var prefix = normalizePboPath(pboFile.getVersionEntry().getPrefix());
        pboFile.close();
        pboPrefix = (prefix == null ? normalizePboPath(FilenameUtils.removeExtension(getFile().getName())) : prefix);
        return pboPrefix;
    }

    public static String normalizePboPath(String path) {
        if (path == null || path.isEmpty()) return path;

        char[] result = new char[path.length()];
        boolean lastWasSeparator = false, isFirst = true; // Initialize flag to track if the last character was a separator
        int charsWritten = 0; // counter to keep track of the number of characters written to the result array

        for (int i = 0; i < path.length(); i++) { // Iterate through each character in the path
            char c = path.charAt(i);
            if (c == '/' || c == '\\') {
                if(isFirst) continue;
                if (lastWasSeparator) continue; // Skip if the last character was a seperator.
                result[charsWritten++] = '\\';
                lastWasSeparator = true;
                continue;
            }

            isFirst = false;
            lastWasSeparator = false;
            result[charsWritten++] = Character.toLowerCase(c);
        }

        if (charsWritten > 0 && result[charsWritten - 1] == '\\') charsWritten--;

        return new String(result, 0, charsWritten);
    }
}
