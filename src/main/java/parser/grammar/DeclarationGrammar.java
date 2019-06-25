package parser.grammar;

import lexer.TokenType;
import lexer.input.LexerInput;

public class DeclarationGrammar extends AbstractGrammar {

    @Override
    public boolean check(LexerInput lexerInput) {
        if (!lexerInput.next().getType().equals(TokenType.LET)) {
            return false;
        }

        lexerInput.consume();
        if (!lexerInput.next().getType().equals(TokenType.IDENTIFIER)) {
            return false;
        }

        save(lexerInput.next());
        lexerInput.consume();
        if (!lexerInput.next().getType().equals(TokenType.TYPE_ASSIGNATION)) {
            return false;
        }

        lexerInput.consume();
        if (!lexerInput.next().getType().equals(TokenType.STRING_TYPE) &&
            !lexerInput.next().getType().equals(TokenType.NUMBER_TYPE)) {
            return false;
        }

        save(lexerInput.next());
        lexerInput.consume();
        if (!lexerInput.next().getType().equals(TokenType.ASSIGNATION)) {
            return false;
        }

        return true;
    }
}
