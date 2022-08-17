package com.flipperplz.dayzdev.language.rap.psi;

import com.flipperplz.dayzdev.language.rap.RapLanguage;
import com.flipperplz.dayzdev.language.rap.RapLanguageFileType;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class RapPsiFile extends PsiFileBase {

    public RapPsiFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, RapLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return RapLanguageFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Parameter File";
    }
}
