package lexer.states;

import lexer.Lexer;
import lexer.Token;

import java.util.regex.Pattern;

public class NumberState extends AbstractLexerState {

    @Override
    public Token nextToken(Lexer lexer) {
        char c = lexer.getInput().next();

        if (Pattern.matches("\\.", String.valueOf(c))) {
            lexer.getInput().consume();
            carry(c);
            lexer.setState(new FloatNumberState(getCarry()));
            return lexer.nextToken();
        }

        if (!match(c)) {

            if (getCarry().length() > 0 || !lexer.getInput().hasNext()) {
                lexer.setState(lexer.getInitialState());
                return getToken();
            }

            lexer.setState(getNextState());
            return lexer.nextToken();
        }

        lexer.getInput().consume();
        carry(c);
        return lexer.nextToken();
    }

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
        return new Token("NUMBER_LITERAL", getCleanCarry());
    }
}
