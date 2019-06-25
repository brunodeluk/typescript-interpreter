package parser.AST;

import java.util.ArrayList;
import java.util.List;

public class Program implements ASTNode {

    private List<ASTNode> nodes;

    public Program() {
        this.nodes = new ArrayList<>();
    }

    public void add(ASTNode node) {
        this.nodes.add(node);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
