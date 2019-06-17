package lexer.states;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;

import java.util.regex.Pattern;

public class StringState extends AbstractLexerState {

    @Override
    public LexerState getNextState() {
        return new InvalidState();
    }

    @Override
    public Token nextToken(Lexer lexer) {
        char c = lexer.getInput().next();

        if (!match(c)) {
            lexer.setState(getNextState());
            return lexer.nextToken();
        }

        lexer.getInput().consume();
        lexer.setState(new StringLiteralState());
        return lexer.nextToken();
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches("\"", String.valueOf(c));
    }

    @Override
    public Token getToken() {
        return new Token(TokenType.NUMBER_LITERAL, getCleanCarry());
    }
}
