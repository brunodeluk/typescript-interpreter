package parser.AST;

public class Subtraction extends Expression {

    public Subtraction(Expression expLeft, Expression expRight) {
        super(expLeft, expRight);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
