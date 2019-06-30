package lexer;

import lexer.input.Input;
import lexer.states.LexerState;
import lexer.states.SpaceState;
import lexer.tokens.EOFToken;
import lexer.tokens.Token;

public class Lexer implements ILexer {

    private Input<Character> input;
    private LexerState state;
    private LexerState initialState;
    private int line;
    private int column;

    public Lexer(Input<Character> input) {
        this.input = input;
        this.initialState = new SpaceState();
        this.state = initialState;
    }

    // TODO: set line and column to token

    @Override
    public Token nextToken() {

        if (!input.hasNext()) {
            return new EOFToken();
        }

        manageLineAndColumn();
        return this.state.nextToken(this);
    }

    private void manageLineAndColumn() {
        this.column++;

        if (input.next() == '\n') {
            this.column = 0;
            this.line++;
        }
    }

    public Input<Character> getInput() {
        return input;
    }

    public LexerState getInitialState() {
        return initialState;
    }

    public void setState(LexerState state) {
        this.state = state;
    }
}
