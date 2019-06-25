package parser;

import lexer.Token;
import lexer.input.LexerInput;
import parser.AST.ASTNode;
import parser.AST.Declaration;
import parser.AST.Expression;
import parser.AST.Identifier;
import parser.grammar.AbstractGrammar;
import parser.grammar.DeclarationGrammar;

public class DeclarationState implements ParserState<Parser> {

    private AbstractGrammar grammar;

    public DeclarationState() {
        this.grammar = new DeclarationGrammar();
    }

    @Override
    public ASTNode parse(Parser parser, LexerInput lexer) {

        if (!grammar.check(lexer)) {
            throw new IllegalStateException("Mandaste fruta bro");
        }

        Token identifier = grammar.getTokens().get(0);
        parser.setState(new ExpressionState());

        return new Declaration(new Identifier(identifier.getValue()), ((Expression) parser.parse(lexer)));
    }
}
