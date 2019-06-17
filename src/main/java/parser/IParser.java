package parser;

import lexer.ILexer;

public interface IParser {
    AST parse(ILexer lexer);
}
