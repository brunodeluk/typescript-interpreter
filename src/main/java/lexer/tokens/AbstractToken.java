package lexer.tokens;

public abstract class AbstractToken implements Token {

    private String lexeme;
    private Integer line;
    private Integer column;

    public AbstractToken(String lexeme) {
        this.lexeme = lexeme;
    }

    public AbstractToken() {

    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

}
