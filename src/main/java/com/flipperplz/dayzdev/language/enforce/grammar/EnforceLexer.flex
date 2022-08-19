package com.flipperplz.dayzdev.language.enforce.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.flipperplz.dayzdev.language.enforce.psi.EnforceElementTypes.*;

%%

%{
  public EnforceLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class EnforceLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SINGLE_LINE_COMMENT="//".*
EMPTY_DELIMITED_COMMENT="/"\*\*?"/"
DELIMITED_COMMENT="/"\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+"/"
FLOAT_LITERAL=[+-]?[0-9]+(\.[0-9]+)([Ee][+-]?[0-9]+)?
INTEGER_LITERAL=(0[xX][0-9a-fA-F]+)|-?[0-9]+
BOOLEAN_LITERAL=(true|false)
NULL_LITERAL=null
IDENTIFIER=[a-zA-Z0-9_]+
WHITE_SPACE=[ \t\n\x0B\f\r]+
SChar=[^\"\'\\] | {ESC_CHAR}

ESC_CHAR=\\[\\\"\']


%%
<YYINITIAL> {
  {WHITE_SPACE}                  { return WHITE_SPACE; }

  "["                            { return LSBRACKET; }
  "]"                            { return RSBRACKET; }
  "{"                            { return LCURLY; }
  "}"                            { return RCURLY; }
  ";"                            { return SEMICOLON; }
  ":"                            { return COLON; }
  ","                            { return COMMA; }
  "++"                           { return OP_INCREMENT; }
  "--"                           { return OP_DECREMENT; }
  "<<"                           { return OP_LSHIFT; }
  ">>"                           { return OP_RSHIFT; }
  "="                            { return OP_ASSIGN; }
  "=="                           { return OP_EQUAL; }
  "!="                           { return OP_INEQUAL; }
  "||"                           { return OP_LOGICAL_OR; }
  "&&"                           { return OP_LOGICAL_AND; }
  "&="                           { return OP_AND_ASSIGN; }
  "<="                           { return OP_LESS_EQUAL; }
  ">="                           { return OP_GREATER_EQUAL; }
  "^="                           { return OP_XOR_ASSIGN; }
  "|="                           { return OP_OR_ASSIGN; }
  "/="                           { return OP_DIVIDE_ASSIGN; }
  "*="                           { return OP_MULTIPLY_ASSIGN; }
  "+="                           { return OP_ADD_ASSIGN; }
  "-="                           { return OP_SUBTRACT_ASSIGN; }
  "<<="                          { return OP_LSHIFT_ASSIGN; }
  ">>="                          { return OP_RSHIFT_ASSIGN; }
  "|"                            { return OP_BITWISE_OR; }
  "^"                            { return OP_BITWISE_XOR; }
  "&"                            { return OP_BITWISE_AND; }
  "~"                            { return OP_BITWISE_NOT; }
  ">"                            { return OP_GREATER; }
  "<"                            { return OP_LESS; }
  "-"                            { return OP_SUBTRACT; }
  "+"                            { return OP_ADD; }
  "*"                            { return OP_MULTIPLY; }
  "/"                            { return OP_DIVIDE; }
  "."                            { return OP_DOT; }
  "!"                            { return OP_BANG; }
  "%"                            { return OP_MODULO; }
  "("                            { return LPARENTHESIS; }
  ")"                            { return RPARENTHESIS; }
  "class"                        { return CLASS; }
  "extends"                      { return EXTENDS; }
  "enum"                         { return ENUM; }
  "new"                          { return NEW; }
  "this"                         { return THIS; }
  "super"                        { return SUPER; }
  "thread"                       { return THREAD; }
  "delete"                       { return DELETE; }
  "if"                           { return IF; }
  "else"                         { return ELSE; }
  "for"                          { return FOR; }
  "foreach"                      { return FOREACH; }
  "while"                        { return WHILE; }
  "return"                       { return RETURN; }
  "break"                        { return BREAK; }
  "continue"                     { return CONTINUE; }
  "goto"                         { return GOTO; }
  "switch"                       { return SWITCH; }
  "modded"                       { return MODDED; }
  "sealed"                       { return SEALED; }
  "private"                      { return PRIVATE; }
  "protected"                    { return PROTECTED; }
  "static"                       { return STATIC; }
  "autoptr"                      { return AUTOPTR; }
  "proto"                        { return PROTO; }
  "ref"                          { return REF; }
  "reference"                    { return REFERENCE; }
  "const"                        { return CONST; }
  "owned"                        { return OWNED; }
  "out"                          { return OUT; }
  "notnull"                      { return NOTNULL; }
  "inout"                        { return INOUT; }
  "local"                        { return LOCAL; }
  "external"                     { return EXTERNAL; }
  "override"                     { return OVERRIDE; }
  "native"                       { return NATIVE; }
  "volatile"                     { return VOLATILE; }
  "event"                        { return EVENT; }

  {SINGLE_LINE_COMMENT}          { return SINGLE_LINE_COMMENT; }
  {EMPTY_DELIMITED_COMMENT}      { return EMPTY_DELIMITED_COMMENT; }
  {DELIMITED_COMMENT}            { return DELIMITED_COMMENT; }
  \"{SChar}*\"                   { return STRING_LITERAL; }
  {FLOAT_LITERAL}                { return FLOAT_LITERAL; }
  {INTEGER_LITERAL}              { return INTEGER_LITERAL; }
  {BOOLEAN_LITERAL}              { return BOOLEAN_LITERAL; }
  {NULL_LITERAL}                 { return NULL_LITERAL; }
  {IDENTIFIER}                   { return IDENTIFIER; }
  {WHITE_SPACE}                  { return WHITE_SPACE; }

}

[^] { return BAD_CHARACTER; }
