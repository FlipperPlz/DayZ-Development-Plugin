package com.flipperplz.dayzdev.language.enforce.sugar.highlighting;

import com.flipperplz.dayzdev.language.enforce.lexer.EnforceLexerAdapter;
import com.flipperplz.dayzdev.language.enforce.psi.EnforceElementTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class EnforceSyntaxHighlighter implements SyntaxHighlighter {
    public static final TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey("ENFORCE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey FLOAT = TextAttributesKey.createTextAttributesKey("ENFORCE_FLOAT", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey INT = TextAttributesKey.createTextAttributesKey("ENFORCE_INT", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("ENFORCE_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey CLASSNAME = TextAttributesKey.createTextAttributesKey("ENFORCE_CLASSNAME", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey CLASS_REFERENCE = TextAttributesKey.createTextAttributesKey("ENFORCE_CLASS_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey BLOCK_COMMENT = TextAttributesKey.createTextAttributesKey("ENFORCE_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey LINE_COMMENT = TextAttributesKey.createTextAttributesKey("ENFORCE_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("ENFORCE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey("ENFORCE_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey SEMICOLON = TextAttributesKey.createTextAttributesKey("ENFORCE_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey PARENTHESIS = TextAttributesKey.createTextAttributesKey("ENFORCE_PARENTHESIS", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey COMMA = TextAttributesKey.createTextAttributesKey("ENFORCE_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey OPERATOR = TextAttributesKey.createTextAttributesKey("ENFORCE_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BRACES = TextAttributesKey.createTextAttributesKey("ENFORCE_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey BRACKETS = TextAttributesKey.createTextAttributesKey("ENFORCE_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey FUNCTION_PARAMETER = TextAttributesKey.createTextAttributesKey("ENFORCE_FUNCTION_PARAMETER", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey FUNCTION_CALL = TextAttributesKey.createTextAttributesKey("ENFORCE_FUNCTION_CALL", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[] {BAD_CHARACTER};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[] {IDENTIFIER};
    private static final TextAttributesKey[] FLOAT_KEYS = new TextAttributesKey[] {FLOAT};
    private static final TextAttributesKey[] INT_KEYS = new TextAttributesKey[] {INT};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[] {STRING};
    private static final TextAttributesKey[] CLASSNAME_KEYS = new TextAttributesKey[] {CLASSNAME};
    private static final TextAttributesKey[] CLASS_REFERENCE_KEYS = new TextAttributesKey[] {CLASS_REFERENCE};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[] {OPERATOR};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[] {BRACES};
    private static final TextAttributesKey[] PARENTHESIS_KEYS = new TextAttributesKey[] {PARENTHESIS};
    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[] {BRACKETS};
    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[] {COMMA};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[] {KEYWORD};
    private static final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[] {SEMICOLON};
    private static final TextAttributesKey[] FUNCTION_PARAMETER_KEYS = new TextAttributesKey[] {FUNCTION_PARAMETER};
    private static final TextAttributesKey[] FUNCTION_CALL_KEYS = new TextAttributesKey[] {FUNCTION_CALL};
    private static final TextAttributesKey[] BLOCK_COMMENT_KEYS = new TextAttributesKey[] {BLOCK_COMMENT};
    private static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[] {LINE_COMMENT};

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new EnforceLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if(tokenType.equals(EnforceElementTypes.CLASS_REFERENCE)) return CLASS_REFERENCE_KEYS;
        if(tokenType.equals(EnforceElementTypes.MODDED) ||
           tokenType.equals(EnforceElementTypes.CLASS) ||
           tokenType.equals(EnforceElementTypes.EXTENDS) ||
           tokenType.equals(EnforceElementTypes.ENUM) ||
           tokenType.equals(EnforceElementTypes.NEW) ||
           tokenType.equals(EnforceElementTypes.THIS) ||
           tokenType.equals(EnforceElementTypes.SUPER) ||
           tokenType.equals(EnforceElementTypes.THREAD) ||
           tokenType.equals(EnforceElementTypes.DELETE) ||
           tokenType.equals(EnforceElementTypes.IF) ||
           tokenType.equals(EnforceElementTypes.ELSE) ||
           tokenType.equals(EnforceElementTypes.FOR) ||
           tokenType.equals(EnforceElementTypes.FOREACH) ||
           tokenType.equals(EnforceElementTypes.WHILE) ||
           tokenType.equals(EnforceElementTypes.RETURN) ||
           tokenType.equals(EnforceElementTypes.BREAK) ||
           tokenType.equals(EnforceElementTypes.CONTINUE) ||
           tokenType.equals(EnforceElementTypes.GOTO) ||
           tokenType.equals(EnforceElementTypes.SWITCH) ||
           tokenType.equals(EnforceElementTypes.SEALED) ||
           tokenType.equals(EnforceElementTypes.PRIVATE) ||
           tokenType.equals(EnforceElementTypes.PROTECTED) ||
           tokenType.equals(EnforceElementTypes.STATIC) ||
           tokenType.equals(EnforceElementTypes.AUTOPTR) ||
           tokenType.equals(EnforceElementTypes.PROTO) ||
           tokenType.equals(EnforceElementTypes.REF) ||
           tokenType.equals(EnforceElementTypes.REFERENCE) ||
           tokenType.equals(EnforceElementTypes.CONST) ||
           tokenType.equals(EnforceElementTypes.OWNED) ||
           tokenType.equals(EnforceElementTypes.OUT) ||
           tokenType.equals(EnforceElementTypes.NOTNULL) ||
           tokenType.equals(EnforceElementTypes.INOUT) ||
           tokenType.equals(EnforceElementTypes.LOCAL) ||
           tokenType.equals(EnforceElementTypes.EXTERNAL) ||
           tokenType.equals(EnforceElementTypes.OVERRIDE) ||
           tokenType.equals(EnforceElementTypes.NATIVE) ||
           tokenType.equals(EnforceElementTypes.VOLATILE) ||
           tokenType.equals(EnforceElementTypes.EVENT) ||
           tokenType.equals(EnforceElementTypes.NULL_LITERAL) ||
           tokenType.equals(EnforceElementTypes.BOOLEAN_LITERAL)) return KEYWORD_KEYS;
        if(tokenType.equals(EnforceElementTypes.DELIMITED_COMMENT) ||
           tokenType.equals(EnforceElementTypes.EMPTY_DELIMITED_COMMENT)) return BLOCK_COMMENT_KEYS;
        if(tokenType.equals(EnforceElementTypes.SINGLE_LINE_COMMENT)) return LINE_COMMENT_KEYS;
        if(tokenType.equals(EnforceElementTypes.FUNCTION_PARAMETER) ||
           tokenType.equals(EnforceElementTypes.FUNCTION_CALL_PARAMETER)) return FUNCTION_PARAMETER_KEYS;
        if(tokenType.equals(EnforceElementTypes.FUNCTION_CALL)) return FUNCTION_CALL_KEYS;
        if(tokenType.equals(EnforceElementTypes.LITERAL_FLOAT)) return FLOAT_KEYS;
        if(tokenType.equals(EnforceElementTypes.LITERAL_STRING)) return STRING_KEYS;
        if(tokenType.equals(EnforceElementTypes.LITERAL_INTEGER)) return INT_KEYS;
        if(tokenType.equals(EnforceElementTypes.LSBRACKET) ||
           tokenType.equals(EnforceElementTypes.RSBRACKET) ) return BRACKET_KEYS;
        if(tokenType.equals(EnforceElementTypes.LCURLY) ||
           tokenType.equals(EnforceElementTypes.RCURLY) ) return BRACE_KEYS;
        if(tokenType.equals(EnforceElementTypes.LPARENTHESIS) ||
           tokenType.equals(EnforceElementTypes.RPARENTHESIS) ) return PARENTHESIS_KEYS;
        if(tokenType.equals(EnforceElementTypes.ARITHMETIC_OPERATOR) ||
           tokenType.equals(EnforceElementTypes.OP_INCREMENT) ||
           tokenType.equals(EnforceElementTypes.OP_DECREMENT) ||
           tokenType.equals(EnforceElementTypes.OP_LSHIFT) ||
           tokenType.equals(EnforceElementTypes.OP_LSHIFT_ASSIGN) ||
           tokenType.equals(EnforceElementTypes.OP_RSHIFT) ||
           tokenType.equals(EnforceElementTypes.OP_RSHIFT_ASSIGN) ||
           tokenType.equals(EnforceElementTypes.OP_ASSIGN) ||
           tokenType.equals(EnforceElementTypes.OP_EQUAL) ||
           tokenType.equals(EnforceElementTypes.OP_INEQUAL) ||
           tokenType.equals(EnforceElementTypes.OP_LOGICAL_OR) ||
           tokenType.equals(EnforceElementTypes.OP_LOGICAL_AND) ||
           tokenType.equals(EnforceElementTypes.OP_AND_ASSIGN) ||
           tokenType.equals(EnforceElementTypes.OP_LESS_EQUAL) ||
           tokenType.equals(EnforceElementTypes.OP_GREATER_EQUAL) ||
           tokenType.equals(EnforceElementTypes.OP_XOR_ASSIGN) ||
           tokenType.equals(EnforceElementTypes.OP_OR_ASSIGN) ||
           tokenType.equals(EnforceElementTypes.OP_DIVIDE_ASSIGN) ||
           tokenType.equals(EnforceElementTypes.OP_MULTIPLY_ASSIGN) ||
           tokenType.equals(EnforceElementTypes.OP_ADD_ASSIGN) ||
           tokenType.equals(EnforceElementTypes.OP_SUBTRACT_ASSIGN) ||
           tokenType.equals(EnforceElementTypes.OP_BITWISE_OR) ||
           tokenType.equals(EnforceElementTypes.OP_BITWISE_AND) ||
           tokenType.equals(EnforceElementTypes.OP_BITWISE_NOT) ||
           tokenType.equals(EnforceElementTypes.OP_BITWISE_XOR) ||
           tokenType.equals(EnforceElementTypes.OP_GREATER) ||
           tokenType.equals(EnforceElementTypes.OP_LESS) ||
           tokenType.equals(EnforceElementTypes.OP_SUBTRACT) ||
           tokenType.equals(EnforceElementTypes.OP_ADD) ||
           tokenType.equals(EnforceElementTypes.OP_MULTIPLY) ||
           tokenType.equals(EnforceElementTypes.OP_DIVIDE) ||
           tokenType.equals(EnforceElementTypes.OP_DOT) ||
           tokenType.equals(EnforceElementTypes.OP_BANG) ||
           tokenType.equals(EnforceElementTypes.OP_MODULO)) return OPERATOR_KEYS;
        if(tokenType.equals(EnforceElementTypes.IDENTIFIER)) return IDENTIFIER_KEYS;
        if(tokenType.equals(EnforceElementTypes.COMMA)) return COMMA_KEYS;
        if(tokenType.equals(EnforceElementTypes.SEMICOLON)) return SEMICOLON_KEYS;
        if(tokenType.equals(TokenType.BAD_CHARACTER)) return BAD_CHAR_KEYS;
        return EMPTY_KEYS;
    }
}
