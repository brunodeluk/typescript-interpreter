package parser.AST;

public interface ASTVisitor {
    void visit(Program program);
    void visit(Assigment assigment);
    void visit(Addition addition);
    void visit(Subtraction subtraction);
    void visit(Division division);
    void visit(Multiplication multiplication);
    void visit(CallExpression callExpression);
    void visit(StringNode value);
    void visit(IntegerNode value);
    void visit(FloatNode value);
    void visit(VariableDeclaration variableDeclaration);
    void visit(Print print);
}
