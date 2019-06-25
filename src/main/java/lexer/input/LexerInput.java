package lexer.input;

import lexer.ILexer;
import lexer.Token;
import lexer.TokenType;

public class LexerInput implements Input<Token> {

    private ILexer lexer;
    private Token token;

    public LexerInput(ILexer lexer) {
        this.lexer = lexer;
    }

    @Override
    public void consume() {
        this.token = lexer.nextToken();
    }

    @Override
    public Token next() {
        return this.token;
    }

    @Override
    public boolean hasNext() {
        return !this.token.getType().equals(TokenType.EOF);
    }
}
