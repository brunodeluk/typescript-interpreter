package newparser.ASTNodes;

public class MultiplicationNode extends ExpressionNode {

    public MultiplicationNode(ExpressionNode expLeft, ExpressionNode expRight) {
        super(expLeft, expRight);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
