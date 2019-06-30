package newparser.ASTNodes;

public class ExpressionNode extends AbstractASTNode {

    private ExpressionNode left;
    private ASTNode right;

    public ExpressionNode() { }

    public ExpressionNode(ExpressionNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    public ExpressionNode left() {
        return this.left;
    }

    public ASTNode right() {
        return this.right;
    }

    public void setLeft(ExpressionNode left) {
        this.left = left;
    }

    public void setRight(ASTNode right) {
        this.right = right;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
