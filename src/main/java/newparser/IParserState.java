package newparser;

import lexer.input.Input;
import lexer.tokens.Token;
import newparser.ASTNodes.ASTNode;

public interface IParserState {
    ASTNode parse(Input<Token> input);
}
