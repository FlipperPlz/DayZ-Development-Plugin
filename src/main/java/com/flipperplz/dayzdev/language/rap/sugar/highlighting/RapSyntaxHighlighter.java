package com.flipperplz.dayzdev.language.rap.sugar.highlighting;

import com.flipperplz.dayzdev.language.rap.lexer.RapLexerAdapter;
import com.flipperplz.dayzdev.language.rap.psi.RapElementTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class RapSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey(
            "RAP_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
    );

    public static final TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey(
            "RAP_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER
    );

    public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey(
            "RAP_STRING",
            DefaultLanguageHighlighterColors.STRING
    );

    public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey(
            "RAP_COMMENT",
            DefaultLanguageHighlighterColors.BLOCK_COMMENT
    );

    public static final TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey(
            "RAP_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER
    );

    public static final TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey(
            "RAP_IDENTIFIER",
            DefaultLanguageHighlighterColors.BLOCK_COMMENT
    );

    public static final TextAttributesKey SEMICOLON = TextAttributesKey.createTextAttributesKey(
            "RAP_SEMICOLON",
            DefaultLanguageHighlighterColors.SEMICOLON
    );

    public static final TextAttributesKey COMMA = TextAttributesKey.createTextAttributesKey(
            "RAP_COMMA",
            DefaultLanguageHighlighterColors.COMMA
    );

    public static final TextAttributesKey COLON = TextAttributesKey.createTextAttributesKey(
            "RAP_COLON",
            DefaultLanguageHighlighterColors.DOT
    );

    public static final TextAttributesKey BRACES = TextAttributesKey.createTextAttributesKey(
            "RAP_BRACE",
            DefaultLanguageHighlighterColors.BRACES
    );

    public static final TextAttributesKey BRACKETS = TextAttributesKey.createTextAttributesKey(
            "RAP_BRACKET",
            DefaultLanguageHighlighterColors.BRACKETS
    );

    public static final TextAttributesKey OPERATORS = TextAttributesKey.createTextAttributesKey(
            "RAP_OPERATORS",
            DefaultLanguageHighlighterColors.OPERATION_SIGN
    );

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[] {
            BAD_CHARACTER
    };

    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[] {
            KEYWORD
    };

    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[] {
            COMMENT
    };

    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[] {
            STRING
    };

    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[] {
            NUMBER
    };

    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[] {
            IDENTIFIER
    };

    private static final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[] {
            SEMICOLON
    };

    private static final TextAttributesKey[] COLON_KEYS = new TextAttributesKey[] {
            COLON
    };

    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[] {
            COMMA
    };

    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[] {
            BRACKETS
    };

    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[] {
            BRACES
    };

    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[] {
            OPERATORS
    };

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new RapLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if(tokenType.equals(RapElementTypes.CLASS))
            return KEYWORD_KEYS;

        if(tokenType.equals(RapElementTypes.DELETE))
            return KEYWORD_KEYS;

        if(tokenType.equals(RapElementTypes.IDENTIFIER))
            return IDENTIFIER_KEYS;

        if(tokenType.equals(RapElementTypes.DELIMITED_COMMENT) ||
           tokenType.equals(RapElementTypes.EMPTY_DELIMITED_COMMENT) ||
           tokenType.equals(RapElementTypes.SINGLE_LINE_COMMENT))
            return COMMENT_KEYS;

        if(tokenType.equals(RapElementTypes.LITERALFLOAT) ||
           tokenType.equals(RapElementTypes.LITERALINTEGER))
            return NUMBER_KEYS;

        if(tokenType.equals(RapElementTypes.LITERALSTRING))
            return STRING_KEYS;

        if(tokenType.equals(RapElementTypes.SEMICOLON))
            return SEMICOLON_KEYS;

        if(tokenType.equals(RapElementTypes.COLON))
            return COLON_KEYS;

        if(tokenType.equals(RapElementTypes.COMMA))
            return COMMA_KEYS;

        if(tokenType.equals(RapElementTypes.LSBRACKET) ||
           tokenType.equals(RapElementTypes.RSBRACKET))
            return BRACKET_KEYS;

        if(tokenType.equals(RapElementTypes.LCURLY) ||
           tokenType.equals(RapElementTypes.RCURLY))
            return BRACE_KEYS;

        if(tokenType.equals(RapElementTypes.APPEND) ||
           tokenType.equals(RapElementTypes.ASSIGN))
            return OPERATOR_KEYS;
        if(tokenType.equals(TokenType.BAD_CHARACTER))
            return BAD_CHAR_KEYS;

        return EMPTY_KEYS;
    }
}
