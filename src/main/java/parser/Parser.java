package parser;

import lexer.input.LexerInput;
import parser.AST.ASTNode;

public class Parser extends AbstractParser {

    public Parser() {
        super(new ProgramState());
    }

    @Override
    public ASTNode parse(LexerInput lexer) {
        return getState().parse(this, lexer);
    }

}
