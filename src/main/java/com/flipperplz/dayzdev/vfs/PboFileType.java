package com.flipperplz.dayzdev.vfs;

import com.flipperplz.dayzdev.DayZConstants;
import com.flipperplz.dayzdev.language.rap.RapLanguageFileType;
import com.intellij.ide.highlighter.ArchiveFileType;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.tools.ant.types.selectors.TypeSelector;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PboFileType implements FileType {

    public static final PboFileType INSTANCE = new PboFileType();

    @Override
    public @NonNls @NotNull String getName() {
        return DayZConstants.PBO_PROTOCOL;
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return DayZConstants.PBO_DESCRIPTION;
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return DayZConstants.EXT_PBO;
    }

    //TODO: PBO File Icon
    @Override
    public @Nullable Icon getIcon() {
        return null;
    }

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public boolean isReadOnly() {
        return true;
    }

    @Override
    public @NonNls @Nullable String getCharset(@NotNull VirtualFile file, byte @NotNull [] content) {
        return "UTF-8";
    }
}
