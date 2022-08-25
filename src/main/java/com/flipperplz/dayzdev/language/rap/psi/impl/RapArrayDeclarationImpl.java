// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.rap.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.flipperplz.dayzdev.language.rap.psi.*;

public class RapArrayDeclarationImpl extends ASTWrapperPsiElement implements RapArrayDeclaration {

  public RapArrayDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RapVisitor visitor) {
    visitor.visitArrayDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RapVisitor) accept((RapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RapArrayName getArrayName() {
    return findNotNullChildByClass(RapArrayName.class);
  }

  @Override
  @NotNull
  public RapLiteralArray getLiteralArray() {
    return findNotNullChildByClass(RapLiteralArray.class);
  }

}
