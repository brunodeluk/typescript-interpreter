package lexer.tokens;

import newparser.IParserVisitor;

public class NumberTypeToken extends AbstractToken {

    public NumberTypeToken() {
        super("Number");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }
}
