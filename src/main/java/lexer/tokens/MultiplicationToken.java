package lexer.tokens;

import newparser.IParserVisitor;

public class MultiplicationToken extends AbstractToken {

    public MultiplicationToken() {
        super("*");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
