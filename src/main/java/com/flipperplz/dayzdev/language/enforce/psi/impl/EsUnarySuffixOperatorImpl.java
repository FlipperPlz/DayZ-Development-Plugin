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

public class EsUnarySuffixOperatorImpl extends ASTWrapperPsiElement implements EsUnarySuffixOperator {

  public EsUnarySuffixOperatorImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EsVisitor visitor) {
    visitor.visitUnarySuffixOperator(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EsVisitor) accept((EsVisitor)visitor);
    else super.accept(visitor);
  }

}
