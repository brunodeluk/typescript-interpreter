package lexer;

import lexer.input.Input;
import lexer.states.LexerState;

public class Lexer implements ILexer {

    private Input input;
    private LexerState state;
    private LexerState initialState;
    private int line;
    private int column;

    public Lexer(Input input, LexerState initialState) {
        this.input = input;
        this.initialState = initialState;
        this.state = initialState;
    }

    @Override
    public Token nextToken() {
        if (!input.hasNext()) {
            return new Token(TokenType.EOF, null);
        }

        this.column++;

        if (input.next() == '\n') {
            this.column = 0;
            this.line++;
        }

        Token token = this.state.nextToken(this);
        token.setColumn(this.column);
        token.setLine(this.line);
        return token;
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
