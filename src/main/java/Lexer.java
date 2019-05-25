public class Lexer {

    private FSM fsm;
    private int line;
    private int column;
    private int position;
    private Input input;

    public Lexer(FSM fsm, Input input) {
        this.fsm = fsm;
        this.input = input;
    }

    public void nextToken() {
        while (position < input.length()) {
            this.fsm.nextState(input.charAt(position));
            this.position++;
        }
    }
}
