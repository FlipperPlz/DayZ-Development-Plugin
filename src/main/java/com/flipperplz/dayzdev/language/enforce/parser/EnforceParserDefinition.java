package com.flipperplz.dayzdev.language.enforce.parser;

import com.flipperplz.dayzdev.language.enforce.lexer.EnforceLexerAdapter;
import com.flipperplz.dayzdev.language.enforce.psi.EnforceElementTypes;
import com.flipperplz.dayzdev.language.enforce.psi.EnforcePsiFile;
import com.flipperplz.dayzdev.language.rap.RapLanguage;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class EnforceParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(RapLanguage.INSTANCE);
    public static final TokenSet COMMENTS = TokenSet.create(
            EnforceElementTypes.EMPTY_DELIMITED_COMMENT,
            EnforceElementTypes.DELIMITED_COMMENT,
            EnforceElementTypes.SINGLE_LINE_COMMENT
    );
    public static final TokenSet STRINGS = TokenSet.WHITE_SPACE;

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new EnforceLexerAdapter();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new EnforceParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return EnforceElementTypes.Factory.createElement(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new EnforcePsiFile(viewProvider);
    }
}
