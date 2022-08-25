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

public class EsStatementImpl extends ASTWrapperPsiElement implements EsStatement {

  public EsStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EsVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EsVisitor) accept((EsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public EsBlockStatement getBlockStatement() {
    return findChildByClass(EsBlockStatement.class);
  }

  @Override
  @Nullable
  public EsBreakStatement getBreakStatement() {
    return findChildByClass(EsBreakStatement.class);
  }

  @Override
  @Nullable
  public EsContinueStatement getContinueStatement() {
    return findChildByClass(EsContinueStatement.class);
  }

  @Override
  @Nullable
  public EsDeleteStatement getDeleteStatement() {
    return findChildByClass(EsDeleteStatement.class);
  }

  @Override
  @Nullable
  public EsExpression getExpression() {
    return findChildByClass(EsExpression.class);
  }

  @Override
  @Nullable
  public EsForEachStatement getForEachStatement() {
    return findChildByClass(EsForEachStatement.class);
  }

  @Override
  @Nullable
  public EsForStatement getForStatement() {
    return findChildByClass(EsForStatement.class);
  }

  @Override
  @Nullable
  public EsGotoStatement getGotoStatement() {
    return findChildByClass(EsGotoStatement.class);
  }

  @Override
  @Nullable
  public EsIfStatement getIfStatement() {
    return findChildByClass(EsIfStatement.class);
  }

  @Override
  @Nullable
  public EsLambdaStatement getLambdaStatement() {
    return findChildByClass(EsLambdaStatement.class);
  }

  @Override
  @Nullable
  public EsReturnStatement getReturnStatement() {
    return findChildByClass(EsReturnStatement.class);
  }

  @Override
  @Nullable
  public EsSemicolonStatement getSemicolonStatement() {
    return findChildByClass(EsSemicolonStatement.class);
  }

  @Override
  @Nullable
  public EsSwitchStatement getSwitchStatement() {
    return findChildByClass(EsSwitchStatement.class);
  }

  @Override
  @Nullable
  public EsThreadStatement getThreadStatement() {
    return findChildByClass(EsThreadStatement.class);
  }

  @Override
  @Nullable
  public EsVariableDeclaration getVariableDeclaration() {
    return findChildByClass(EsVariableDeclaration.class);
  }

  @Override
  @Nullable
  public EsWhileStatement getWhileStatement() {
    return findChildByClass(EsWhileStatement.class);
  }

}
