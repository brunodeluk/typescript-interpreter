package lexer.states;

import lexer.Lexer;
import lexer.tokens.SemicolonToken;
import lexer.tokens.Token;

import java.util.regex.Pattern;

public class SemiColonState extends DelimiterState {

    @Override
    public Token getToken() {
        return new SemicolonToken();
    }

    @Override
    public LexerState getNextState() {
        return new KeywordState();
    }

    @Override
    public boolean match(char c) {
        return Pattern.matches(";", String.valueOf(c));
    }
}
