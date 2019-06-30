package lexer.tokens;

import newparser.IParserVisitor;

public class AssignationToken extends AbstractToken {

    public AssignationToken() {
        super("=");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }
}
