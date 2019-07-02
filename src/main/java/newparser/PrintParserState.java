package newparser;

import lexer.tokens.OpenParenthesisToken;
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
    public void visit(OpenParenthesisToken token) {
        getInput().consume();
        this.printNode.setExpressionNode((ExpressionNode) new OpenParenthesisParserState().parse(getInput()));
    }
}
