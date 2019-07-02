package interpreter;

import newparser.IllegalGrammarException;

public class NumberValue implements Value<Integer> {

    private Integer v;

    public NumberValue(Integer value) {
        this.v = value;
    }

    @Override
    public Value plus(StringValue value) {
        return new StringValue(v + value.getValue());
    }

    @Override
    public Value plus(NumberValue value) {
        return new NumberValue(value.getValue() + v);
    }

    @Override
    public Value minus(StringValue value) {
        throw new IllegalGrammarException("Can not subtract a Number with a String");
    }

    @Override
    public Value minus(NumberValue value) {
        return new NumberValue(value.getValue() - v);
    }

    @Override
    public Value times(StringValue value) {
        throw new IllegalGrammarException("Can not multiply a Number with a String");
    }

    @Override
    public Value times(NumberValue value) {
        return new NumberValue(value.getValue() * v);
    }

    @Override
    public Value divide(StringValue value) {
        throw new IllegalGrammarException("Can not divide a Number with a String");
    }

    @Override
    public Value divide(NumberValue value) {
        if (this.v == 0) {
            throw new ArithmeticException("Can not divide by cero");
        }

        return new NumberValue(v / value.getValue());
    }

    @Override
    public Value divide(Value value) {
        return value.divide(this);
    }

    @Override
    public Value times(Value value) {
        return value.times(this);
    }

    @Override
    public Value plus(Value value) {
        return value.plus(this);
    }

    @Override
    public Value minus(Value value) {
        return value.minus(this);
    }

    public Integer getValue() {
        return this.v;
    }

    @Override
    public String getType() {
        return "Number";
    }

    @Override
    public boolean is(String type) {
        return type.equals(getType());
    }



}
