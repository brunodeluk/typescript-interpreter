package lexer.input;

import lexer.input.Input;

public class StringInput implements Input {

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
    public char next() {
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

    @Override
    public int length() {
        return this.input.length();
    }
}
