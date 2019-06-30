package newparser.ASTNodes;

public interface ASTNode {
    void accept(ASTVisitor visitor);
}
