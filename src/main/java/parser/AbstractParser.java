package parser;

import parser.AST.ASTNode;

public abstract class AbstractParser implements IParser {

    private ParserState<Parser> state;
    private ASTNode node;

    public void setState(ParserState<Parser> state) {
        this.state = state;
    }

    public ParserState<Parser> getState() {
        return state;
    }

    public ASTNode getNode() {
        return node;
    }
}
