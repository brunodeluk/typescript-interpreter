import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rule {

    private Pattern pattern;
    private State nextState;

    public Rule(String pattern, State nextState) {
        this.pattern = Pattern.compile(pattern);
        this.nextState = nextState;
    }

    public boolean match(String value) {
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public State getNextState() {
        return nextState;
    }
}
