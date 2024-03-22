package org.vytor.lang.parser;

import org.vytor.lang.ast.*;
import org.vytor.lang.lexer.Token;
import org.vytor.lang.lexer.TokenType;

import java.util.LinkedList;

public class Parser {

    public Parser() {
    }

    private boolean isNotTokenEOF(Token token) {
        return token.type != TokenType.EOF;
    }

    public Program parseToAST(LinkedList<Token> tokens) {
        TokenNavigation tokenNavigation = new TokenNavigation(tokens);
        Program program = new Program();

        while (isNotTokenEOF(tokenNavigation.getCurrentToken())) {
            Statement statement = this.parseStatement(tokenNavigation.getCurrentToken());
            program.addStatement(statement);
            tokenNavigation.advance();
        }

        return program;
    }

    private Statement parseStatement(Token token) {
        // we only have expressions for now, so lets do them
        return this.parseExpression(token);
    }

    private Expression parseExpression(Token token) {
        return this.parsePrimaryExpression(token);
    }

    private Expression parsePrimaryExpression(Token token) {
        return switch (token.type) {
            case IDENTIFIER -> new Identifier(token.value);
            case INT -> new IntNode(Integer.parseInt(token.value));
            case FLOAT -> new FloatNode(Float.parseFloat(token.value));
            default -> null;
        };
    }

}
