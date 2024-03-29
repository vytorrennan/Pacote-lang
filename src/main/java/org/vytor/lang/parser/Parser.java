package org.vytor.lang.parser;

import org.vytor.lang.ast.*;
import org.vytor.lang.lexer.Token;

import java.util.LinkedList;

public class Parser {

    private TokenNavigation tokenNavigation;

    public Parser(LinkedList<Token> tokens) {
        this.tokenNavigation = new TokenNavigation(tokens);
    }


    public Program parseToAST() {
        Program program = new Program();

        while (tokenNavigation.isNotTokenEOF()) {
            Statement statement = this.parseStatement();
            program.addStatement(statement);
            this.tokenNavigation.advance();
        }

        return program;
    }

    private Statement parseStatement() {
        // we only have expressions for now, so lets do them
        return this.parseExpression();
    }

    private Expression parseExpression() {
        return this.parseAdditiveExpression();
    }

    private Expression parseAdditiveExpression() {
        Expression left = parsePrimaryExpression();

        while (this.tokenNavigation.isNotTokenEOF() &&
                this.tokenNavigation.getCurrentToken().value.matches("[+-]")) {
            final String operator = this.tokenNavigation.getCurrentToken().value;
            this.tokenNavigation.advance();
            final Expression right = parsePrimaryExpression();
            left = new BinaryExpression(left,operator,right);
        }

        return left;
    }

    private Expression parsePrimaryExpression() {
        Token token = this.tokenNavigation.getCurrentToken();
        Expression node = switch (token.type) {
            case IDENTIFIER -> new Identifier(token.value);
            case INT -> new IntNode(Integer.parseInt(token.value));
            case FLOAT -> new FloatNode(Float.parseFloat(token.value));
            default -> null;
        };
        this.tokenNavigation.advance();
        return node;
    }

    public void setTokens(LinkedList<Token> tokens) {
        this.tokenNavigation = new TokenNavigation(tokens);
    }

}
