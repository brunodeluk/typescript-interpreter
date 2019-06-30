package newparser;

import lexer.tokens.*;

public interface IParserVisitor {
    void visit(AssignationToken token);
    void visit(ClosingParenthesisToken token);
    void visit(DivisionToken token);
    void visit(EOFToken token);
    void visit(IdentifierToken token);
    void visit(LetToken token);
    void visit(MinusToken token);
    void visit(MultiplicationToken token);
    void visit(NumberLiteralToken token);
    void visit(NumberTypeToken token);
    void visit(OpenParenthesisToken token);
    void visit(PlusToken token);
    void visit(PrintToken token);
    void visit(SemicolonToken token);
    void visit(StringLiteralToken token);
    void visit(StringTypeToken token);
    void visit(TypeAssignationToken token);
}
