import lexer.*;
import lexer.input.StringInput;
import lexer.states.SpaceState;
import org.junit.Test;

public class LexerTest {

    @Test
    public void test() {

        ILexer lexer = new Lexer(new StringInput("let a : String = ;"), new SpaceState());

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