package newparser.ASTNodes;

public interface ASTVisitor {
    void visit(ProgramNode programNode);
    void visit(AssigmentNode assigmentNode);
    void visit(AdditionNode additionNode);
    void visit(SubtractionNode subtractionNode);
    void visit(DivisionNode divisionNode);
    void visit(MultiplicationNode multiplicationNode);
    void visit(StringNode value);
    void visit(IntegerNode value);
    void visit(IdentifierNode identifierNode);
    void visit(ExpressionNode expressionNode);
    void visit(DeclarationNode declarationNode);
    void visit(PrintNode printNode);
}
