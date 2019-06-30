package lexer.tokens;

import newparser.IParserVisitor;

public class SemicolonToken extends AbstractToken {

    public SemicolonToken() {
        super(";");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
