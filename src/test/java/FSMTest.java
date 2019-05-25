import org.junit.Test;

import static org.junit.Assert.*;

public class FSMTest {

    @Test
    public void test() {

        InvalidState initialState = new InvalidState();

        ValidState validIdState = new ValidState(new Token("IDENTIFIER"));

        InvalidState idState = new InvalidState();
        idState.addRule(new Rule("[a-zA-Z]", idState));
        idState.addRule(new Rule(".", validIdState));

        initialState.addRule(new Rule("[a-zA-Z]", idState));

        ValidState openBracketState = new ValidState(new Token("OPEN_BRACKET"));
        initialState.addRule(new Rule("\\{", openBracketState));

        initialState.addRule(new Rule("\\s+", initialState));
        initialState.addRule(new Rule("\n", initialState));

        ValidState invalidTokenState = new ValidState(new Token("INVALID_TOKEN"));
        initialState.addRule(new Rule(".", invalidTokenState));

        FSM fsm = new FSM(initialState);

        Lexer lexer = new Lexer(fsm, new Input() {

            String s = "function hello() {\nreturn \"hello world\"; \n}";

            @Override
            public char charAt(int position) {
                return s.charAt(position);
            }

            @Override
            public int length() {
                return s.length();
            }
        });

        lexer.nextToken();
    }
}