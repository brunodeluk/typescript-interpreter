package parser;

import lexer.ILexer;
import parser.AST.ASTNode;

public interface IParser {
    ASTNode parse(ILexer lexer);
}
