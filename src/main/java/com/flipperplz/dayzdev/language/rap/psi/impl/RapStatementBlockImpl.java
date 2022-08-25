// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.rap.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.flipperplz.dayzdev.language.rap.psi.*;

public class RapStatementBlockImpl extends ASTWrapperPsiElement implements RapStatementBlock {

  public RapStatementBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RapVisitor visitor) {
    visitor.visitStatementBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RapVisitor) accept((RapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RapStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RapStatement.class);
  }

}
