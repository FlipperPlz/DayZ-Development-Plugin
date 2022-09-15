// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.enforce.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EsVariableDeclaration extends PsiElement {

  @Nullable
  EsAttribute getAttribute();

  @NotNull
  EsClassReference getClassReference();

  @NotNull
  List<EsVariableDeclarator> getVariableDeclaratorList();

  @NotNull
  List<EsVariableModifier> getVariableModifierList();

}
