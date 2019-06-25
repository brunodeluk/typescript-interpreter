package parser.grammar;

import lexer.input.LexerInput;


public interface IGrammar {
    boolean check(LexerInput lexerInput);
}
