// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.rap.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.flipperplz.dayzdev.language.rap.psi.*;

public class RapStatementImpl extends ASTWrapperPsiElement implements RapStatement {

  public RapStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RapVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RapVisitor) accept((RapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RapArrayAppensionStatement getArrayAppensionStatement() {
    return findChildByClass(RapArrayAppensionStatement.class);
  }

  @Override
  @Nullable
  public RapArrayDeclaration getArrayDeclaration() {
    return findChildByClass(RapArrayDeclaration.class);
  }

  @Override
  @Nullable
  public RapClassDeclaration getClassDeclaration() {
    return findChildByClass(RapClassDeclaration.class);
  }

  @Override
  @Nullable
  public RapDeleteStatement getDeleteStatement() {
    return findChildByClass(RapDeleteStatement.class);
  }

  @Override
  @Nullable
  public RapExternalClassDeclaration getExternalClassDeclaration() {
    return findChildByClass(RapExternalClassDeclaration.class);
  }

  @Override
  @Nullable
  public RapTokenDeclaration getTokenDeclaration() {
    return findChildByClass(RapTokenDeclaration.class);
  }

}
