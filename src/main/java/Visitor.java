public interface Visitor {
    void visit(ValidState validState);
    void visit(InvalidState invalidState);
}
