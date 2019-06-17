package parser;

import lexer.ILexer;
import parser.AST.ASTNode;

public interface ParserState<Parser extends AbstractParser> {
    ASTNode parse(Parser parser, ILexer lexer);
}
