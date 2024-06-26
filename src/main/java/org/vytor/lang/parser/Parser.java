package org.vytor.lang.parser;

import org.vytor.lang.ast.*;
import org.vytor.lang.lexer.Token;
import org.vytor.lang.lexer.TokenType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Parser {

    private TokenNavigation tokenNavigation;

    public Parser(LinkedList<Token> tokens) {
        this.tokenNavigation = new TokenNavigation(tokens);
    }


    public Program parseToAST() {
        Program program = new Program();

        while (tokenNavigation.isNotTokenEOF()) {
            Statement statement = this.parseStatement(program);
            program.addStatement(statement);
        }

        return program;
    }

    private Statement parseStatement(Program program) {
        // we only have expressions for now, so lets do them
        switch (this.tokenNavigation.getCurrentToken().type) {
            case EQUALS:
                return parseVariableAssignment(program, program.popStatement());
            default:
                return this.parseExpression();
        }
    }

    private Statement parseVariableAssignment(Program program, Statement identifier) {
        if (!(identifier instanceof Identifier)) {
            throw new RuntimeException("Variable Assignment without identifier");
        }
        this.tokenNavigation.advance();
        Expression expression = this.parseExpression();
        if (expression instanceof Identifier && this.tokenNavigation.getCurrentToken().type == TokenType.EQUALS) {
            program.addStatement(parseVariableAssignment(program, expression));
        }
        return new VariableAssignment((Identifier) identifier, expression);
    }

    private Expression parseExpression() {
        return this.parseAdditivePrecedenceExpression();
    }

    private Expression parseAdditivePrecedenceExpression() {
        Expression left = parseMultiplicativePrecedenceExpression();

        List<String> operators = Arrays.asList("+", "-");

        while (operators.contains(this.tokenNavigation.getCurrentToken().value)) {
            final String operator = this.tokenNavigation.getCurrentToken().value;
            this.tokenNavigation.advance();
            final Expression right = parseMultiplicativePrecedenceExpression();
            left = new BinaryExpression(left,operator,right);
        }

        return left;
    }

    private Expression parseMultiplicativePrecedenceExpression() {
        Expression left = parsePrimaryExpression();

        List<String> operators = Arrays.asList("*", "/", "%");

        while (operators.contains(this.tokenNavigation.getCurrentToken().value)) {
            final String operator = this.tokenNavigation.getCurrentToken().value;
            this.tokenNavigation.advance();
            final Expression right = parsePrimaryExpression();
            left = new BinaryExpression(left,operator,right);
        }

        return left;
    }

    private Expression parsePrimaryExpression() {
        Token token = this.tokenNavigation.getCurrentToken();
        Expression node;
        switch (token.type) {
            case EXIT:
                System.exit(0);
            case IDENTIFIER:
                node = new Identifier(token.value);
                break;
            case INT:
                node = new IntNode(Integer.parseInt(token.value));
                break;
            case FLOAT:
                node = new FloatNode(Float.parseFloat(token.value));
                break;
            case OPEN_PAREN:
                this.tokenNavigation.advance();
                final Expression expression = this.parseExpression();
                if (this.tokenNavigation.getCurrentToken().type == TokenType.CLOSE_PAREN) {
                    node = expression;
                } else {
                    node = null;
                    System.out.println("Didn't found close parenthesis");
                    System.exit(0);
                }
                break;
            default:
                node = null;
        }
        this.tokenNavigation.advance();
        return node;
    }

    public void setTokens(LinkedList<Token> tokens) {
        this.tokenNavigation = new TokenNavigation(tokens);
    }

}
