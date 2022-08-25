// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.enforce.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EsFunctionDeclaration extends PsiElement {

  @Nullable
  EsAttribute getAttribute();

  @NotNull
  EsClassReference getClassReference();

  @NotNull
  List<EsFunctionModifier> getFunctionModifierList();

  @NotNull
  EsFunctionName getFunctionName();

  @NotNull
  EsFunctionParameterList getFunctionParameterList();

  @NotNull
  EsStatement getStatement();

}
