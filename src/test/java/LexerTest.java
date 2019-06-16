import lexer.*;
import lexer.input.FileInput;
import lexer.input.StringInput;
import lexer.states.SpaceState;
import org.junit.Test;

import java.io.FileNotFoundException;

public class LexerTest {

    @Test
    public void test() {

        ILexer lexer = null;

        try {
            lexer = new Lexer(new FileInput("src/main/resources/script.txt"), new SpaceState());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(lexer.nextToken());
        System.out.println(lexer.nextToken());
        System.out.println(lexer.nextToken());
        System.out.println(lexer.nextToken());
        System.out.println(lexer.nextToken());
        System.out.println(lexer.nextToken());
        System.out.println(lexer.nextToken());
        System.out.println(lexer.nextToken());
        System.out.println(lexer.nextToken());
        System.out.println(lexer.nextToken());
        System.out.println(lexer.nextToken());
    }


}