package com.flipperplz.dayzdev.language.enforce;

import com.intellij.lang.Language;

public class EnforceLanguage extends Language {
    public static final EnforceLanguage INSTANCE = new EnforceLanguage();

    protected EnforceLanguage() {
        super("Enforce");
    }
}
