package lexer.input;

import lexer.ILexer;
import lexer.Lexer;
import lexer.tokens.LetToken;
import lexer.tokens.Token;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.instanceOf;

public class TokenInputTest {

    @Test
    public void should_return_let_token() {
        ILexer lexer = new Lexer(new StringInput("let a;"));
        Input<Token> input = new TokenInput(lexer);
        input.consume();
        Token t = input.next();
        assertThat(t, instanceOf(LetToken.class));
    }

    @Test
    public void should_not_have_next_token() {
        ILexer lexer = new Lexer(new StringInput(""));
        Input input = new TokenInput(lexer);
        input.consume();
        assertFalse(input.hasNext());
    }

    @Test
    public void should_have_next_token() {
        ILexer lexer = new Lexer(new StringInput("Let;"));
        Input input = new TokenInput(lexer);
        input.consume();
        assertTrue(input.hasNext());
    }

}