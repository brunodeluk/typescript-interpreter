package newparser.ASTNodes;

public class VariableDeclarationNode implements ASTNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
