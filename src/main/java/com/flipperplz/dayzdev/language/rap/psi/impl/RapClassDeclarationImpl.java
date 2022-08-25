// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.rap.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.flipperplz.dayzdev.language.rap.psi.*;

public class RapClassDeclarationImpl extends ASTWrapperPsiElement implements RapClassDeclaration {

  public RapClassDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RapVisitor visitor) {
    visitor.visitClassDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RapVisitor) accept((RapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RapClassExtension getClassExtension() {
    return findChildByClass(RapClassExtension.class);
  }

  @Override
  @NotNull
  public RapClassName getClassName() {
    return findNotNullChildByClass(RapClassName.class);
  }

  @Override
  @NotNull
  public RapStatementBlock getStatementBlock() {
    return findNotNullChildByClass(RapStatementBlock.class);
  }

}
