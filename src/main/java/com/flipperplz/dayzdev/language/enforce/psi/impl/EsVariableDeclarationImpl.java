// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.enforce.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flipperplz.dayzdev.language.enforce.psi.EnforceElementTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.flipperplz.dayzdev.language.enforce.psi.*;

public class EsVariableDeclarationImpl extends ASTWrapperPsiElement implements EsVariableDeclaration {

  public EsVariableDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EsVisitor visitor) {
    visitor.visitVariableDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EsVisitor) accept((EsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public EsAttribute getAttribute() {
    return findChildByClass(EsAttribute.class);
  }

  @Override
  @NotNull
  public EsClassReference getClassReference() {
    return findNotNullChildByClass(EsClassReference.class);
  }

  @Override
  @NotNull
  public List<EsVariableDeclarator> getVariableDeclaratorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EsVariableDeclarator.class);
  }

  @Override
  @NotNull
  public List<EsVariableModifier> getVariableModifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EsVariableModifier.class);
  }

}
