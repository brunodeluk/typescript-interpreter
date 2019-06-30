package newparser.ASTNodes;

public class AssigmentNode implements ASTNode {

    private IdentifierNode identifierNode;
    private ExpressionNode expressionNode;

    public AssigmentNode(IdentifierNode identifierNode, ExpressionNode expressionNode) {
        this.identifierNode = identifierNode;
        this.expressionNode = expressionNode;
    }

    public IdentifierNode getIdentifierNode() {
        return identifierNode;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
