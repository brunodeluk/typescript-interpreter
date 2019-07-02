package newparser;

import lexer.tokens.ClosingParenthesisToken;
import lexer.tokens.IdentifierToken;
import lexer.tokens.NumberLiteralToken;
import lexer.tokens.StringLiteralToken;
import newparser.ASTNodes.ASTNode;
import newparser.ASTNodes.ExpressionNode;

public class OpenParenthesisParserState extends AbstractParserState {

    private ASTNode expressionNode;

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(StringLiteralToken token) {
        assignExpression();
    }

    @Override
    public void visit(NumberLiteralToken token) {
        assignExpression();
    }

    @Override
    public void visit(IdentifierToken token) {
        assignExpression();
    }

    @Override
    public void visit(ClosingParenthesisToken token) {
        getInput().consume();
        this.expressionNode = new ExpressionNode();
    }

    private void assignExpression() {
        this.expressionNode = new ExpressionParserState().parse(getInput());
    }
}
