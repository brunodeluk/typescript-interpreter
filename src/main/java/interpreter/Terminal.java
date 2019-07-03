package interpreter;

import java.util.StringJoiner;

public class Terminal implements Console {

    @Override
    public void log(Object ...string) {
        StringJoiner joiner = new StringJoiner(" ");

        for (Object o : string) {
            joiner.add(String.valueOf(o));
        }

        System.out.println(joiner.toString());
    }

    @Override
    public void error(Exception e) {
        System.out.println(e.getMessage());
    }
}
