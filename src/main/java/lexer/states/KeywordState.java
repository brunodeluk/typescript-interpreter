package lexer.states;

import lexer.tokens.*;

import java.util.regex.Pattern;

public class KeywordState extends AbstractLexerState {

    @Override
    public LexerState getNextState() {
        return new NumberState();
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches("[a-zA-Z]", String.valueOf(c));
    }

    @Override
    public Token getToken() {

        if (Pattern.matches("let", getCarry())) {
            return new LetToken();
        }
        else if (Pattern.matches("print", getCarry())) {
            return new PrintToken();
        }
        else if (Pattern.matches("String", getCarry())) {
            return new StringTypeToken();
        }
        else if (Pattern.matches("Number", getCarry())) {
            return new NumberTypeToken();
        }

        return new IdentifierToken(getCleanCarry());
    }
}
