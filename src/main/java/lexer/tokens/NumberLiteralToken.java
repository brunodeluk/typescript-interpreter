package lexer.tokens;

import newparser.IParserVisitor;

public class NumberLiteralToken extends AbstractToken {

    public NumberLiteralToken(String lexeme) {
        super(lexeme);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }
}
