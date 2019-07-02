package newparser.ASTNodes;

public class DeclarationNode implements ASTNode {

    private IdentifierNode identifierNode;
    private String type;
    private ExpressionNode expressionNode;

    public DeclarationNode(IdentifierNode identifierNode, String type, ExpressionNode expressionNode) {
        this.identifierNode = identifierNode;
        this.type = type;
        this.expressionNode = expressionNode;
    }

    public IdentifierNode getIdentifierNode() {
        return identifierNode;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public String getType() {
        return type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
