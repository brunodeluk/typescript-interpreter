package parser.AST;

public class Multiplication extends Expression {

    public Multiplication(Expression expLeft, Expression expRight) {
        super(expLeft, expRight);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
