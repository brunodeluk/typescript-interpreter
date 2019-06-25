package parser;

import lexer.input.LexerInput;
import parser.AST.ASTNode;

public class PrintState implements ParserState<Parser> {

    @Override
    public ASTNode parse(Parser parser, LexerInput lexer) {
        System.out.println("Estamos en el print state");
        return null;
    }
}
