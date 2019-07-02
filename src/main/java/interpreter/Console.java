package interpreter;

public interface Console {
    void log(Object ...string);
    void error(Exception e);
}
