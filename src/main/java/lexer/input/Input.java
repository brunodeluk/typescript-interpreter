package lexer.input;

public interface Input {
    void consume();
    char next();
    boolean hasNext();
}
