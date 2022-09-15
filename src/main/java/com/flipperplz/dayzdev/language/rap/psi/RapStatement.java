// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.rap.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RapStatement extends PsiElement {

  @Nullable
  RapArrayAppensionStatement getArrayAppensionStatement();

  @Nullable
  RapArrayDeclaration getArrayDeclaration();

  @Nullable
  RapClassDeclaration getClassDeclaration();

  @Nullable
  RapDeleteStatement getDeleteStatement();

  @Nullable
  RapExternalClassDeclaration getExternalClassDeclaration();

  @Nullable
  RapTokenDeclaration getTokenDeclaration();

}
