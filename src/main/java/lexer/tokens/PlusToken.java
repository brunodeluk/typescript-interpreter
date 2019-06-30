package lexer.tokens;

import newparser.IParserVisitor;

public class PlusToken extends AbstractToken {

    public PlusToken() {
        super("+");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
