package newparser.ASTNodes;

public class CallExpressionNode implements ASTNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
