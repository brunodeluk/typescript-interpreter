package lexer.input;

public interface Input<T> {
    void consume();
    T next();
    boolean hasNext();
}
