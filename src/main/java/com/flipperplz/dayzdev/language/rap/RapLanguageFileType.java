package com.flipperplz.dayzdev.language.rap;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RapLanguageFileType extends LanguageFileType {
    public static final RapLanguageFileType INSTANCE = new RapLanguageFileType();

    private RapLanguageFileType() {
        super(RapLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Config File";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Rapifiable config used for DayZ Development ";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "cpp";
    }

    @Override
    public @Nullable Icon getIcon() {
        return null; //TODO: ICON
    }
}
