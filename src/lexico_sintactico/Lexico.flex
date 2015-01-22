package lexico_sintactico;

import java_cup.runtime.Symbol;

%%
%class Lexico
%public
%full
%unicode
%line
%column
%char
%cup

DIGITO = [0] | [1-9]+[0-9]*
LETRA = [a-zA-Z]

ID = {LETRA}({LETRA}|{DIGITO})*
INT = {DIGITO}
%%

/*0PERADORE Y SIGNOS*/
";"     {return new Symbol(sym.PUNTOCOMA, new token(yycolumn, yyline, yytext()));}
","     {return new Symbol(sym.COMA, new token(yycolumn, yyline, yytext()));}
"("     {return new Symbol(sym.ABRIRPAR, new token(yycolumn, yyline, yytext()));}
")"     {return new Symbol(sym.CERRARPAR, new token(yycolumn, yyline, yytext()));}
"{"     {return new Symbol(sym.ABRIRLLAV, new token(yycolumn, yyline, yytext()));}
"}"     {return new Symbol(sym.CIERRALLAV, new token(yycolumn, yyline, yytext()));}
"="     {return new Symbol(sym.ASIGNACION, new token(yycolumn, yyline, yytext()));}
"=="    {return new Symbol(sym.IGUAL, new token(yycolumn, yyline, yytext()));}
">"     {return new Symbol(sym.MAYOR, new token(yycolumn, yyline, yytext()));}
"<"     {return new Symbol(sym.MENOR, new token(yycolumn, yyline, yytext()));}
">="    {return new Symbol(sym.MAYORQUE, new token(yycolumn, yyline, yytext()));}
"<="    {return new Symbol(sym.MENORQUE, new token(yycolumn, yyline, yytext()));}
"+"    {return new Symbol(sym.MAS, new token(yycolumn, yyline, yytext()));}

/*PALABRAS RESERVADAS*/
"inicio"    {return new Symbol(sym.INICIO, new token(yycolumn, yyline, yytext()));}
"fin"       {return new Symbol(sym.FIN, new token(yycolumn, yyline, yytext()));}
"entero"    {return new Symbol(sym.ENTERO, new token(yycolumn, yyline, yytext()));}
"funcion"   {return new Symbol(sym.FUNCION, new token(yycolumn, yyline, yytext()));}
"para"      {return new Symbol(sym.PARA, new token(yycolumn, yyline, yytext()));}
"mientras"  {return new Symbol(sym.MIENTRAS, new token(yycolumn, yyline, yytext()));}
"hasta"     {return new Symbol(sym.HASTA, new token(yycolumn, yyline, yytext()));}
"hacer"     {return new Symbol(sym.HACER, new token(yycolumn, yyline, yytext()));}
"si"        {return new Symbol(sym.SI, new token(yycolumn, yyline, yytext()));}
"entonces"  {return new Symbol(sym.ENTONCES, new token(yycolumn, yyline, yytext()));}
"finsi"     {return new Symbol(sym.FINSI, new token(yycolumn, yyline, yytext()));}
"sino"      {return new Symbol(sym.SINO, new token(yycolumn, yyline, yytext()));}
"finsino"   {return new Symbol(sym.FINSINO, new token(yycolumn, yyline, yytext()));}
"retornar"  {return new Symbol(sym.RETORNAR, new token(yycolumn, yyline, yytext()));}
"true"      {return new Symbol(sym.TRUE, new token(yycolumn, yyline, yytext()));}
"false"     {return new Symbol(sym.FALSE, new token(yycolumn, yyline, yytext()));}
"finciclo"  {return new Symbol(sym.FINCICLO, new token(yycolumn, yyline, yytext()));}
"circulo"   {return new Symbol(sym.CIRCULO, new token(yycolumn, yyline, yytext()));}
"linea"     {return new Symbol(sym.LINEA, new token(yycolumn, yyline, yytext()));}
"rectangulo"    {return new Symbol(sym.RECTANGULO, new token(yycolumn, yyline, yytext()));}
"elipse"    {return new Symbol(sym.ELIPSE, new token(yycolumn, yyline, yytext()));}
"color"     {return new Symbol(sym.COLOR, new token(yycolumn, yyline, yytext()));}

/*EXPRESIONES*/
{INT}           {return new Symbol(sym.VALINT, new token(yycolumn, yyline, yytext()));}
{ID}            {return new Symbol(sym.IDENTIFICADOR, new token(yycolumn, yyline, yytext()));}
(" "|\n|\t|\r)+	{ }
.               {System.err.println("caracter invalido" + yytext() + "["+ yyline + ":"+ yycolumn + "]");}