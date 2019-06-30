package lexer.tokens;

import newparser.IParserVisitor;

public class StringLiteralToken extends AbstractToken {

    public StringLiteralToken(String lexeme) {
        super(lexeme);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
