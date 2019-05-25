public class ValidState extends State {

    private Token token;

    public ValidState(Token token) {
        this.token = token;
    }

    public Token getToken() {
        this.token.setValue(getCarry());
        return this.token;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
