package com.flipperplz.dayzdev.vfs;

import com.flipperplz.dayzdev.DayZConstants;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.impl.ArchiveHandler;
import com.intellij.openapi.vfs.newvfs.ArchiveFileSystem;
import com.intellij.openapi.vfs.newvfs.VfsImplUtil;
import com.intellij.util.io.URLUtil;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class PboFileSystem extends ArchiveFileSystem {
    public static final String PROTOCOL = DayZConstants.PBO_PROTOCOL;
    public static final String PROTOCOL_PREFIX = DayZConstants.PBO_PROTOCOL_PREFIX;
    public static final String PBO_SEPARATOR = URLUtil.JAR_SEPARATOR;

    public static PboFileSystem getInstance() {
        return (PboFileSystem) VirtualFileManager.getInstance().getFileSystem(PROTOCOL);
    }

    public @Nullable VirtualFile getVirtualFileForPbo(@Nullable VirtualFile entryFile) {
        return entryFile == null ? null : getLocalByEntry(entryFile);
    }

    public @Nullable VirtualFile getPboRootForLocalFile(@NotNull VirtualFile file) {
        return getRootByLocal(file);
    }

    public @Nullable File getMirroredFile(@NotNull VirtualFile file) {
        return new File(file.getPath());
    }

    @Override
    public @NonNls @NotNull String getProtocol() {
        return PROTOCOL;
    }

    @Override
    public @NotNull String extractPresentableUrl(@NotNull String path) {
        return super.extractPresentableUrl(StringUtil.trimEnd(path, PBO_SEPARATOR));
    }

    @Override
    protected @Nullable String normalize(@NotNull String path) {
        int separatorIndex = path.indexOf(PBO_SEPARATOR);
        return separatorIndex > 0 ? FileUtil.normalize(path.substring(0, separatorIndex)) + path.substring(separatorIndex) : null;
    }

    @Override
    protected @NotNull String extractRootPath(@NotNull String normalizedPath) {
        int separatorIndex = normalizedPath.indexOf(PBO_SEPARATOR);
        return separatorIndex > 0 ? normalizedPath.substring(0, separatorIndex + PBO_SEPARATOR.length()) : "";
    }

    @Override
    protected @NotNull String extractLocalPath(@NotNull String rootPath) {
        return StringUtil.trimEnd(rootPath, PBO_SEPARATOR);
    }

    @Override
    protected @NotNull String composeRootPath(@NotNull String localPath) {
        return localPath + PBO_SEPARATOR;
    }

    @Override
    protected @NotNull ArchiveHandler getHandler(@NotNull VirtualFile entryFile) {
        return VfsImplUtil.getHandler(this, entryFile, PboHandler::new);
    }

    @Override
    public @Nullable VirtualFile findFileByPathIfCached(@NonNls @NotNull String path) {
        return isValid(path) ? VfsImplUtil.findFileByPathIfCached(this, path) : null;
    }

    @Override
    public @Nullable VirtualFile refreshAndFindFileByPath(@NotNull String path) {
        return isValid(path) ? VfsImplUtil.refreshAndFindFileByPath(this, path) : null;
    }

    @Override
    public @Nullable VirtualFile findFileByPath(@NotNull @NonNls String path) {
        return isValid(path) ? VfsImplUtil.findFileByPath(this, path) : null;
    }

    private static boolean isValid(String path) {
        return path.contains(PBO_SEPARATOR);
    }

    @Override
    public void refresh(boolean asynchronous) {
        VfsImplUtil.refresh(this, asynchronous);
    }


}
