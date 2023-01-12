package com.flipperplz.dayzdev.vfs;

import com.flipperplz.dayzdev.DayZConstants;
import com.intellij.ide.highlighter.ArchiveFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class PboFileType extends ArchiveFileType {

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

}
