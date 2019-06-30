package lexer.states;

import lexer.InvalidTokenException;
import lexer.tokens.Token;

import java.util.regex.Pattern;

public class InvalidState extends AbstractLexerState {

    @Override
    public Token getToken() {
        throw new InvalidTokenException(getCarry());
    }

    @Override
    public LexerState getNextState() {
        return this;
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches("[^\\s+]", String.valueOf(c));
    }
}
