/*
BSD License
Copyright (c) 2013, Tom Everett
All rights reserved.
Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:
1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Tom Everett nor the names of its contributors
   may be used to endorse or promote products derived from this software
   without specific prior written permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

grammar MiniJava;

goal
   : mainClass
    ;

mainClass
    : CLASS IDENTIFIER OPEN_BLOCK
        PUBLIC STATIC VOID MAIN OPEN_PARENTESIS STRING OPEN_BRACKET CLOSE_BRACKET IDENTIFIER CLOSE_PARENTESIS
        OPEN_BLOCK statement CLOSE_BLOCK
     CLOSE_BLOCK
    ;

classDeclaration
    :
        CLASS IDENTIFIER (EXTENDS IDENTIFIER)? OPEN_BLOCK
            varDeclaration*
            methodDeclaration*
        CLOSE_BLOCK
    ;

varDeclaration
    : (IDENTIFIER | TYPE) IDENTIFIER SEMICOLON
    ;

methodDeclaration
    : PUBLIC (TYPE | IDENTIFIER) IDENTIFIER OPEN_PARENTESIS ((TYPE | IDENTIFIER) IDENTIFIER (COMMA (TYPE | IDENTIFIER) IDENTIFIER)* )? CLOSE_PARENTESIS
    OPEN_BLOCK
        varDeclaration*
        statement*
        RETURN (expression | IDENTIFIER) SEMICOLON
    CLOSE_BLOCK
    ;

statement
    : statement_block |
      assignment |
      array_assignment |
      print |
      if_statement |
      while_statement
    ;

statement_block
    : OPEN_BLOCK statement* CLOSE_BLOCK
    ;

if_statement
    : IF OPEN_PARENTESIS (expression | IDENTIFIER) CLOSE_PARENTESIS statement ELSE statement
    ;

while_statement
    : WHILE OPEN_PARENTESIS (expression | IDENTIFIER) CLOSE_PARENTESIS statement
    ;

assignment
    : IDENTIFIER EQUALS (expression | IDENTIFIER)
    ;

print
    : SISOUT OPEN_PARENTESIS (expression | IDENTIFIER) CLOSE_PARENTESIS
    ;

array_assignment
    : IDENTIFIER OPEN_BRACKET (expression | IDENTIFIER) CLOSE_BRACKET EQUALS (expression | IDENTIFIER)
    ;

expression
    : TRUE | FALSE | INTEGER | THIS
      OPEN_PARENTESIS (expression | IDENTIFIER) CLOSE_PARENTESIS |
      not_expression |
      object_instatiation |
      array_instatiation |
    ;

not_expression
    : NOT (expression | IDENTIFIER)
    ;

object_instatiation
    : NEW IDENTIFIER OPEN_PARENTESIS CLOSE_PARENTESIS
    ;

array_instatiation
    : NEW INT OPEN_BRACKET (expression | IDENTIFIER) CLOSE_BRACKET
    ;

NOT
 : '!'
 ;

NEW
    : 'new'
    ;

INTEGER
    : ('0' .. '9')+
    ;

THIS
    : 'this'
    ;

TRUE
    : 'true'
    ;

FALSE
    : 'false'
    ;

WHILE
    : 'while'
    ;

IF
    : 'if'
    ;

ELSE
    : 'else'
    ;

SISOUT
    : 'System.out.println'
    ;

TYPE
    : INT | INT_ARRAY  | BOOLEAN
    ;

EQUALS
    : '='
    ;

SEMICOLON
    : ';'
    ;

RETURN
    : 'return'
    ;

COMMA
    : ','
    ;

INT
    : 'int'
    ;

INT_ARRAY
    : INT OPEN_BRACKET CLOSE_BRACKET
    ;

BOOLEAN
    : 'boolean'
    ;

EXTENDS
    : 'extends'
    ;

CLASS
    : 'class'
    ;

OPEN_BLOCK
    : '{'
    ;
CLOSE_BLOCK
    : '}'
    ;

OPEN_PARENTESIS
    : '('
    ;

CLOSE_PARENTESIS
    : ')'
    ;

OPEN_BRACKET
    : '['
    ;

CLOSE_BRACKET
    : ']'
    ;

PUBLIC
    : 'public'
    ;

STATIC
    : 'static'
    ;

VOID
    : 'void'
    ;

MAIN
    : 'main'
    ;

STRING
    : 'String'
    ;

IDENTIFIER
   : VALID_ID_START(VALID_ID_CHAR)*
   ;


VALID_ID_START
   : ('a' .. 'z') | ('A' .. 'Z') | '_'
   ;


 VALID_ID_CHAR
   : ('a' .. 'z') | ('A' .. 'Z') | '_' | ('0' .. '9')
   ;

WS
   : [ \t\r\n] -> skip
   ;