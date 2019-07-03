package interpreter;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValueTest {

    @Test
    public void should_sum_number_with_string() {
        Value numberValue = new NumberValue(1);
        Value stringValue = new StringValue("a");
        Value result = numberValue.plus(stringValue);
        assertEquals("1a", result.getValue());
    }

    @Test
    public void should_sum_string_with_number() {
        Value numberValue = new NumberValue(1);
        Value stringValue = new StringValue("a");
        Value result = stringValue.plus(numberValue);
        assertEquals("a1", result.getValue());
    }

    @Test
    public void should_sum_1_and_3() {
        Value numberValue = new NumberValue(1);
        Value numberValue2 = new NumberValue(3);
        Value result = numberValue2.plus(numberValue);
        assertEquals(4, result.getValue());
    }

    @Test
    public void should_subtract_1_and_3() {
        Value numberValue = new NumberValue(1);
        Value numberValue2 = new NumberValue(3);
        Value result = numberValue2.minus(numberValue);
        assertEquals(2, result.getValue());
    }

    @Test
    public void should_return_negative_number() {
        Value numberValue = new NumberValue(3);
        Value numberValue2 = new NumberValue(1);
        Value result = numberValue2.minus(numberValue);
        assertEquals(-2, result.getValue());
    }

    @Test
    public void should_divide_2_and_3() {
        Value numberValue = new NumberValue(2);
        Value numberValue2 = new NumberValue(3);
        Value result = numberValue2.divide(numberValue);
        assertEquals(1, result.getValue());
    }

}