package lexer;

public class Token {
    private String type;
    private String value;
    private int position;
    private int column;

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", position=" + position +
                ", column=" + column +
                '}';
    }
}
