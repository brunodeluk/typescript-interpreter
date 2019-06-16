package lexer.states;

import lexer.Lexer;
import lexer.Token;

import java.util.regex.Pattern;

public class StringLiteralState extends AbstractLexerState {

    @Override
    public Token nextToken(Lexer lexer) {
        char c = lexer.getInput().next();
        lexer.getInput().consume();

        if (!match(c)) {
            lexer.setState(lexer.getInitialState());
            return getToken();
        }

        carry(c);
        return lexer.nextToken();
    }

    @Override
    public Token getToken() {
        return new Token("STRING_LITERAL", getCleanCarry());
    }

    @Override
    public LexerState getNextState() {
        return null;
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches("[^\"]", String.valueOf(c));
    }
}
