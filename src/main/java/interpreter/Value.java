package interpreter;

public interface Value<T> {
    Value plus(StringValue value);
    Value plus(NumberValue value);
    Value minus(StringValue value);
    Value minus(NumberValue value);
    Value times(StringValue value);
    Value times(NumberValue value);
    Value divide(StringValue value);
    Value divide(NumberValue value);

    Value divide(Value value);
    Value times(Value value);
    Value plus(Value value);
    Value minus(Value value);

    T getValue();
    String getType();
    boolean is(String type);
}
