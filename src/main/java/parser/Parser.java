package parser;

import lexer.ILexer;
import parser.AST.ASTNode;

public class Parser extends AbstractParser {

    @Override
    public ASTNode parse(ILexer lexer) {
        return getState().parse(this, lexer);
    }

}
