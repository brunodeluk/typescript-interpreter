package interpreter;

import newparser.ASTNodes.*;

import java.util.Stack;

public class Interpreter implements ASTVisitor {

    private Stack stack;
    private Console console;

    public Interpreter(Console console) {
        this.stack = new Stack();
        this.console = console;
    }

    public void start(ASTNode astNode) {
        astNode.accept(this);
    }

    @Override
    public void visit(ProgramNode programNode) {
        programNode.getNodes().forEach(node -> node.accept(this));
    }

    @Override
    public void visit(AssigmentNode assigmentNode) {

    }

    @Override
    public void visit(AdditionNode additionNode) {
        additionNode.left().accept(this);
        additionNode.right().accept(this);

        String right = (String) this.stack.pop();
        String left = (String) this.stack.pop();

        this.stack.push(left + right);
    }

    @Override
    public void visit(SubtractionNode subtractionNode) {

    }

    @Override
    public void visit(DivisionNode divisionNode) {

    }

    @Override
    public void visit(MultiplicationNode multiplicationNode) {

    }

    @Override
    public void visit(CallExpressionNode callExpressionNode) {

    }

    @Override
    public void visit(StringNode value) {
        this.stack.push(value.getValue());
    }

    @Override
    public void visit(IntegerNode value) {

    }

    @Override
    public void visit(FloatNode value) {

    }

    @Override
    public void visit(IdentifierNode identifierNode) {

    }

    @Override
    public void visit(DeclarationNode declarationNode) {

    }

    @Override
    public void visit(ExpressionNode expressionNode) {

    }

    @Override
    public void visit(VariableDeclarationNode variableDeclarationNode) {

    }

    @Override
    public void visit(PrintNode printNode) {
        printNode.getExpressionNode().accept(this);
        String value = (String) this.stack.pop();
        console.log(value);
    }
}
