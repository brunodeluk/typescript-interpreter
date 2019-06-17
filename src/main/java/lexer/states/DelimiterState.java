package lexer.states;

import lexer.InvalidTokenException;
import lexer.Token;
import lexer.TokenType;

import java.util.regex.Pattern;

public class DelimiterState extends AbstractLexerState {

    @Override
    public Token getToken() {
        switch (getCarry()) {
            case "+":
                return new Token(TokenType.PLUS, getCleanCarry());
            case "-":
                return new Token(TokenType.MINUS, getCleanCarry());
            case "*":
                return new Token(TokenType.MULTIPLICATION, getCleanCarry());
            case "/":
                return new Token(TokenType.DIVISION, getCleanCarry());
            case "(":
                return new Token(TokenType.OPEN_PARENTHESIS, getCleanCarry());
            case ")":
                return new Token(TokenType.CLOSING_PARENTHESIS, getCleanCarry());
            case ":":
                return new Token(TokenType.TYPE_ASSIGNATION, getCleanCarry());
            case "=":
                return new Token(TokenType.ASSIGNATION, getCleanCarry());
            case ";":
                return new Token(TokenType.SEMICOLON, getCleanCarry());
            default:
                throw new InvalidTokenException(getCarry());
        }
    }

    @Override
    public LexerState getNextState() {
        return new KeywordState();
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches("[+\\-*/)(:=;]", String.valueOf(c));
    }
}
