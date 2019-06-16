package lexer.states;

import lexer.Token;

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

        if (Pattern.matches("let|return|function|if|else", getCarry())) {
            return new Token("KEYWORD", getCleanCarry());
        }
        else if (Pattern.matches("print", getCarry())) {
            return new Token("PRINT", getCleanCarry());
        }
        else if (Pattern.matches("(String|Number)", getCarry())) {
            return new Token("VARIABLE_TYPE", getCleanCarry());
        }

        return new Token("IDENTIFIER", getCleanCarry());
    }
}
