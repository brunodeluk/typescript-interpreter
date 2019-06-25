package parser.AST;

public class Assigment implements ASTNode {

    private Identifier identifier;
    private Expression expression;

    public Assigment(Identifier identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
