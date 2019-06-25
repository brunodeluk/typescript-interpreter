package parser;

import lexer.ILexer;
import lexer.input.LexerInput;
import parser.AST.ASTNode;

public interface ParserState<Parser extends AbstractParser> {
    ASTNode parse(Parser parser, LexerInput lexer);
}
