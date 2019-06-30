package newparser.ASTNodes;

public interface ASTVisitor {
    void visit(ProgramNode programNode);
    void visit(AssigmentNode assigmentNode);
    void visit(AdditionNode additionNode);
    void visit(SubtractionNode subtractionNode);
    void visit(DivisionNode divisionNode);
    void visit(MultiplicationNode multiplicationNode);
    void visit(CallExpressionNode callExpressionNode);
    void visit(StringNode value);
    void visit(IntegerNode value);
    void visit(FloatNode value);
    void visit(IdentifierNode identifierNode);
    void visit(DeclarationNode declarationNode);
    void visit(ExpressionNode expressionNode);
    void visit(VariableDeclarationNode variableDeclarationNode);
    void visit(PrintNode printNode);
}
