package lexer.input;

import lexer.ILexer;
import lexer.tokens.EOFToken;
import lexer.tokens.Token;

public class TokenInput implements Input<Token> {

    private ILexer lexer;
    private Token current;

    private EOFToken eofToken;

    public TokenInput(ILexer lexer) {
        this.lexer = lexer;
        this.eofToken = new EOFToken();
        this.consume();
    }

    @Override
    public void consume() {
        this.current = this.lexer.nextToken();
    }

    @Override
    public Token next() {
        return this.current;
    }

    @Override
    public boolean hasNext() {
        return this.current.hashCode() != eofToken.hashCode();
    }
}
