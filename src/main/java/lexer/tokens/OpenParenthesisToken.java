package lexer.tokens;

import newparser.IParserVisitor;

public class OpenParenthesisToken extends AbstractToken {

    public OpenParenthesisToken() {
        super("(");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }
}
