package com.flipperplz.dayzdev.language.enforce.lexer;

import com.intellij.lexer.FlexAdapter;

public class EnforceLexerAdapter extends FlexAdapter {
    public EnforceLexerAdapter() {
        super(new EnforceLexer(null));
    }
}
