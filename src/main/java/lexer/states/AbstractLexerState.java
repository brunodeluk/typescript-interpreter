package lexer.states;

import lexer.Lexer;
import lexer.Token;

public abstract class AbstractLexerState implements LexerState {

    private String carry = "";

    public void carry(char c) {
        carry+=c;
    }

    public void setCarry(String carry) {
        this.carry = carry;
    }

    public String getCarry() {
        return this.carry;
    }

    public String getCleanCarry() {
        String c = this.carry;
        this.carry = "";
        return c;
    }

    @Override
    public Token nextToken(Lexer lexer) {
        char c = lexer.getInput().next();

        if (!match(c)) {

            if (carry.length() > 0 || !lexer.getInput().hasNext()) {
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

    public abstract Token getToken();

}
