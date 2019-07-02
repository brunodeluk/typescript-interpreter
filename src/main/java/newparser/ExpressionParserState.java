package newparser;

import lexer.tokens.*;
import newparser.ASTNodes.*;

public class ExpressionParserState extends AbstractParserState {

    private ExpressionNode expressionNode;
    private boolean literal;

    public ExpressionParserState() {
        this.literal = false;
    }

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(StringLiteralToken token) {
        checkStateLiteral();
        getInput().consume();
        this.expressionNode = new StringNode(token.getLexeme());
        getInput().next().accept(this);
        this.expressionNode.setLeft(new StringNode(token.getLexeme()));
    }

    @Override
    public void visit(NumberLiteralToken token) {
        checkStateLiteral();
        getInput().consume();
        this.expressionNode = new IntegerNode(Integer.valueOf(token.getLexeme()));
        getInput().next().accept(this);
        this.expressionNode.setLeft(new IntegerNode(Integer.valueOf(token.getLexeme())));
    }

    @Override
    public void visit(IdentifierToken token) {
        checkStateLiteral();
        getInput().consume();
        this.expressionNode = new IdentifierNode(token.getLexeme());
        getInput().next().accept(this);
        this.expressionNode.setLeft(new IdentifierNode(token.getLexeme()));
    }

    @Override
    public void visit(PlusToken token) {
        checkStateNotLiteral();
        getInput().consume();
        this.expressionNode = new AdditionNode(
                null,
                (ExpressionNode) new ExpressionParserState().parse(getInput()));
    }

    @Override
    public void visit(MinusToken token) {
        checkStateNotLiteral();
        getInput().consume();
        this.expressionNode = new SubtractionNode(
                null,
                (ExpressionNode) new ExpressionParserState().parse(getInput()));
    }

    @Override
    public void visit(MultiplicationToken token) {
        checkStateNotLiteral();
        getInput().consume();
        this.expressionNode = new MultiplicationNode(
                null,
                (ExpressionNode) new ExpressionParserState().parse(getInput()));
    }

    @Override
    public void visit(DivisionToken token) {
        checkStateNotLiteral();
        getInput().consume();
        this.expressionNode = new DivisionNode(
                null,
                (ExpressionNode) new ExpressionParserState().parse(getInput()));
    }

    @Override
    public void visit(ClosingParenthesisToken token) {
        checkStateNotLiteral();
        getInput().consume();
    }

    @Override
    public void visit(SemicolonToken token) {
        checkStateNotLiteral();
    }

    private void checkStateLiteral() {
        if (literal) {
            throw new IllegalGrammarException();
        }
        this.literal = true;
    }

    private void checkStateNotLiteral() {
        if (!literal) {
            throw new IllegalGrammarException();
        }

        this.literal = false;
    }
}
