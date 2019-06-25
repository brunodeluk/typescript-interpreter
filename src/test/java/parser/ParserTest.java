package parser;

import lexer.Lexer;
import lexer.input.FileInput;
import lexer.input.LexerInput;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void test() throws FileNotFoundException {
        Parser parser = new Parser();
        parser.parse(new LexerInput(new Lexer(new FileInput("src/main/resources/script"))));
    }

}