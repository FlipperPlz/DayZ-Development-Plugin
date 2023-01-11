package com.flipperplz.dayzdev.language.rap.lexer;

import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.flipperplz.dayzdev.language.rap.psi.RapElementTypes.*;

%%

%{
  public RapLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class RapLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SINGLE_LINE_COMMENT="//".*
EMPTY_DELIMITED_COMMENT="/"\*\*?"/"
DELIMITED_COMMENT="/"\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+"/"
LITERALINTEGER=-?[0-9]+
LITERALFLOAT=[+-]?[0-9]+(\.[0-9]+)([Ee][+-]?[0-9]+)?
IDENTIFIER=[a-zA-Z0-9_]+
WHITE_SPACE=[ \t\n\x0B\f\r]+
SChar=[^\"] | {ESC_CHAR}
ESC_CHAR=""""

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
  "="                            { return ASSIGN; }
  "+="                           { return APPEND; }
  "class"                        { return CLASS; }
  "delete"                       { return DELETE; }

  {SINGLE_LINE_COMMENT}          { return SINGLE_LINE_COMMENT; }
  {EMPTY_DELIMITED_COMMENT}      { return EMPTY_DELIMITED_COMMENT; }
  {DELIMITED_COMMENT}            { return DELIMITED_COMMENT; }
  \"{SChar}*\"                   { return LITERALSTRING; }
  {LITERALINTEGER}               { return LITERALINTEGER; }
  {LITERALFLOAT}                 { return LITERALFLOAT; }
  {IDENTIFIER}                   { return IDENTIFIER; }
  {WHITE_SPACE}                  { return WHITE_SPACE; }

}

[^] { return BAD_CHARACTER; }
