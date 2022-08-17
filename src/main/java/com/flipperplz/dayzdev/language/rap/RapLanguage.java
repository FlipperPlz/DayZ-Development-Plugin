package com.flipperplz.dayzdev.language.rap;

import com.intellij.lang.Language;

public class RapLanguage extends Language {
    public static final RapLanguage INSTANCE = new RapLanguage();
    protected RapLanguage() {
        super("Rap");
    }
}
