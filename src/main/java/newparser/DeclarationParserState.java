package newparser;

import lexer.tokens.IdentifierToken;
import newparser.ASTNodes.ASTNode;
import newparser.ASTNodes.DeclarationNode;
import newparser.ASTNodes.ExpressionNode;
import newparser.ASTNodes.IdentifierNode;

public class DeclarationParserState extends AbstractParserState {

    private DeclarationNode declarationNode;

    @Override
    public ASTNode getNode() {
        return this.declarationNode;
    }

    @Override
    public void visit(IdentifierToken token) {
        getInput().consume();
        TypeAssignationParserState state = new TypeAssignationParserState();
        ExpressionNode type = (ExpressionNode) state.parse(getInput());

        this.declarationNode = new DeclarationNode(
                new IdentifierNode(token.getLexeme()),
                state.getType(),
                type);
    }
}
