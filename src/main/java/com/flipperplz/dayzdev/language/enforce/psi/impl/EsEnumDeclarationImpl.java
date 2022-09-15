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

public class EsEnumDeclarationImpl extends ASTWrapperPsiElement implements EsEnumDeclaration {

  public EsEnumDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EsVisitor visitor) {
    visitor.visitEnumDeclaration(this);
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
  @Nullable
  public EsClassExtension getClassExtension() {
    return findChildByClass(EsClassExtension.class);
  }

  @Override
  @NotNull
  public List<EsClassModifier> getClassModifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EsClassModifier.class);
  }

  @Override
  @NotNull
  public EsClassname getClassname() {
    return findNotNullChildByClass(EsClassname.class);
  }

  @Override
  @NotNull
  public List<EsEnumValue> getEnumValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EsEnumValue.class);
  }

}
