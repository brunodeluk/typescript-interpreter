package newparser;

import lexer.ILexer;
import lexer.Lexer;
import lexer.input.Input;
import lexer.input.StringInput;
import lexer.input.TokenInput;
import lexer.tokens.Token;
import org.junit.Test;
import newparser.ASTNodes.ProgramNode;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void should_throw_exception_on_token_let() {
        Parser parser = new Parser();
        ILexer lexer = new Lexer(new StringInput("print(\"hola mundo, todo bien?\");"));
        Input<Token> input = new TokenInput(lexer);
    }

}