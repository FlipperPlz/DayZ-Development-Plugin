// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.enforce.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EsEnumDeclaration extends PsiElement {

  @Nullable
  EsAttribute getAttribute();

  @Nullable
  EsClassExtension getClassExtension();

  @NotNull
  List<EsClassModifier> getClassModifierList();

  @NotNull
  EsClassname getClassname();

  @NotNull
  List<EsEnumValue> getEnumValueList();

}
