package parser.AST;

public class Division extends Expression {

    public Division(Expression expLeft, Expression expRight) {
        super(expLeft, expRight);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
