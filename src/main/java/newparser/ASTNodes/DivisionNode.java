package newparser.ASTNodes;

public class DivisionNode extends ExpressionNode {

    public DivisionNode(ExpressionNode expLeft, ExpressionNode expRight) {
        super(expLeft, expRight);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
