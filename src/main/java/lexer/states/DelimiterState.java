package lexer.states;

import lexer.InvalidTokenException;
import lexer.Lexer;
import lexer.tokens.*;
import lexer.TokenType;

import java.util.regex.Pattern;

public class DelimiterState extends AbstractLexerState {

    @Override
    public Token nextToken(Lexer lexer) {
        char c = lexer.getInput().next();

        if (!match(c)) {
            lexer.setState(getNextState());
            return lexer.nextToken();
        }

        lexer.setState(lexer.getInitialState());
        lexer.getInput().consume();
        carry(c);
        return getToken();
    }

    @Override
    public Token getToken() {
        switch (getCleanCarry()) {
            case "+":
                return new PlusToken();
            case "-":
                return new MinusToken();
            case "*":
                return new MultiplicationToken();
            case "/":
                return new DivisionToken();
            case "(":
                return new OpenParenthesisToken();
            case ")":
                return new ClosingParenthesisToken();
            case ":":
                return new TypeAssignationToken();
            case "=":
                return new AssignationToken();
            default:
                throw new InvalidTokenException(getCarry());
        }
    }

    @Override
    public LexerState getNextState() {
        return new SemiColonState();
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches("[+\\-*/)(:=]", String.valueOf(c));
    }
}
