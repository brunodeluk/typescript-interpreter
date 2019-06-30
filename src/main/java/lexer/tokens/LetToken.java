package lexer.tokens;

import newparser.IParserVisitor;

public class LetToken extends AbstractToken {

    public LetToken() {
        super("let");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
