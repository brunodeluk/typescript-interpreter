package parser.AST;

public class Addition extends Expression {

    public Addition(Expression expLeft, Expression expRight) {
        super(expLeft, expRight);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
