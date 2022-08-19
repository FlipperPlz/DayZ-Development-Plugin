package com.flipperplz.dayzdev.language.enforce;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class EnforceLanguageFileType extends LanguageFileType {
    public static final EnforceLanguageFileType INSTANCE = new EnforceLanguageFileType();

    protected EnforceLanguageFileType() {
        super(EnforceLanguage.INSTANCE );
    }


    @Override
    public @NonNls @NotNull String getName() {
        return "Enforce Script";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Script files used for DayZ Development ";

    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "c";
    }

    @Override
    public @Nullable Icon getIcon() {
        return null;
    }
}
