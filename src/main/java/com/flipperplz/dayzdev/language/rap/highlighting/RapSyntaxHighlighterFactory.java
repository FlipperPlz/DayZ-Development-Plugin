package com.flipperplz.dayzdev.language.rap.highlighting;

import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RapSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
    @Override
    public @NotNull RapSyntaxHighlighter getSyntaxHighlighter(@Nullable Project project, @Nullable VirtualFile virtualFile) {
        return new RapSyntaxHighlighter();
    }
}
