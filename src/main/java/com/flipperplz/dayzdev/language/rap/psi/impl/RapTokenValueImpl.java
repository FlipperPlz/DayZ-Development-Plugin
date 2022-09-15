// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.rap.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static com.flipperplz.dayzdev.language.rap.psi.RapElementTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.flipperplz.dayzdev.language.rap.psi.*;

public class RapTokenValueImpl extends ASTWrapperPsiElement implements RapTokenValue {

  public RapTokenValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RapVisitor visitor) {
    visitor.visitTokenValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RapVisitor) accept((RapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getLiteralfloat() {
    return findChildByType(LITERALFLOAT);
  }

  @Override
  @Nullable
  public PsiElement getLiteralinteger() {
    return findChildByType(LITERALINTEGER);
  }

  @Override
  @Nullable
  public PsiElement getLiteralstring() {
    return findChildByType(LITERALSTRING);
  }

}
