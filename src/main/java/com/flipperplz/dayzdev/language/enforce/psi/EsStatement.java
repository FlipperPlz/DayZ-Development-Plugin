// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.enforce.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EsStatement extends PsiElement {

  @Nullable
  EsBlockStatement getBlockStatement();

  @Nullable
  EsBreakStatement getBreakStatement();

  @Nullable
  EsContinueStatement getContinueStatement();

  @Nullable
  EsDeleteStatement getDeleteStatement();

  @Nullable
  EsExpression getExpression();

  @Nullable
  EsForEachStatement getForEachStatement();

  @Nullable
  EsForStatement getForStatement();

  @Nullable
  EsGotoStatement getGotoStatement();

  @Nullable
  EsIfStatement getIfStatement();

  @Nullable
  EsLambdaStatement getLambdaStatement();

  @Nullable
  EsReturnStatement getReturnStatement();

  @Nullable
  EsSemicolonStatement getSemicolonStatement();

  @Nullable
  EsSwitchStatement getSwitchStatement();

  @Nullable
  EsThreadStatement getThreadStatement();

  @Nullable
  EsVariableDeclaration getVariableDeclaration();

  @Nullable
  EsWhileStatement getWhileStatement();

}
