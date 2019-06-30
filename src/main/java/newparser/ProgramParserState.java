package newparser;

import lexer.tokens.*;
import newparser.ASTNodes.ASTNode;
import newparser.ASTNodes.ProgramNode;

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
        programNode.add(new AssignationParserState().parse(getInput()));
    }

    @Override
    public void visit(LetToken token) {
        getInput().consume();
        programNode.add(new DeclarationParserState().parse(getInput()));
    }

    @Override
    public void visit(PrintToken token) {
        getInput().consume();
        programNode.add(new PrintParserState().parse(getInput()));
    }

}
