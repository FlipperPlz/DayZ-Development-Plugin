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

public class EsObjectCreationExpressionImpl extends EsExpressionImpl implements EsObjectCreationExpression {

  public EsObjectCreationExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull EsVisitor visitor) {
    visitor.visitObjectCreationExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EsVisitor) accept((EsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public EsClassReference getClassReference() {
    return findNotNullChildByClass(EsClassReference.class);
  }

  @Override
  @Nullable
  public EsFunctionCallParameterList getFunctionCallParameterList() {
    return findChildByClass(EsFunctionCallParameterList.class);
  }

  @Override
  @NotNull
  public List<EsVariableModifier> getVariableModifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EsVariableModifier.class);
  }

}
