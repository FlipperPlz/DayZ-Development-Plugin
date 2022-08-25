// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.rap.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static com.flipperplz.dayzdev.language.rap.psi.RapElementTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.flipperplz.dayzdev.language.rap.psi.*;

public class RapVariableNameImpl extends ASTWrapperPsiElement implements RapVariableName {

  public RapVariableNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RapVisitor visitor) {
    visitor.visitVariableName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RapVisitor) accept((RapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
