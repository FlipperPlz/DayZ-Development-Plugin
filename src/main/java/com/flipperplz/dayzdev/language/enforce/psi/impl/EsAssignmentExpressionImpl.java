// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.enforce.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flipperplz.dayzdev.language.enforce.psi.EnforceElementTypes.*;
import com.flipperplz.dayzdev.language.enforce.psi.*;

public class EsAssignmentExpressionImpl extends EsExpressionImpl implements EsAssignmentExpression {

  public EsAssignmentExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull EsVisitor visitor) {
    visitor.visitAssignmentExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EsVisitor) accept((EsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public EsAssignmentOperator getAssignmentOperator() {
    return findNotNullChildByClass(EsAssignmentOperator.class);
  }

  @Override
  @NotNull
  public List<EsExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EsExpression.class);
  }

}
