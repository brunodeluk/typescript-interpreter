package interpreter;

public class Terminal implements Console {
    @Override
    public void log(String string) {
        System.out.println(string);
    }
}
