// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.enforce.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EsForEachStatement extends PsiElement {

  @NotNull
  EsExpression getExpression();

  @NotNull
  List<EsForEachVariable> getForEachVariableList();

  @NotNull
  EsStatement getStatement();

}
