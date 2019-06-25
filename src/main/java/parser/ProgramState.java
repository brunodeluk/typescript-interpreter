package parser;

import lexer.Token;
import lexer.TokenType;
import lexer.input.LexerInput;
import parser.AST.ASTNode;
import parser.AST.Program;

public class ProgramState implements ParserState<Parser> {

    private Program program;

    public ProgramState() {
        this.program = new Program();
    }

    @Override
    public ASTNode parse(Parser parser, LexerInput lexer) {

        lexer.consume();
        Token token = lexer.next();

        if (token.getType().equals(TokenType.EOF)) {
            return program;
        }

        setState(parser, token.getType());

        program.add(parser.parse(lexer));

        return parse(parser, lexer);
    }

    public void setState(Parser parser, TokenType tokenType) {
        if (tokenType.equals(TokenType.LET)) {
            parser.setState(new DeclarationState());
        }
        else if (tokenType.equals(TokenType.IDENTIFIER)) {
            parser.setState(new AssigmentState());
        }
        else if (tokenType.equals(TokenType.PRINT)) {
            parser.setState(new PrintState());
        }
    }
}
