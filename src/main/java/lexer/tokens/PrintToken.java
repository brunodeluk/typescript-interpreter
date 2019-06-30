package lexer.tokens;

import newparser.IParserVisitor;

public class PrintToken extends AbstractToken {

    public PrintToken() {
        super("print");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
