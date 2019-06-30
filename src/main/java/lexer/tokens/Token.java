package lexer.tokens;

import newparser.*;

public interface Token {
    void accept(IParserVisitor visitor);
}
