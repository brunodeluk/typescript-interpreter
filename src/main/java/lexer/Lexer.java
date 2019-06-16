package lexer;

import lexer.input.Input;
import lexer.states.LexerState;

public class Lexer implements ILexer {

    private Input input;
    private LexerState state;
    private LexerState initialState;
    private int position;

    public Lexer(Input input, LexerState initialState) {
        this.input = input;
        this.initialState = initialState;
        this.state = initialState;
    }

    @Override
    public Token nextToken() {
        if (!input.hasNext()) {
            return new Token("EOF", null);
        }

        return this.state.nextToken(this);
    }

    public Input getInput() {
        return input;
    }

    public LexerState getInitialState() {
        return initialState;
    }

    public void setState(LexerState state) {
        this.state = state;
    }
}
