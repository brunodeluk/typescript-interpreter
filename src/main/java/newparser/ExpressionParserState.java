package newparser;

import lexer.tokens.*;
import newparser.ASTNodes.ASTNode;
import newparser.ASTNodes.AdditionNode;
import newparser.ASTNodes.ExpressionNode;
import newparser.ASTNodes.StringNode;

public class ExpressionParserState extends AbstractParserState {

    private ExpressionNode expressionNode;

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(StringLiteralToken token) {
        getInput().consume();
        getInput().next().accept(this);
        this.expressionNode.setLeft(new StringNode(token.getLexeme()));
    }

    @Override
    public void visit(NumberLiteralToken token) {
        super.visit(token);
    }

    @Override
    public void visit(PlusToken token) {
        getInput().consume();
        this.expressionNode = new AdditionNode(
                null,
                (ExpressionNode) new BasicOperationParserState().parse(getInput()));
        getInput().next().accept(this);
    }

    @Override
    public void visit(MinusToken token) {
        super.visit(token);
    }

    @Override
    public void visit(SemicolonToken token) {
        // return expression
    }

    @Override
    public void visit(ClosingParenthesisToken token) {
        getInput().consume();
        getInput().next().accept(this);
    }
}
