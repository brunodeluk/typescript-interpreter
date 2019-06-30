package lexer.states;

import lexer.tokens.NumberLiteralToken;
import lexer.tokens.Token;

import java.util.regex.Pattern;

public class NumberState extends AbstractLexerState {

    @Override
    public LexerState getNextState() {
        return new StringState();
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches("[0-9]", String.valueOf(c));
    }

    @Override
    public Token getToken() {
        return new NumberLiteralToken(getCleanCarry());
    }
}
