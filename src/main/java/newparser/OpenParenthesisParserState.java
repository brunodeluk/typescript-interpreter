package newparser;

import lexer.tokens.ClosingParenthesisToken;
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
        this.expressionNode = new ExpressionParserState().parse(getInput());
    }

    @Override
    public void visit(NumberLiteralToken token) {
        this.expressionNode = new ExpressionParserState().parse(getInput());
    }

    @Override
    public void visit(ClosingParenthesisToken token) {
        getInput().consume();
        this.expressionNode = new ExpressionNode();
    }
}
