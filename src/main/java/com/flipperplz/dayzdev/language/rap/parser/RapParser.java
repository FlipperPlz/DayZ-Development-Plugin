// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.rap.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.flipperplz.dayzdev.language.rap.psi.RapElementTypes.*;
import static com.flipperplz.dayzdev.language.rap.parser.RapParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RapParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return ParamFile(b, l + 1);
  }

  /* ********************************************************** */
  // ArrayName append LiteralArray semicolon
  public static boolean ArrayAppensionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayAppensionStatement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArrayName(b, l + 1);
    r = r && consumeToken(b, APPEND);
    r = r && LiteralArray(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, ARRAY_APPENSION_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ArrayName assign LiteralArray semicolon
  public static boolean ArrayDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArrayName(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && LiteralArray(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, ARRAY_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // VariableName lsbracket rsbracket
  public static boolean ArrayName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableName(b, l + 1);
    r = r && consumeTokens(b, 0, LSBRACKET, RSBRACKET);
    exit_section_(b, m, ARRAY_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // TokenValue | LiteralArray
  public static boolean ArrayValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_VALUE, "<array value>");
    r = TokenValue(b, l + 1);
    if (!r) r = LiteralArray(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // class ClassName (ClassExtension)? StatementBlock semicolon
  public static boolean ClassDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration")) return false;
    if (!nextTokenIs(b, CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS);
    r = r && ClassName(b, l + 1);
    r = r && ClassDeclaration_2(b, l + 1);
    r = r && StatementBlock(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, CLASS_DECLARATION, r);
    return r;
  }

  // (ClassExtension)?
  private static boolean ClassDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_2")) return false;
    ClassDeclaration_2_0(b, l + 1);
    return true;
  }

  // (ClassExtension)
  private static boolean ClassDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ClassExtension(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // colon ClassName
  public static boolean ClassExtension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassExtension")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && ClassName(b, l + 1);
    exit_section_(b, m, CLASS_EXTENSION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean ClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CLASS_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // delete ClassName semicolon
  public static boolean DeleteStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeleteStatement")) return false;
    if (!nextTokenIs(b, DELETE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DELETE);
    r = r && ClassName(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, DELETE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // class ClassName semicolon
  public static boolean ExternalClassDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExternalClassDeclaration")) return false;
    if (!nextTokenIs(b, CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS);
    r = r && ClassName(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, EXTERNAL_CLASS_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // lcurly (ArrayValue (comma ArrayValue)* comma?)? rcurly
  public static boolean LiteralArray(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralArray")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && LiteralArray_1(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, LITERAL_ARRAY, r);
    return r;
  }

  // (ArrayValue (comma ArrayValue)* comma?)?
  private static boolean LiteralArray_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralArray_1")) return false;
    LiteralArray_1_0(b, l + 1);
    return true;
  }

  // ArrayValue (comma ArrayValue)* comma?
  private static boolean LiteralArray_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralArray_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArrayValue(b, l + 1);
    r = r && LiteralArray_1_0_1(b, l + 1);
    r = r && LiteralArray_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comma ArrayValue)*
  private static boolean LiteralArray_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralArray_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!LiteralArray_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LiteralArray_1_0_1", c)) break;
    }
    return true;
  }

  // comma ArrayValue
  private static boolean LiteralArray_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralArray_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ArrayValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma?
  private static boolean LiteralArray_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralArray_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // Statement*
  static boolean ParamFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParamFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // DeleteStatement            |
  //              ArrayAppensionStatement    |
  //              ExternalClassDeclaration   |
  //              ClassDeclaration           |
  //              ArrayDeclaration           |
  //              TokenDeclaration
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = DeleteStatement(b, l + 1);
    if (!r) r = ArrayAppensionStatement(b, l + 1);
    if (!r) r = ExternalClassDeclaration(b, l + 1);
    if (!r) r = ClassDeclaration(b, l + 1);
    if (!r) r = ArrayDeclaration(b, l + 1);
    if (!r) r = TokenDeclaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // lcurly Statement* rcurly
  public static boolean StatementBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && StatementBlock_1(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, STATEMENT_BLOCK, r);
    return r;
  }

  // Statement*
  private static boolean StatementBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StatementBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VariableName assign TokenValue semicolon
  public static boolean TokenDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TokenDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableName(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && TokenValue(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, TOKEN_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // LITERALSTRING | LITERALINTEGER | LITERALFLOAT
  public static boolean TokenValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TokenValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOKEN_VALUE, "<token value>");
    r = consumeToken(b, LITERALSTRING);
    if (!r) r = consumeToken(b, LITERALINTEGER);
    if (!r) r = consumeToken(b, LITERALFLOAT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean VariableName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE_NAME, r);
    return r;
  }

}
