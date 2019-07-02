package lexer.states;

import lexer.tokens.SemicolonToken;
import lexer.tokens.Token;

import java.util.regex.Pattern;

public class SemiColonState extends AbstractLexerState {

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
