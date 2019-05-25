import java.util.ArrayList;
import java.util.List;

public class InvalidState extends State {

    private List<Rule> rules;
    private State nextState;

    public InvalidState() {
        this.rules = new ArrayList<>();
        this.nextState = this;
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public State transition(char c, String carry) {
        for (Rule rule: rules) {
            if (rule.match(String.valueOf(c))) {
                State state = rule.getNextState();
                state.setCarry(carry);
                return state;
            }
        }

        return this;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
