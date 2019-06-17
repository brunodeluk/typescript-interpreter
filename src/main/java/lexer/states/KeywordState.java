package lexer.states;

import lexer.Token;
import lexer.TokenType;

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
            return new Token(TokenType.LET, getCleanCarry());
        }
        else if (Pattern.matches("print", getCarry())) {
            return new Token(TokenType.PRINT, getCleanCarry());
        }
        else if (Pattern.matches("String", getCarry())) {
            return new Token(TokenType.STRING_TYPE, getCleanCarry());
        }
        else if (Pattern.matches("Number", getCarry())) {
            return new Token(TokenType.NUMBER_TYPE, getCleanCarry());
        }

        return new Token(TokenType.IDENTIFIER, getCleanCarry());
    }
}
