package newparser.ASTNodes;

public class DeclarationNode implements ASTNode {

    private IdentifierNode identifierNode;
    private ExpressionNode expressionNode;

    public DeclarationNode(IdentifierNode identifierNode, ExpressionNode expressionNode) {
        this.identifierNode = identifierNode;
        this.expressionNode = expressionNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
