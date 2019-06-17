package parser.AST;

public class StringNode extends Expression {

    private String value;

    public StringNode(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
