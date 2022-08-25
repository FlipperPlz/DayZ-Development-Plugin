// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.rap.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.flipperplz.dayzdev.language.rap.psi.impl.*;

public interface RapElementTypes {

  IElementType ARRAY_APPENSION_STATEMENT = new RapElementType("ARRAY_APPENSION_STATEMENT");
  IElementType ARRAY_DECLARATION = new RapElementType("ARRAY_DECLARATION");
  IElementType ARRAY_NAME = new RapElementType("ARRAY_NAME");
  IElementType ARRAY_VALUE = new RapElementType("ARRAY_VALUE");
  IElementType CLASS_DECLARATION = new RapElementType("CLASS_DECLARATION");
  IElementType CLASS_EXTENSION = new RapElementType("CLASS_EXTENSION");
  IElementType CLASS_NAME = new RapElementType("CLASS_NAME");
  IElementType DELETE_STATEMENT = new RapElementType("DELETE_STATEMENT");
  IElementType EXTERNAL_CLASS_DECLARATION = new RapElementType("EXTERNAL_CLASS_DECLARATION");
  IElementType LITERAL_ARRAY = new RapElementType("LITERAL_ARRAY");
  IElementType STATEMENT = new RapElementType("STATEMENT");
  IElementType STATEMENT_BLOCK = new RapElementType("STATEMENT_BLOCK");
  IElementType TOKEN_DECLARATION = new RapElementType("TOKEN_DECLARATION");
  IElementType TOKEN_VALUE = new RapElementType("TOKEN_VALUE");
  IElementType VARIABLE_NAME = new RapElementType("VARIABLE_NAME");

  IElementType APPEND = new RapTokenType("append");
  IElementType ASSIGN = new RapTokenType("assign");
  IElementType CLASS = new RapTokenType("class");
  IElementType COLON = new RapTokenType("colon");
  IElementType COMMA = new RapTokenType("comma");
  IElementType DELETE = new RapTokenType("delete");
  IElementType DELIMITED_COMMENT = new RapTokenType("DELIMITED_COMMENT");
  IElementType EMPTY_DELIMITED_COMMENT = new RapTokenType("EMPTY_DELIMITED_COMMENT");
  IElementType IDENTIFIER = new RapTokenType("IDENTIFIER");
  IElementType LCURLY = new RapTokenType("lcurly");
  IElementType LITERALFLOAT = new RapTokenType("LITERALFLOAT");
  IElementType LITERALINTEGER = new RapTokenType("LITERALINTEGER");
  IElementType LITERALSTRING = new RapTokenType("LITERALSTRING");
  IElementType LSBRACKET = new RapTokenType("lsbracket");
  IElementType RCURLY = new RapTokenType("rcurly");
  IElementType RSBRACKET = new RapTokenType("rsbracket");
  IElementType SEMICOLON = new RapTokenType("semicolon");
  IElementType SINGLE_LINE_COMMENT = new RapTokenType("SINGLE_LINE_COMMENT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY_APPENSION_STATEMENT) {
        return new RapArrayAppensionStatementImpl(node);
      }
      else if (type == ARRAY_DECLARATION) {
        return new RapArrayDeclarationImpl(node);
      }
      else if (type == ARRAY_NAME) {
        return new RapArrayNameImpl(node);
      }
      else if (type == ARRAY_VALUE) {
        return new RapArrayValueImpl(node);
      }
      else if (type == CLASS_DECLARATION) {
        return new RapClassDeclarationImpl(node);
      }
      else if (type == CLASS_EXTENSION) {
        return new RapClassExtensionImpl(node);
      }
      else if (type == CLASS_NAME) {
        return new RapClassNameImpl(node);
      }
      else if (type == DELETE_STATEMENT) {
        return new RapDeleteStatementImpl(node);
      }
      else if (type == EXTERNAL_CLASS_DECLARATION) {
        return new RapExternalClassDeclarationImpl(node);
      }
      else if (type == LITERAL_ARRAY) {
        return new RapLiteralArrayImpl(node);
      }
      else if (type == STATEMENT) {
        return new RapStatementImpl(node);
      }
      else if (type == STATEMENT_BLOCK) {
        return new RapStatementBlockImpl(node);
      }
      else if (type == TOKEN_DECLARATION) {
        return new RapTokenDeclarationImpl(node);
      }
      else if (type == TOKEN_VALUE) {
        return new RapTokenValueImpl(node);
      }
      else if (type == VARIABLE_NAME) {
        return new RapVariableNameImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
