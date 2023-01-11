package com.flipperplz.dayzdev.vfs;

import com.flipperplz.dayzdev.DayZConstants;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileListener;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.impl.ArchiveHandler;
import com.intellij.openapi.vfs.impl.ZipHandler;
import com.intellij.openapi.vfs.newvfs.ArchiveFileSystem;
import com.intellij.openapi.vfs.newvfs.VfsImplUtil;
import com.intellij.util.io.URLUtil;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PboFileSystem extends ArchiveFileSystem {
    public static final String PROTOCOL = DayZConstants.EXT_PBO;

    @Override
    public @NonNls @NotNull String getProtocol() {
        return PROTOCOL;
    }

    @Override
    public @Nullable VirtualFile findFileByPath(@NotNull @NonNls String path) {
        return VfsImplUtil.findFileByPath(this, path);
    }

    @Override
    public @Nullable VirtualFile findFileByPathIfCached(@NonNls @NotNull String path) {
        return VfsImplUtil.findFileByPathIfCached(this, path);
    }

    @Override
    public void refresh(boolean asynchronous) {
        VfsImplUtil.refresh(this, asynchronous);
    }

    @Override
    public @Nullable VirtualFile refreshAndFindFileByPath(@NotNull String path) {
        return VfsImplUtil.refreshAndFindFileByPath(this, path);
    }


    @Override
    public boolean isReadOnly() {
        return true;
    }

    @Override
    protected @NotNull String extractRootPath(@NotNull String normalizedPath) {
        return normalizedPath;
    }

    @Override
    protected @NotNull String extractLocalPath(@NotNull String rootPath) {
        return rootPath;
    }

    @Override
    protected @NotNull String composeRootPath(@NotNull String localPath) {
        return localPath;
    }


    public static PboFileSystem getInstance() {
        return (PboFileSystem) VirtualFileManager.getInstance().getFileSystem(PROTOCOL);
    }

    @Override
    protected @NotNull ArchiveHandler getHandler(@NotNull VirtualFile entryFile) {
        return VfsImplUtil.getHandler(this, entryFile, PboHandler::new);
    }
}
