package org.vytor.lang.lexer;

import org.vytor.lang.exceptions.Exception_;
import org.vytor.lang.exceptions.IllegalCharException;

import java.util.ArrayList;

public class Lexer {

    private final CodeNavigation codeNavigation;

    public Lexer(String sourceCode) {
        PositionSourceCode position = new PositionSourceCode(0, 0, 0);
        this.codeNavigation = new CodeNavigation(position, sourceCode);
    }

    public Token makeNumber() {
        StringBuilder numString = new StringBuilder();
        int dotCount = 0;
        final String digits = "0123456789";

        while (this.codeNavigation.getCurrentChar() != null &&
                (digits.indexOf(this.codeNavigation.getCurrentChar()) != -1 ||
                this.codeNavigation.getCurrentChar().equals('.')))
        {
            if (this.codeNavigation.getCurrentChar().equals('.')) {
                if (dotCount == 1)
                    break;
                dotCount++;
                numString.append(".");
            } else {
                numString.append(this.codeNavigation.getCurrentChar());
            }
            this.codeNavigation.advance();
        }

        if (dotCount == 0) {
            return new Token(TokenType.INT, numString.toString());
        } else {
            return new Token(TokenType.FLOAT, numString.toString());
        }
    }

    public ArrayList<Token> makeTokens() {
        ArrayList<Token> tokens = new ArrayList<Token>();

        while (this.codeNavigation.getCurrentChar() != null) {
            switch (this.codeNavigation.getCurrentChar()) {
                case ' ', '\t':
                    this.codeNavigation.advance();
                    break;
                case '+':
                    tokens.add(new Token(TokenType.PLUS));
                    this.codeNavigation.advance();
                    break;
                case '-':
                    tokens.add(new Token(TokenType.MINUS));
                    this.codeNavigation.advance();
                    break;
                case '*':
                    tokens.add(new Token(TokenType.MUL));
                    this.codeNavigation.advance();
                    break;
                case '/':
                    tokens.add(new Token(TokenType.DIV));
                    this.codeNavigation.advance();
                    break;
                case '(':
                    tokens.add(new Token(TokenType.OPEN_PAREN));
                    this.codeNavigation.advance();
                    break;
                case ')':
                    tokens.add(new Token(TokenType.CLOSE_PAREN));
                    this.codeNavigation.advance();
                    break;
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                    tokens.add(makeNumber());
                    break;
                default:
                    Character lastChar = this.codeNavigation.getCurrentChar();
                    PositionSourceCode lastPosition = this.codeNavigation.getPosition().copy();

                    ArrayList<Token> exceptionTokenList = new ArrayList<Token>();
                    Exception_ IllegalCharacter = (Exception_) new IllegalCharException(lastPosition, lastChar);
                    Token exceptionToken = new Token(IllegalCharacter);
                    exceptionTokenList.add(exceptionToken);

                    return exceptionTokenList;
            }
        }

        return tokens;
    }

}
