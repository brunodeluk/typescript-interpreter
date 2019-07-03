package newparser;

import lexer.tokens.*;
import newparser.ASTNodes.*;

public class ProgramParserState extends AbstractParserState {

    private ProgramNode programNode;

    public ProgramParserState() {
        this.programNode = new ProgramNode();
    }

    @Override
    public ASTNode getNode() {
        return this.programNode;
    }

    @Override
    public void visit(EOFToken token) {

    }

    @Override
    public void visit(IdentifierToken token) {
        getInput().consume();

        programNode.add(
                new AssigmentNode(
                        new IdentifierNode(token.getLexeme()),
                        (ExpressionNode) new AssignationParserState().parse(getInput())));

        getInput().next().accept(this);
    }

    @Override
    public void visit(LetToken token) {
        getInput().consume();
        programNode.add(new DeclarationParserState().parse(getInput()));
        getInput().next().accept(this);
    }

    @Override
    public void visit(PrintToken token) {
        getInput().consume();
        programNode.add(new PrintParserState().parse(getInput()));
        getInput().next().accept(this);
    }

    @Override
    public void visit(SemicolonToken token) {
        getInput().consume();
        getInput().next().accept(this);
    }
}
