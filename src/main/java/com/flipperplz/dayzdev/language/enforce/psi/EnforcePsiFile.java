package com.flipperplz.dayzdev.language.enforce.psi;

import com.flipperplz.dayzdev.language.enforce.EnforceLanguage;
import com.flipperplz.dayzdev.language.enforce.EnforceLanguageFileType;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class EnforcePsiFile extends PsiFileBase {

    public EnforcePsiFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, EnforceLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return EnforceLanguageFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Enforce Script";
    }
}
