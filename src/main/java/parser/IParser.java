package parser;

import lexer.input.LexerInput;
import parser.AST.ASTNode;

public interface IParser {
    ASTNode parse(LexerInput lexer);
}
