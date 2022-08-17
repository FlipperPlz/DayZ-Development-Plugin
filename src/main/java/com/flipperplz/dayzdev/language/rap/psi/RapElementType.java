package com.flipperplz.dayzdev.language.rap.psi;

import com.flipperplz.dayzdev.language.rap.RapLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class RapElementType extends IElementType {
    public RapElementType(@NonNls @NotNull String debugName) {
        super(debugName, RapLanguage.INSTANCE);
    }
}
