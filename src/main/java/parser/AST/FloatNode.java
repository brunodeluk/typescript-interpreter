package parser.AST;

public class FloatNode extends Expression {

    private Float value;

    public FloatNode(Float value) {
        super();
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
