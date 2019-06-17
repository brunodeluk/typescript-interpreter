package parser;

import lexer.ILexer;
import parser.AST.ASTNode;

public class DeclarationState implements ParserState<Parser> {

    @Override
    public ASTNode parse(Parser parser, ILexer lexer) {
        return null;
    }
}
