package parser.AST;

public class Declaration implements ASTNode {

    private Identifier identifier;
    private Expression expression;

    public Declaration(Identifier identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
