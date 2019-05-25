public class FSM implements Visitor {

    private State currentState;
    private State initialState;
    private char currentChar;
    private String carry;

    public FSM(State initialState) {
        this.currentState = initialState;
        this.initialState = initialState;
        this.carry = "";
    }

    public void nextState(char c) {
        this.currentChar = c;
        this.currentState.accept(this);
        this.carry += c;
    }

    @Override
    public void visit(ValidState validState) {
        System.out.println(validState.getToken().toString());
        this.currentState = initialState;
        this.carry = "";
    }

    @Override
    public void visit(InvalidState invalidState) {
        this.currentState = invalidState.transition(currentChar, carry);
    }
}
