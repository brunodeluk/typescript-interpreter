package newparser.ASTNodes;

public class PrintNode implements ASTNode {

    private ExpressionNode expressionNode;

    public PrintNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    public PrintNode() {

    }

    public void setExpressionNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
