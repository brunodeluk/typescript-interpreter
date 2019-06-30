package lexer.tokens;

import newparser.IParserVisitor;

public class ClosingParenthesisToken extends AbstractToken {

    public ClosingParenthesisToken() {
        super(")");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
