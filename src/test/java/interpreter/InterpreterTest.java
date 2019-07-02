package interpreter;

import lexer.ILexer;
import lexer.Lexer;
import lexer.input.FileInput;
import lexer.input.Input;
import lexer.input.StringInput;
import lexer.input.TokenInput;
import lexer.tokens.Token;
import newparser.ASTNodes.ASTNode;
import newparser.Parser;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class InterpreterTest {

    @Test
    public void should_print_hello_world() {
        Parser parser = new Parser();
        ILexer lexer = new Lexer(new StringInput("print(1 + 1);\n"));
        Input<Token> input = new TokenInput(lexer);
        ASTNode node = parser.parse(input);
        Interpreter interpreter = new Interpreter(new Terminal());
        interpreter.start(node);
    }

    @Test
    public void interpreter_with_file() {
        ILexer lexer = null;

        try {
            lexer = new Lexer(new FileInput("src/main/resources/script"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Parser parser = new Parser();
        Input<Token> input = new TokenInput(lexer);
        ASTNode node = parser.parse(input);
        Interpreter interpreter = new Interpreter(new Terminal());
        interpreter.start(node);
    }

    @Test
    public void cero() {
        int i = 12 / 2;
        assertEquals(0, i);
    }

}