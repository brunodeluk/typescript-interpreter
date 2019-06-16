package lexer.states;

import lexer.Lexer;
import lexer.Token;

import java.util.regex.Pattern;

public class SpaceState extends AbstractLexerState {

    @Override
    public Token nextToken(Lexer lexer) {
        char c = lexer.getInput().next();

        if (!match(c)) {
            lexer.setState(getNextState());
            return lexer.nextToken();
        }

        lexer.getInput().consume();
        return lexer.nextToken();
    }

    @Override
    public Token getToken() {
        return null;
    }

    @Override
    public LexerState getNextState() {
        return new DelimiterState();
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches("\\s+", String.valueOf(c));
    }
}
