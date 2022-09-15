// This is a generated file. Not intended for manual editing.
package com.flipperplz.dayzdev.language.enforce.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.flipperplz.dayzdev.language.enforce.psi.EnforceElementTypes.*;
import static com.flipperplz.dayzdev.language.enforce.parser.EnforceParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class EnforceParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return File(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ARITHMETIC_EXPRESSION, ARRAY_INDEX_EXPRESSION, ASSIGNMENT_EXPRESSION, CAST_EXPRESSION,
      EXPRESSION, LITERAL_ARRAY, LITERAL_BOOLEAN, LITERAL_FLOAT,
      LITERAL_INTEGER, LITERAL_NULL, LITERAL_STRING, LOGICAL_EXPRESSION,
      OBJECT_CREATION_EXPRESSION, PARENTHESISED_EXPRESSION, PRIMARY_EXPRESSION, RELATIVE_EXPRESSION,
      SUPER_EXPRESSION, THIS_EXPRESSION, UNARY_PREFIX_EXPRESSION, UNARY_SUFFIX_EXPRESSION),
  };

  /* ********************************************************** */
  // OP_MULTIPLY | OP_DIVIDE | OP_MODULO | OP_ADD | OP_SUBTRACT | OP_LSHIFT | OP_RSHIFT | OP_BITWISE_OR | OP_BITWISE_AND | OP_BITWISE_NOT | OP_BITWISE_XOR
  public static boolean ArithmeticOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArithmeticOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARITHMETIC_OPERATOR, "<arithmetic operator>");
    r = consumeToken(b, OP_MULTIPLY);
    if (!r) r = consumeToken(b, OP_DIVIDE);
    if (!r) r = consumeToken(b, OP_MODULO);
    if (!r) r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_SUBTRACT);
    if (!r) r = consumeToken(b, OP_LSHIFT);
    if (!r) r = consumeToken(b, OP_RSHIFT);
    if (!r) r = consumeToken(b, OP_BITWISE_OR);
    if (!r) r = consumeToken(b, OP_BITWISE_AND);
    if (!r) r = consumeToken(b, OP_BITWISE_NOT);
    if (!r) r = consumeToken(b, OP_BITWISE_XOR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' Expression? ']'
  public static boolean ArrayIndex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayIndex")) return false;
    if (!nextTokenIs(b, LSBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSBRACKET);
    r = r && ArrayIndex_1(b, l + 1);
    r = r && consumeToken(b, RSBRACKET);
    exit_section_(b, m, ARRAY_INDEX, r);
    return r;
  }

  // Expression?
  private static boolean ArrayIndex_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayIndex_1")) return false;
    Expression(b, l + 1, -1);
    return true;
  }

  /* ********************************************************** */
  // OP_ASSIGN | OP_ADD_ASSIGN | OP_SUBTRACT_ASSIGN | OP_MULTIPLY_ASSIGN | OP_DIVIDE_ASSIGN | OP_OR_ASSIGN | OP_AND_ASSIGN | OP_LSHIFT_ASSIGN | OP_RSHIFT_ASSIGN
  public static boolean AssignmentOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_OPERATOR, "<assignment operator>");
    r = consumeToken(b, OP_ASSIGN);
    if (!r) r = consumeToken(b, OP_ADD_ASSIGN);
    if (!r) r = consumeToken(b, OP_SUBTRACT_ASSIGN);
    if (!r) r = consumeToken(b, OP_MULTIPLY_ASSIGN);
    if (!r) r = consumeToken(b, OP_DIVIDE_ASSIGN);
    if (!r) r = consumeToken(b, OP_OR_ASSIGN);
    if (!r) r = consumeToken(b, OP_AND_ASSIGN);
    if (!r) r = consumeToken(b, OP_LSHIFT_ASSIGN);
    if (!r) r = consumeToken(b, OP_RSHIFT_ASSIGN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' FunctionCall ']'
  public static boolean Attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attribute")) return false;
    if (!nextTokenIs(b, LSBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSBRACKET);
    r = r && FunctionCall(b, l + 1);
    r = r && consumeToken(b, RSBRACKET);
    exit_section_(b, m, ATTRIBUTE, r);
    return r;
  }

  /* ********************************************************** */
  // ('{' Statement* '}') ';'?
  public static boolean BlockStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockStatement")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BlockStatement_0(b, l + 1);
    r = r && BlockStatement_1(b, l + 1);
    exit_section_(b, m, BLOCK_STATEMENT, r);
    return r;
  }

  // '{' Statement* '}'
  private static boolean BlockStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && BlockStatement_0_1(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, null, r);
    return r;
  }

  // Statement*
  private static boolean BlockStatement_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockStatement_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "BlockStatement_0_1", c)) break;
    }
    return true;
  }

  // ';'?
  private static boolean BlockStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockStatement_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // break ';'
  public static boolean BreakStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStatement")) return false;
    if (!nextTokenIs(b, BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BREAK, SEMICOLON);
    exit_section_(b, m, BREAK_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Attribute? ClassModifier* class Classname TypeDeclarationList? ClassExtension? VarAndFunctionBlock SEMICOLON?
  public static boolean ClassDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_DECLARATION, "<class declaration>");
    r = ClassDeclaration_0(b, l + 1);
    r = r && ClassDeclaration_1(b, l + 1);
    r = r && consumeToken(b, CLASS);
    r = r && Classname(b, l + 1);
    r = r && ClassDeclaration_4(b, l + 1);
    r = r && ClassDeclaration_5(b, l + 1);
    r = r && VarAndFunctionBlock(b, l + 1);
    r = r && ClassDeclaration_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Attribute?
  private static boolean ClassDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_0")) return false;
    Attribute(b, l + 1);
    return true;
  }

  // ClassModifier*
  private static boolean ClassDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ClassModifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClassDeclaration_1", c)) break;
    }
    return true;
  }

  // TypeDeclarationList?
  private static boolean ClassDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_4")) return false;
    TypeDeclarationList(b, l + 1);
    return true;
  }

  // ClassExtension?
  private static boolean ClassDeclaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_5")) return false;
    ClassExtension(b, l + 1);
    return true;
  }

  // SEMICOLON?
  private static boolean ClassDeclaration_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_7")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // (extends | ':') ClassReference
  public static boolean ClassExtension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassExtension")) return false;
    if (!nextTokenIs(b, "<class extension>", COLON, EXTENDS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_EXTENSION, "<class extension>");
    r = ClassExtension_0(b, l + 1);
    r = r && ClassReference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // extends | ':'
  private static boolean ClassExtension_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassExtension_0")) return false;
    boolean r;
    r = consumeToken(b, EXTENDS);
    if (!r) r = consumeToken(b, COLON);
    return r;
  }

  /* ********************************************************** */
  // modded | sealed
  public static boolean ClassModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassModifier")) return false;
    if (!nextTokenIs(b, "<class modifier>", MODDED, SEALED)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_MODIFIER, "<class modifier>");
    r = consumeToken(b, MODDED);
    if (!r) r = consumeToken(b, SEALED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Classname TypeList?
  public static boolean ClassReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassReference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Classname(b, l + 1);
    r = r && ClassReference_1(b, l + 1);
    exit_section_(b, m, CLASS_REFERENCE, r);
    return r;
  }

  // TypeList?
  private static boolean ClassReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassReference_1")) return false;
    TypeList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean Classname(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Classname")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CLASSNAME, r);
    return r;
  }

  /* ********************************************************** */
  // <<p>> (',' <<p>>)*
  static boolean CommaSeperatedList(PsiBuilder b, int l, Parser _p) {
    if (!recursion_guard_(b, l, "CommaSeperatedList")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _p.parse(b, l);
    r = r && CommaSeperatedList_1(b, l + 1, _p);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' <<p>>)*
  private static boolean CommaSeperatedList_1(PsiBuilder b, int l, Parser _p) {
    if (!recursion_guard_(b, l, "CommaSeperatedList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CommaSeperatedList_1_0(b, l + 1, _p)) break;
      if (!empty_element_parsed_guard_(b, "CommaSeperatedList_1", c)) break;
    }
    return true;
  }

  // ',' <<p>>
  private static boolean CommaSeperatedList_1_0(PsiBuilder b, int l, Parser _p) {
    if (!recursion_guard_(b, l, "CommaSeperatedList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && _p.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OP_INEQUAL | OP_EQUAL | OP_LESS_EQUAL | OP_GREATER_EQUAL | OP_LESS | OP_GREATER
  public static boolean ComparativeOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComparativeOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARATIVE_OPERATOR, "<comparative operator>");
    r = consumeToken(b, OP_INEQUAL);
    if (!r) r = consumeToken(b, OP_EQUAL);
    if (!r) r = consumeToken(b, OP_LESS_EQUAL);
    if (!r) r = consumeToken(b, OP_GREATER_EQUAL);
    if (!r) r = consumeToken(b, OP_LESS);
    if (!r) r = consumeToken(b, OP_GREATER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // continue ';'
  public static boolean ContinueStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContinueStatement")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CONTINUE, SEMICOLON);
    exit_section_(b, m, CONTINUE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // 'default' ':' Statement*
  public static boolean DefaultSwitchLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefaultSwitchLabel")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFAULT_SWITCH_LABEL, "<default switch label>");
    r = consumeToken(b, "default");
    r = r && consumeToken(b, COLON);
    r = r && DefaultSwitchLabel_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Statement*
  private static boolean DefaultSwitchLabel_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefaultSwitchLabel_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DefaultSwitchLabel_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // delete Expression ';'
  public static boolean DeleteStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeleteStatement")) return false;
    if (!nextTokenIs(b, DELETE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DELETE);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, DELETE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // else Statement
  public static boolean ElseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElseStatement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, ELSE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Attribute? ClassModifier* enum Classname ClassExtension? '{' <<CommaSeperatedList EnumValue>>? '}' ';'?
  public static boolean EnumDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DECLARATION, "<enum declaration>");
    r = EnumDeclaration_0(b, l + 1);
    r = r && EnumDeclaration_1(b, l + 1);
    r = r && consumeToken(b, ENUM);
    r = r && Classname(b, l + 1);
    r = r && EnumDeclaration_4(b, l + 1);
    r = r && consumeToken(b, LCURLY);
    r = r && EnumDeclaration_6(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    r = r && EnumDeclaration_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Attribute?
  private static boolean EnumDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration_0")) return false;
    Attribute(b, l + 1);
    return true;
  }

  // ClassModifier*
  private static boolean EnumDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ClassModifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EnumDeclaration_1", c)) break;
    }
    return true;
  }

  // ClassExtension?
  private static boolean EnumDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration_4")) return false;
    ClassExtension(b, l + 1);
    return true;
  }

  // <<CommaSeperatedList EnumValue>>?
  private static boolean EnumDeclaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration_6")) return false;
    CommaSeperatedList(b, l + 1, EnforceParser::EnumValue);
    return true;
  }

  // ';'?
  private static boolean EnumDeclaration_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration_8")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // VariableName (OP_ASSIGN Expression)?
  public static boolean EnumValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumValue")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableName(b, l + 1);
    r = r && EnumValue_1(b, l + 1);
    exit_section_(b, m, ENUM_VALUE, r);
    return r;
  }

  // (OP_ASSIGN Expression)?
  private static boolean EnumValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumValue_1")) return false;
    EnumValue_1_0(b, l + 1);
    return true;
  }

  // OP_ASSIGN Expression
  private static boolean EnumValue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumValue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_ASSIGN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (GlobalDeclaration | TypeDeclaration)*
  static boolean File(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "File")) return false;
    while (true) {
      int c = current_position_(b);
      if (!File_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "File", c)) break;
    }
    return true;
  }

  // GlobalDeclaration | TypeDeclaration
  private static boolean File_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "File_0")) return false;
    boolean r;
    r = GlobalDeclaration(b, l + 1);
    if (!r) r = TypeDeclaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '(' Statement ';'? Expression ';'? Expression? ')'
  public static boolean ForControl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForControl")) return false;
    if (!nextTokenIs(b, LPARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARENTHESIS);
    r = r && Statement(b, l + 1);
    r = r && ForControl_2(b, l + 1);
    r = r && Expression(b, l + 1, -1);
    r = r && ForControl_4(b, l + 1);
    r = r && ForControl_5(b, l + 1);
    r = r && consumeToken(b, RPARENTHESIS);
    exit_section_(b, m, FOR_CONTROL, r);
    return r;
  }

  // ';'?
  private static boolean ForControl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForControl_2")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  // ';'?
  private static boolean ForControl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForControl_4")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  // Expression?
  private static boolean ForControl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForControl_5")) return false;
    Expression(b, l + 1, -1);
    return true;
  }

  /* ********************************************************** */
  // foreach '(' <<CommaSeperatedList ForEachVariable>> ':' Expression ')' Statement
  public static boolean ForEachStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForEachStatement")) return false;
    if (!nextTokenIs(b, FOREACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOREACH, LPARENTHESIS);
    r = r && CommaSeperatedList(b, l + 1, EnforceParser::ForEachVariable);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, RPARENTHESIS);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, FOR_EACH_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // VariableModifier* ClassReference VariableName
  public static boolean ForEachVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForEachVariable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_EACH_VARIABLE, "<for each variable>");
    r = ForEachVariable_0(b, l + 1);
    r = r && ClassReference(b, l + 1);
    r = r && VariableName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VariableModifier*
  private static boolean ForEachVariable_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForEachVariable_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VariableModifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ForEachVariable_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // for ForControl Statement
  public static boolean ForStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && ForControl(b, l + 1);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // FunctionName FunctionCallParameterList
  public static boolean FunctionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionName(b, l + 1);
    r = r && FunctionCallParameterList(b, l + 1);
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // Expression | OptionalFunctionCallParam
  public static boolean FunctionCallParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCallParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL_PARAMETER, "<function call parameter>");
    r = Expression(b, l + 1, -1);
    if (!r) r = OptionalFunctionCallParam(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' <<CommaSeperatedList FunctionCallParameter>>? ')'
  public static boolean FunctionCallParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCallParameterList")) return false;
    if (!nextTokenIs(b, LPARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARENTHESIS);
    r = r && FunctionCallParameterList_1(b, l + 1);
    r = r && consumeToken(b, RPARENTHESIS);
    exit_section_(b, m, FUNCTION_CALL_PARAMETER_LIST, r);
    return r;
  }

  // <<CommaSeperatedList FunctionCallParameter>>?
  private static boolean FunctionCallParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCallParameterList_1")) return false;
    CommaSeperatedList(b, l + 1, EnforceParser::FunctionCallParameter);
    return true;
  }

  /* ********************************************************** */
  // Attribute? FunctionModifier* ClassReference ('[' ']')? '~'? FunctionName FunctionParameterList Statement ';'?
  public static boolean FunctionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECLARATION, "<function declaration>");
    r = FunctionDeclaration_0(b, l + 1);
    r = r && FunctionDeclaration_1(b, l + 1);
    r = r && ClassReference(b, l + 1);
    r = r && FunctionDeclaration_3(b, l + 1);
    r = r && FunctionDeclaration_4(b, l + 1);
    r = r && FunctionName(b, l + 1);
    r = r && FunctionParameterList(b, l + 1);
    r = r && Statement(b, l + 1);
    r = r && FunctionDeclaration_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Attribute?
  private static boolean FunctionDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_0")) return false;
    Attribute(b, l + 1);
    return true;
  }

  // FunctionModifier*
  private static boolean FunctionDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FunctionModifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionDeclaration_1", c)) break;
    }
    return true;
  }

  // ('[' ']')?
  private static boolean FunctionDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_3")) return false;
    FunctionDeclaration_3_0(b, l + 1);
    return true;
  }

  // '[' ']'
  private static boolean FunctionDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LSBRACKET, RSBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // '~'?
  private static boolean FunctionDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_4")) return false;
    consumeToken(b, OP_BITWISE_NOT);
    return true;
  }

  // ';'?
  private static boolean FunctionDeclaration_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_8")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // private | protected | external | static | override | owned | ref | reference | proto | native | volatile | event
  public static boolean FunctionModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionModifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_MODIFIER, "<function modifier>");
    r = consumeToken(b, PRIVATE);
    if (!r) r = consumeToken(b, PROTECTED);
    if (!r) r = consumeToken(b, EXTERNAL);
    if (!r) r = consumeToken(b, STATIC);
    if (!r) r = consumeToken(b, OVERRIDE);
    if (!r) r = consumeToken(b, OWNED);
    if (!r) r = consumeToken(b, REF);
    if (!r) r = consumeToken(b, REFERENCE);
    if (!r) r = consumeToken(b, PROTO);
    if (!r) r = consumeToken(b, NATIVE);
    if (!r) r = consumeToken(b, VOLATILE);
    if (!r) r = consumeToken(b, EVENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean FunctionName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNCTION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // VariableModifier* ClassReference VariableDeclarator
  public static boolean FunctionParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_PARAMETER, "<function parameter>");
    r = FunctionParameter_0(b, l + 1);
    r = r && ClassReference(b, l + 1);
    r = r && VariableDeclarator(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VariableModifier*
  private static boolean FunctionParameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VariableModifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionParameter_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '(' (<<CommaSeperatedList FunctionParameter>>)? ')'
  public static boolean FunctionParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameterList")) return false;
    if (!nextTokenIs(b, LPARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARENTHESIS);
    r = r && FunctionParameterList_1(b, l + 1);
    r = r && consumeToken(b, RPARENTHESIS);
    exit_section_(b, m, FUNCTION_PARAMETER_LIST, r);
    return r;
  }

  // (<<CommaSeperatedList FunctionParameter>>)?
  private static boolean FunctionParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameterList_1")) return false;
    FunctionParameterList_1_0(b, l + 1);
    return true;
  }

  // <<CommaSeperatedList FunctionParameter>>
  private static boolean FunctionParameterList_1_0(PsiBuilder b, int l) {
    return CommaSeperatedList(b, l + 1, EnforceParser::FunctionParameter);
  }

  /* ********************************************************** */
  // VariableModifier* ClassReference
  public static boolean GenericType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_TYPE, "<generic type>");
    r = GenericType_0(b, l + 1);
    r = r && ClassReference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VariableModifier*
  private static boolean GenericType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericType_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VariableModifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GenericType_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VariableModifier* ClassReference VariableName ('[' ']')?
  public static boolean GenericTypeDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_TYPE_DECLARATION, "<generic type declaration>");
    r = GenericTypeDeclaration_0(b, l + 1);
    r = r && ClassReference(b, l + 1);
    r = r && VariableName(b, l + 1);
    r = r && GenericTypeDeclaration_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VariableModifier*
  private static boolean GenericTypeDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeDeclaration_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VariableModifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GenericTypeDeclaration_0", c)) break;
    }
    return true;
  }

  // ('[' ']')?
  private static boolean GenericTypeDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeDeclaration_3")) return false;
    GenericTypeDeclaration_3_0(b, l + 1);
    return true;
  }

  // '[' ']'
  private static boolean GenericTypeDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LSBRACKET, RSBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VariableDeclaration | FunctionDeclaration
  public static boolean GlobalDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GlobalDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_DECLARATION, "<global declaration>");
    r = VariableDeclaration(b, l + 1);
    if (!r) r = FunctionDeclaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // goto Expression ';'
  public static boolean GotoStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GotoStatement")) return false;
    if (!nextTokenIs(b, GOTO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GOTO);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, GOTO_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // if ParenthesisedExpression Statement ElseStatement?
  public static boolean IfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && ParenthesisedExpression(b, l + 1);
    r = r && Statement(b, l + 1);
    r = r && IfStatement_3(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // ElseStatement?
  private static boolean IfStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_3")) return false;
    ElseStatement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ClassReference FunctionName FunctionCallParameterList ';'
  public static boolean LambdaStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaStatement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ClassReference(b, l + 1);
    r = r && FunctionName(b, l + 1);
    r = r && FunctionCallParameterList(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, LAMBDA_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // '{' (<<CommaSeperatedList Expression>>)? '}'
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

  // (<<CommaSeperatedList Expression>>)?
  private static boolean LiteralArray_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralArray_1")) return false;
    LiteralArray_1_0(b, l + 1);
    return true;
  }

  // <<CommaSeperatedList Expression>>
  private static boolean LiteralArray_1_0(PsiBuilder b, int l) {
    return CommaSeperatedList(b, l + 1, Expression_parser_);
  }

  /* ********************************************************** */
  // BOOLEAN_LITERAL
  public static boolean LiteralBoolean(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralBoolean")) return false;
    if (!nextTokenIs(b, BOOLEAN_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOLEAN_LITERAL);
    exit_section_(b, m, LITERAL_BOOLEAN, r);
    return r;
  }

  /* ********************************************************** */
  // FLOAT_LITERAL
  public static boolean LiteralFloat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralFloat")) return false;
    if (!nextTokenIs(b, FLOAT_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FLOAT_LITERAL);
    exit_section_(b, m, LITERAL_FLOAT, r);
    return r;
  }

  /* ********************************************************** */
  // INTEGER_LITERAL
  public static boolean LiteralInteger(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralInteger")) return false;
    if (!nextTokenIs(b, INTEGER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER_LITERAL);
    exit_section_(b, m, LITERAL_INTEGER, r);
    return r;
  }

  /* ********************************************************** */
  // NULL_LITERAL
  public static boolean LiteralNull(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralNull")) return false;
    if (!nextTokenIs(b, NULL_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NULL_LITERAL);
    exit_section_(b, m, LITERAL_NULL, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  public static boolean LiteralString(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralString")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, m, LITERAL_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // OP_LOGICAL_OR | OP_LOGICAL_AND | OP_DOT
  public static boolean LogicalOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LogicalOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_OPERATOR, "<logical operator>");
    r = consumeToken(b, OP_LOGICAL_OR);
    if (!r) r = consumeToken(b, OP_LOGICAL_AND);
    if (!r) r = consumeToken(b, OP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VariableName ':' Expression
  public static boolean OptionalFunctionCallParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptionalFunctionCallParam")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableName(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, OPTIONAL_FUNCTION_CALL_PARAM, r);
    return r;
  }

  /* ********************************************************** */
  // return Expression? ';'
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && ReturnStatement_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  // Expression?
  private static boolean ReturnStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement_1")) return false;
    Expression(b, l + 1, -1);
    return true;
  }

  /* ********************************************************** */
  // ';'
  public static boolean SemicolonStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SemicolonStatement")) return false;
    if (!nextTokenIs(b, SEMICOLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    exit_section_(b, m, SEMICOLON_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // BlockStatement
  //     | Expression ';'
  //     | SemicolonStatement
  //     | ThreadStatement
  //     | VariableDeclaration
  //     | DeleteStatement
  //     | IfStatement
  //     | ForStatement
  //     | ForEachStatement
  //     | WhileStatement
  //     | ReturnStatement
  //     | BreakStatement
  //     | ContinueStatement
  //     | LambdaStatement
  //     | GotoStatement
  //     | SwitchStatement
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = BlockStatement(b, l + 1);
    if (!r) r = Statement_1(b, l + 1);
    if (!r) r = SemicolonStatement(b, l + 1);
    if (!r) r = ThreadStatement(b, l + 1);
    if (!r) r = VariableDeclaration(b, l + 1);
    if (!r) r = DeleteStatement(b, l + 1);
    if (!r) r = IfStatement(b, l + 1);
    if (!r) r = ForStatement(b, l + 1);
    if (!r) r = ForEachStatement(b, l + 1);
    if (!r) r = WhileStatement(b, l + 1);
    if (!r) r = ReturnStatement(b, l + 1);
    if (!r) r = BreakStatement(b, l + 1);
    if (!r) r = ContinueStatement(b, l + 1);
    if (!r) r = LambdaStatement(b, l + 1);
    if (!r) r = GotoStatement(b, l + 1);
    if (!r) r = SwitchStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Expression ';'
  private static boolean Statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SwitchLabel | DefaultSwitchLabel
  public static boolean SwitchBlockStatementGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchBlockStatementGroup")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_BLOCK_STATEMENT_GROUP, "<switch block statement group>");
    r = SwitchLabel(b, l + 1);
    if (!r) r = DefaultSwitchLabel(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'case' Expression ':' Statement*
  public static boolean SwitchLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchLabel")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_LABEL, "<switch label>");
    r = consumeToken(b, "case");
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    r = r && SwitchLabel_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Statement*
  private static boolean SwitchLabel_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchLabel_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SwitchLabel_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // switch ParenthesisedExpression '{' SwitchBlockStatementGroup* '}'
  public static boolean SwitchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement")) return false;
    if (!nextTokenIs(b, SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWITCH);
    r = r && ParenthesisedExpression(b, l + 1);
    r = r && consumeToken(b, LCURLY);
    r = r && SwitchStatement_3(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, SWITCH_STATEMENT, r);
    return r;
  }

  // SwitchBlockStatementGroup*
  private static boolean SwitchStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SwitchBlockStatementGroup(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SwitchStatement_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // thread FunctionCall ';'
  public static boolean ThreadStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ThreadStatement")) return false;
    if (!nextTokenIs(b, THREAD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THREAD);
    r = r && FunctionCall(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, THREAD_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ClassDeclaration | EnumDeclaration
  public static boolean TypeDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECLARATION, "<type declaration>");
    r = ClassDeclaration(b, l + 1);
    if (!r) r = EnumDeclaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '<' <<CommaSeperatedList GenericTypeDeclaration>>? '>'
  public static boolean TypeDeclarationList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclarationList")) return false;
    if (!nextTokenIs(b, OP_LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LESS);
    r = r && TypeDeclarationList_1(b, l + 1);
    r = r && consumeToken(b, OP_GREATER);
    exit_section_(b, m, TYPE_DECLARATION_LIST, r);
    return r;
  }

  // <<CommaSeperatedList GenericTypeDeclaration>>?
  private static boolean TypeDeclarationList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclarationList_1")) return false;
    CommaSeperatedList(b, l + 1, EnforceParser::GenericTypeDeclaration);
    return true;
  }

  /* ********************************************************** */
  // '<' <<CommaSeperatedList GenericType>>? '>'
  public static boolean TypeList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeList")) return false;
    if (!nextTokenIs(b, OP_LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LESS);
    r = r && TypeList_1(b, l + 1);
    r = r && consumeToken(b, OP_GREATER);
    exit_section_(b, m, TYPE_LIST, r);
    return r;
  }

  // <<CommaSeperatedList GenericType>>?
  private static boolean TypeList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeList_1")) return false;
    CommaSeperatedList(b, l + 1, EnforceParser::GenericType);
    return true;
  }

  /* ********************************************************** */
  // OP_INCREMENT | OP_DECREMENT | OP_BANG | OP_BITWISE_NOT | OP_ADD | OP_SUBTRACT
  public static boolean UnaryPrefixOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryPrefixOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_PREFIX_OPERATOR, "<unary prefix operator>");
    r = consumeToken(b, OP_INCREMENT);
    if (!r) r = consumeToken(b, OP_DECREMENT);
    if (!r) r = consumeToken(b, OP_BANG);
    if (!r) r = consumeToken(b, OP_BITWISE_NOT);
    if (!r) r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_SUBTRACT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_INCREMENT | OP_DECREMENT
  public static boolean UnarySuffixOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnarySuffixOperator")) return false;
    if (!nextTokenIs(b, "<unary suffix operator>", OP_DECREMENT, OP_INCREMENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_SUFFIX_OPERATOR, "<unary suffix operator>");
    r = consumeToken(b, OP_INCREMENT);
    if (!r) r = consumeToken(b, OP_DECREMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (GlobalDeclaration) | '{' (GlobalDeclaration)* '}'
  public static boolean VarAndFunctionBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarAndFunctionBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_AND_FUNCTION_BLOCK, "<var and function block>");
    r = VarAndFunctionBlock_0(b, l + 1);
    if (!r) r = VarAndFunctionBlock_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (GlobalDeclaration)
  private static boolean VarAndFunctionBlock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarAndFunctionBlock_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GlobalDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' (GlobalDeclaration)* '}'
  private static boolean VarAndFunctionBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarAndFunctionBlock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && VarAndFunctionBlock_1_1(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, null, r);
    return r;
  }

  // (GlobalDeclaration)*
  private static boolean VarAndFunctionBlock_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarAndFunctionBlock_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VarAndFunctionBlock_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VarAndFunctionBlock_1_1", c)) break;
    }
    return true;
  }

  // (GlobalDeclaration)
  private static boolean VarAndFunctionBlock_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarAndFunctionBlock_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GlobalDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Attribute? VariableModifier* ClassReference <<CommaSeperatedList VariableDeclarator>> ';'
  public static boolean VariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DECLARATION, "<variable declaration>");
    r = VariableDeclaration_0(b, l + 1);
    r = r && VariableDeclaration_1(b, l + 1);
    r = r && ClassReference(b, l + 1);
    r = r && CommaSeperatedList(b, l + 1, EnforceParser::VariableDeclarator);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Attribute?
  private static boolean VariableDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_0")) return false;
    Attribute(b, l + 1);
    return true;
  }

  // VariableModifier*
  private static boolean VariableDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VariableModifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VariableDeclaration_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VariableName ArrayIndex? ('=' Expression)?
  public static boolean VariableDeclarator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclarator")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableName(b, l + 1);
    r = r && VariableDeclarator_1(b, l + 1);
    r = r && VariableDeclarator_2(b, l + 1);
    exit_section_(b, m, VARIABLE_DECLARATOR, r);
    return r;
  }

  // ArrayIndex?
  private static boolean VariableDeclarator_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclarator_1")) return false;
    ArrayIndex(b, l + 1);
    return true;
  }

  // ('=' Expression)?
  private static boolean VariableDeclarator_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclarator_2")) return false;
    VariableDeclarator_2_0(b, l + 1);
    return true;
  }

  // '=' Expression
  private static boolean VariableDeclarator_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclarator_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_ASSIGN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // private | protected | static | autoptr | proto | ref | reference | const | owned | out | notnull | inout | local
  public static boolean VariableModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableModifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_MODIFIER, "<variable modifier>");
    r = consumeToken(b, PRIVATE);
    if (!r) r = consumeToken(b, PROTECTED);
    if (!r) r = consumeToken(b, STATIC);
    if (!r) r = consumeToken(b, AUTOPTR);
    if (!r) r = consumeToken(b, PROTO);
    if (!r) r = consumeToken(b, REF);
    if (!r) r = consumeToken(b, REFERENCE);
    if (!r) r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, OWNED);
    if (!r) r = consumeToken(b, OUT);
    if (!r) r = consumeToken(b, NOTNULL);
    if (!r) r = consumeToken(b, INOUT);
    if (!r) r = consumeToken(b, LOCAL);
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

  /* ********************************************************** */
  // while ParenthesisedExpression Statement
  public static boolean WhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && ParenthesisedExpression(b, l + 1);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: Expression
  // Operator priority table:
  // 0: ATOM(PrimaryExpression)
  // 1: BINARY(ArithmeticExpression)
  // 2: POSTFIX(ArrayIndexExpression)
  // 3: PREFIX(UnaryPrefixExpression)
  // 4: POSTFIX(UnarySuffixExpression)
  // 5: BINARY(LogicalExpression)
  // 6: BINARY(AssignmentExpression)
  // 7: PREFIX(CastExpression)
  // 8: ATOM(ObjectCreationExpression)
  // 9: BINARY(RelativeExpression)
  // 10: ATOM(ThisExpression)
  // 11: ATOM(SuperExpression)
  // 12: PREFIX(ParenthesisedExpression)
  public static boolean Expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = PrimaryExpression(b, l + 1);
    if (!r) r = UnaryPrefixExpression(b, l + 1);
    if (!r) r = CastExpression(b, l + 1);
    if (!r) r = ObjectCreationExpression(b, l + 1);
    if (!r) r = ThisExpression(b, l + 1);
    if (!r) r = SuperExpression(b, l + 1);
    if (!r) r = ParenthesisedExpression(b, l + 1);
    p = r;
    r = r && Expression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean Expression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 1 && ArithmeticExpression_0(b, l + 1)) {
        r = Expression(b, l, 1);
        exit_section_(b, l, m, ARITHMETIC_EXPRESSION, r, true, null);
      }
      else if (g < 2 && ArrayIndexExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, ARRAY_INDEX_EXPRESSION, r, true, null);
      }
      else if (g < 4 && UnarySuffixExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, UNARY_SUFFIX_EXPRESSION, r, true, null);
      }
      else if (g < 5 && LogicalExpression_0(b, l + 1)) {
        r = Expression(b, l, 5);
        exit_section_(b, l, m, LOGICAL_EXPRESSION, r, true, null);
      }
      else if (g < 6 && AssignmentExpression_0(b, l + 1)) {
        r = Expression(b, l, 6);
        exit_section_(b, l, m, ASSIGNMENT_EXPRESSION, r, true, null);
      }
      else if (g < 9 && RelativeExpression_0(b, l + 1)) {
        r = Expression(b, l, 9);
        exit_section_(b, l, m, RELATIVE_EXPRESSION, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // LiteralString
  //     | LiteralInteger
  //     | LiteralFloat
  //     | LiteralBoolean
  //     | LiteralNull
  //     | LiteralArray
  //     | FunctionCall
  //     | ClassReference
  public static boolean PrimaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PRIMARY_EXPRESSION, "<primary expression>");
    r = LiteralString(b, l + 1);
    if (!r) r = LiteralInteger(b, l + 1);
    if (!r) r = LiteralFloat(b, l + 1);
    if (!r) r = LiteralBoolean(b, l + 1);
    if (!r) r = LiteralNull(b, l + 1);
    if (!r) r = LiteralArray(b, l + 1);
    if (!r) r = FunctionCall(b, l + 1);
    if (!r) r = ClassReference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ArithmeticOperator)
  private static boolean ArithmeticExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArithmeticExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArithmeticOperator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ArrayIndex)
  private static boolean ArrayIndexExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayIndexExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArrayIndex(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean UnaryPrefixExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryPrefixExpression")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = UnaryPrefixExpression_0(b, l + 1);
    p = r;
    r = p && Expression(b, l, 3);
    exit_section_(b, l, m, UNARY_PREFIX_EXPRESSION, r, p, null);
    return r || p;
  }

  // (UnaryPrefixOperator)
  private static boolean UnaryPrefixExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryPrefixExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = UnaryPrefixOperator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (UnarySuffixOperator)
  private static boolean UnarySuffixExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnarySuffixExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = UnarySuffixOperator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LogicalOperator)
  private static boolean LogicalExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LogicalExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = LogicalOperator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (AssignmentOperator)
  private static boolean AssignmentExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignmentOperator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean CastExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CastExpression")) return false;
    if (!nextTokenIsSmart(b, LPARENTHESIS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = CastExpression_0(b, l + 1);
    p = r;
    r = p && Expression(b, l, 7);
    exit_section_(b, l, m, CAST_EXPRESSION, r, p, null);
    return r || p;
  }

  // '(' (ClassReference) ')'
  private static boolean CastExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CastExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LPARENTHESIS);
    r = r && CastExpression_0_1(b, l + 1);
    r = r && consumeToken(b, RPARENTHESIS);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ClassReference)
  private static boolean CastExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CastExpression_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ClassReference(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // new VariableModifier* ClassReference FunctionCallParameterList?
  public static boolean ObjectCreationExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectCreationExpression")) return false;
    if (!nextTokenIsSmart(b, NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, NEW);
    r = r && ObjectCreationExpression_1(b, l + 1);
    r = r && ClassReference(b, l + 1);
    r = r && ObjectCreationExpression_3(b, l + 1);
    exit_section_(b, m, OBJECT_CREATION_EXPRESSION, r);
    return r;
  }

  // VariableModifier*
  private static boolean ObjectCreationExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectCreationExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VariableModifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ObjectCreationExpression_1", c)) break;
    }
    return true;
  }

  // FunctionCallParameterList?
  private static boolean ObjectCreationExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectCreationExpression_3")) return false;
    FunctionCallParameterList(b, l + 1);
    return true;
  }

  // (ComparativeOperator)
  private static boolean RelativeExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelativeExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ComparativeOperator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // this
  public static boolean ThisExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ThisExpression")) return false;
    if (!nextTokenIsSmart(b, THIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, THIS);
    exit_section_(b, m, THIS_EXPRESSION, r);
    return r;
  }

  // super
  public static boolean SuperExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuperExpression")) return false;
    if (!nextTokenIsSmart(b, SUPER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, SUPER);
    exit_section_(b, m, SUPER_EXPRESSION, r);
    return r;
  }

  public static boolean ParenthesisedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesisedExpression")) return false;
    if (!nextTokenIsSmart(b, LPARENTHESIS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, LPARENTHESIS);
    p = r;
    r = p && Expression(b, l, -1);
    r = p && report_error_(b, consumeToken(b, RPARENTHESIS)) && r;
    exit_section_(b, l, m, PARENTHESISED_EXPRESSION, r, p, null);
    return r || p;
  }

  static final Parser Expression_parser_ = (b, l) -> Expression(b, l + 1, -1);
}
