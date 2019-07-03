package newparser;

import lexer.input.Input;
import lexer.tokens.Token;
import newparser.ASTNodes.ASTNode;

public class Parser implements IParserState {

    private IParserState state;

    public Parser() {
        this.state = new ProgramParserState();
    }

    @Override
    public ASTNode parse(Input<Token> input) {
        return this.state.parse(input);
    }

}
