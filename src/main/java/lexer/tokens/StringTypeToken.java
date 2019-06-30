package lexer.tokens;

import newparser.IParserVisitor;

public class StringTypeToken extends AbstractToken {

    public StringTypeToken() {
        super("String");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
