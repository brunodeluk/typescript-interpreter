package interpreter;

import lexer.ILexer;
import lexer.Lexer;
import lexer.input.Input;
import lexer.input.StringInput;
import lexer.input.TokenInput;
import lexer.tokens.Token;
import newparser.ASTNodes.ASTNode;
import newparser.Parser;
import org.junit.Test;

import static org.junit.Assert.*;

public class InterpreterTest {

    @Test
    public void should_print_hello_world() {
        Parser parser = new Parser();
        ILexer lexer = new Lexer(new StringInput("print(\"hola\" + \"mundo\" + \"todo\" + \"bien?\");"));
        Input<Token> input = new TokenInput(lexer);
        ASTNode node = parser.parse(input);
        Interpreter interpreter = new Interpreter(new Terminal());
        interpreter.start(node);
    }

}