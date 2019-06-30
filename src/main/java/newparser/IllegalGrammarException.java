package newparser;

public class IllegalGrammarException extends RuntimeException {

    public IllegalGrammarException(String errorMessage) {
        super(errorMessage);
    }

    public IllegalGrammarException() {
        super("Invalid grammar");
    }

}
