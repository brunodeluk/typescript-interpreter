package lexer.tokens;

import newparser.IParserVisitor;

public class MinusToken extends AbstractToken {

    public MinusToken() {
        super("-");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
