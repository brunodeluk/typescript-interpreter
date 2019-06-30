package lexer.tokens;

import newparser.IParserVisitor;

public class TypeAssignationToken extends AbstractToken {

    public TypeAssignationToken() {
        super(":");
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
