package newparser;

import lexer.input.Input;
import lexer.tokens.Token;
import newparser.ASTNodes.ASTNode;

public class Parser {

    private IParserState state;

    public Parser() {
        this.state = new ProgramParserState();
    }

    public ASTNode parse(Input<Token> input) {
        return this.state.parse(input);
    }

    public void setState(IParserState newState) {
        this.state = newState;
    }

}
