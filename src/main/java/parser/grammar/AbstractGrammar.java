package parser.grammar;

import lexer.Token;
import lexer.TokenType;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGrammar implements IGrammar {

    private List<Token> tokens;

    public AbstractGrammar() {
        this.tokens = new ArrayList<>();
    }

    public void save(Token token) {
        this.tokens.add(token);
    }

    public List<Token> getTokens() {
        return this.tokens;
    }
}
