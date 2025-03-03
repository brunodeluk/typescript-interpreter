package lexer.input;

public class StringInput implements Input<Character> {

    private String input;
    private int position;

    public StringInput(String input) {
        this.input = input;
        this.position = 0;
    }

    @Override
    public void consume() {
        this.position++;
    }

    @Override
    public Character next() {
        return this.input.charAt(this.position);
    }

    @Override
    public boolean hasNext() {
        try {
            this.input.charAt(this.position);
        }
        catch (StringIndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }
}
