package interpreter;

import newparser.ASTNodes.*;

import java.util.Stack;

public class Interpreter implements ASTVisitor {

    private Stack<Value> stack;
    private Console console;

    public Interpreter(Console console) {
        this.stack = new Stack<>();
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
        operation(additionNode, Value::plus);
    }

    @Override
    public void visit(SubtractionNode subtractionNode) {
        operation(subtractionNode, Value::minus);
    }

    @Override
    public void visit(DivisionNode divisionNode) {
        operation(divisionNode, new CallbackOperation() {
            @Override
            public Value execute(Value right, Value left) {
                return right.divide(left);
            }
        });
    }

    @Override
    public void visit(MultiplicationNode multiplicationNode) {
        operation(multiplicationNode, Value::times);
    }

    public void operation(ExpressionNode node, CallbackOperation operation) {
        node.left().accept(this);
        node.right().accept(this);

        Value right = this.stack.pop();
        Value left = this.stack.pop();

        Value result = operation.execute(right, left);
        this.stack.push(result);
    }

    @Override
    public void visit(CallExpressionNode callExpressionNode) {

    }

    @Override
    public void visit(StringNode value) {
        this.stack.push(new StringValue(value.getValue()));
    }

    @Override
    public void visit(IntegerNode value) {
        this.stack.push(new NumberValue(value.getValue()));
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

        if (this.stack.size() > 0) {
            Value value = this.stack.pop();
            console.log(value.getValue());
        }
    }

    private interface CallbackOperation {
        Value execute(Value right, Value left);
    }
}
