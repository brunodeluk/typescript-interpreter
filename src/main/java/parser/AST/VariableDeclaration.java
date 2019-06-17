package parser.AST;

public class VariableDeclaration implements ASTNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
