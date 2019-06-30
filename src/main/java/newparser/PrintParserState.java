package newparser;

import lexer.tokens.OpenParenthesisToken;
import lexer.tokens.StringLiteralToken;
import newparser.ASTNodes.ASTNode;
import newparser.ASTNodes.ExpressionNode;
import newparser.ASTNodes.PrintNode;

public class PrintParserState extends AbstractParserState {

    private PrintNode printNode;

    public PrintParserState() {
        this.printNode = new PrintNode();
    }

    @Override
    public ASTNode getNode() {
        return this.printNode;
    }

    @Override
    public void visit(StringLiteralToken token) {
        this.printNode.setExpressionNode((ExpressionNode) new ExpressionParserState().parse(getInput()));
    }

    @Override
    public void visit(OpenParenthesisToken token) {
        getInput().consume();
        getInput().next().accept(this);
    }
}
