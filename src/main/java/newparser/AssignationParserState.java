package newparser;

import lexer.tokens.AssignationToken;
import newparser.ASTNodes.ASTNode;
import newparser.ASTNodes.ExpressionNode;

public class AssignationParserState extends AbstractParserState {

    private ExpressionNode expressionNode;

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(AssignationToken token) {
        getInput().consume();
        this.expressionNode = (ExpressionNode) new ExpressionParserState().parse(getInput());
    }
}
