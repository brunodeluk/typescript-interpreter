package parser.AST;

public class CallExpression implements ASTNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
