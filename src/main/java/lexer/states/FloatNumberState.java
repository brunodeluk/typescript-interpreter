package lexer.states;

import lexer.InvalidTokenException;
import lexer.Token;
import lexer.TokenType;

import java.util.regex.Pattern;

public class FloatNumberState extends AbstractLexerState {

    public FloatNumberState(String carry) {
        setCarry(carry);
    }

    @Override
    public Token getToken() {
        if (Pattern.matches("[0-9]*\\.[0-9]+", getCarry())) {
            return new Token(TokenType.NUMBER_LITERAL, getCleanCarry());
        }

        throw new InvalidTokenException(getCleanCarry());
    }

    @Override
    public LexerState getNextState() {
        return null;
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches("[0-9]", String.valueOf(c));
    }
}
