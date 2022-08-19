package com.flipperplz.dayzdev.language.enforce.psi;

import com.flipperplz.dayzdev.language.enforce.EnforceLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class EnforceElementType extends IElementType {

    public EnforceElementType(@NonNls @NotNull String debugName) {
        super(debugName, EnforceLanguage.INSTANCE);
    }
}
