package newparser.ASTNodes;

public class IntegerNode extends ExpressionNode {

    private Integer value;

    public IntegerNode(Integer value) {
        super();
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
