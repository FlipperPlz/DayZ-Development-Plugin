package com.flipperplz.dayzdev.language.rap.lexer;

import com.intellij.lexer.FlexAdapter;

public class RapLexerAdapter extends FlexAdapter {
    public RapLexerAdapter() {
        super(new RapLexer(null));
    }
}
