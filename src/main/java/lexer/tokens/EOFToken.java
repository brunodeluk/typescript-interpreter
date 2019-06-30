package lexer.tokens;

import newparser.IParserVisitor;

public class EOFToken extends AbstractToken {

    public EOFToken() {
        super("EOF");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int hashCode() {
        return -1;
    }
}
