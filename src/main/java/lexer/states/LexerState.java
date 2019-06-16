package lexer.states;

import lexer.Lexer;
import lexer.Token;

public interface LexerState {
    Token nextToken(Lexer lexer);
    LexerState getNextState();
    boolean match(char c);
}
