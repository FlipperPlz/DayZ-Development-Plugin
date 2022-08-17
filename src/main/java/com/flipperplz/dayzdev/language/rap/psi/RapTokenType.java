package com.flipperplz.dayzdev.language.rap.psi;

import com.flipperplz.dayzdev.language.rap.RapLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class RapTokenType extends IElementType {
    public RapTokenType(@NonNls @NotNull String debugName) {
        super(debugName, RapLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return RapTokenType.class.getName() + "." + super.toString();
    }
}
