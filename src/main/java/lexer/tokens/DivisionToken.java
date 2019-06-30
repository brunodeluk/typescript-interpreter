package lexer.tokens;

import newparser.IParserVisitor;

public class DivisionToken extends AbstractToken {

    public DivisionToken() {
        super("/");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
