package lexer.states;

import lexer.InvalidTokenException;
import lexer.Token;

import java.util.regex.Pattern;

public class DelimiterState extends AbstractLexerState {

    @Override
    public Token getToken() {

        if (Pattern.matches("[+\\-*/]", getCarry())) {
            return new Token("OPERATOR", getCleanCarry());
        }
        else if (Pattern.matches("\\(", getCarry())) {
            return new Token("OPEN_PARENTHESIS", getCleanCarry());
        }
        else if (Pattern.matches("\\)", getCarry())) {
            return new Token("CLOSE_PARENTHESIS", getCleanCarry());
        }
        else if (Pattern.matches(":", getCarry())) {
            return new Token("TYPE_ASSIGNATION", getCleanCarry());
        }
        else if (Pattern.matches("=", getCarry())) {
            return new Token("ASSIGNATION", getCleanCarry());
        }

        throw new InvalidTokenException(getCarry());
    }

    @Override
    public LexerState getNextState() {
        return new KeywordState();
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches("[+\\-*/)(:=]", String.valueOf(c));
    }
}
