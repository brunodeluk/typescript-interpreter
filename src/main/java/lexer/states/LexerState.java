package lexer.states;

import lexer.Lexer;
import lexer.tokens.Token;

public interface LexerState {
    Token nextToken(Lexer lexer);
    LexerState getNextState();
    boolean match(char c);
}
