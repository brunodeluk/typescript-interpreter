package newparser.ASTNodes;

public class AdditionNode extends ExpressionNode {

    public AdditionNode(ExpressionNode expLeft, ExpressionNode expRight) {
        super(expLeft, expRight);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
