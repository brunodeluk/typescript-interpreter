package lexer;

import lexer.tokens.Token;

public interface ILexer {
    Token nextToken();
}
