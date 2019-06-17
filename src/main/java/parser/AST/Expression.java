package parser.AST;

public abstract class Expression implements ASTNode {

    private Expression left;
    private Expression right;

    public Expression() { }

    public Expression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression left() {
        return this.left;
    }

    public Expression right() {
        return this.right;
    }

}
