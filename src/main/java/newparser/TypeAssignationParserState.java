package newparser;

import lexer.tokens.NumberTypeToken;
import lexer.tokens.StringTypeToken;
import lexer.tokens.TypeAssignationToken;
import newparser.ASTNodes.ASTNode;
import newparser.ASTNodes.ExpressionNode;

public class TypeAssignationParserState extends AbstractParserState {

    private String type;
    private ExpressionNode expressionNode;
    private boolean hasTypeAssignation;

    public TypeAssignationParserState() {
        this.hasTypeAssignation = false;
    }

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(TypeAssignationToken token) {
        getInput().consume();
        this.hasTypeAssignation = true;
        getInput().next().accept(this);
    }

    @Override
    public void visit(NumberTypeToken token) {
        this.parseType("Number");
    }

    @Override
    public void visit(StringTypeToken token) {
        this.parseType("String");
    }

    public void parseType(String type) {
        if (!hasTypeAssignation) {
            throw new IllegalGrammarException();
        }

        getInput().consume();
        this.type = type;
        this.expressionNode = (ExpressionNode) new AssignationParserState().parse(getInput());
    }

    public String getType() {
        return this.type;
    }

}
