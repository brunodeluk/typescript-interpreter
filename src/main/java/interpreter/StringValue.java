package interpreter;

import newparser.IllegalGrammarException;

public class StringValue implements Value {

    private final String TYPE = "String";
    private String v;

    public StringValue(String value) {
        this.v = value;
    }

    @Override
    public Value plus(StringValue value) {
        return new StringValue(v + value.getValue());
    }

    @Override
    public Value plus(NumberValue value) {
        return new StringValue(v + value.getValue());
    }

    @Override
    public Value minus(StringValue value) {
        throw new IllegalGrammarException("Can not subtract a String with a String");
    }

    @Override
    public Value minus(NumberValue value) {
        throw new IllegalGrammarException("Can not subtract a String with a Number");
    }

    @Override
    public Value times(StringValue value) {
        throw new IllegalGrammarException("Can not multiply a String with a String");
    }

    @Override
    public Value times(NumberValue value) {
        throw new IllegalGrammarException("Can not multiply a Number with a String");
    }

    @Override
    public Value divide(StringValue value) {
        throw new IllegalGrammarException("Can not divide a String with a String");
    }

    @Override
    public Value divide(NumberValue value) {
        throw new IllegalGrammarException("Can not divide a Number with a String");
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

    @Override
    public String getValue() {
        return this.v;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public boolean is(String type) {
        return type.equals(getType());
    }
}
