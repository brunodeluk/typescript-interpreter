package newparser;

import lexer.tokens.NumberLiteralToken;
import lexer.tokens.StringLiteralToken;
import newparser.ASTNodes.ASTNode;
import newparser.ASTNodes.ExpressionNode;
import newparser.ASTNodes.IntegerNode;
import newparser.ASTNodes.StringNode;

public class BasicOperationParserState extends AbstractParserState {

    private ExpressionNode expressionNode;

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(StringLiteralToken token) {
        getInput().consume();
        this.expressionNode = new StringNode(token.getLexeme());
    }

    @Override
    public void visit(NumberLiteralToken token) {
        getInput().consume();
        this.expressionNode = new IntegerNode(Integer.valueOf(token.getLexeme()));
    }
}
