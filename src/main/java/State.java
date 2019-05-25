import java.util.List;

public abstract class State implements Visitable {

    private String carry = "";

    public void setCarry(String carry) {
        this.carry = carry;
    }

    public String getCarry() {
        return carry;
    }

    @Override
    public abstract void accept(Visitor visitor);
}
