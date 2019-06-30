package newparser.ASTNodes;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode implements ASTNode {

    private List<ASTNode> nodes;

    public ProgramNode() {
        this.nodes = new ArrayList<>();
    }

    public void add(ASTNode node) {
        this.nodes.add(node);
    }

    public List<ASTNode> getNodes() {
        return nodes;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
