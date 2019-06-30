package lexer.tokens;

import newparser.IParserVisitor;

public class IdentifierToken extends AbstractToken {

    public IdentifierToken(String lexeme) {
        super(lexeme);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
