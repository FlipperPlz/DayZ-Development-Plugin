// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.rap.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.flipperplz.dayzdev.language.rap.psi.*;

public class RapTokenDeclarationImpl extends ASTWrapperPsiElement implements RapTokenDeclaration {

  public RapTokenDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RapVisitor visitor) {
    visitor.visitTokenDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RapVisitor) accept((RapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RapTokenValue getTokenValue() {
    return findNotNullChildByClass(RapTokenValue.class);
  }

  @Override
  @NotNull
  public RapVariableName getVariableName() {
    return findNotNullChildByClass(RapVariableName.class);
  }

}
