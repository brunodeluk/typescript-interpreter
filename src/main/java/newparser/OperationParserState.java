package newparser;

import lexer.tokens.*;
import newparser.ASTNodes.ASTNode;
import newparser.ASTNodes.ExpressionNode;

public class OperationParserState extends AbstractParserState {

    private ExpressionNode expressionNode;

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(StringLiteralToken token) {
        super.visit(token);
    }

    @Override
    public void visit(NumberLiteralToken token) {
        super.visit(token);
    }

    @Override
    public void visit(MultiplicationToken token) {
        super.visit(token);
    }

    @Override
    public void visit(DivisionToken token) {
        super.visit(token);
    }

}
