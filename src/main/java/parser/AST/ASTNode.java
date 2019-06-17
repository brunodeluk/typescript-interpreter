package parser.AST;

public interface ASTNode {
    void accept(ASTVisitor visitor);
}
