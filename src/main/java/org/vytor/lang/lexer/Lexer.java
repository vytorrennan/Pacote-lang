package org.vytor.lang.lexer;

import org.vytor.lang.exceptions.Exception_;
import org.vytor.lang.exceptions.IllegalCharException;

import java.util.LinkedList;

public class Lexer {

    private final CodeNavigation codeNavigation;

    public Lexer(String sourceCode) {
        PositionSourceCode position = new PositionSourceCode(0, 0, 0);
        this.codeNavigation = new CodeNavigation(position, sourceCode);
    }

    public boolean isNumber(Character character) {
        final int zeroCharacterCode = 48;
        final int nineCharacterCode = 58;
        return character > zeroCharacterCode && character <= nineCharacterCode;
    }

    public boolean isAlpha(Character character) {
        return Character.isAlphabetic(character);
    }

    public Token makeNumber() {
        StringBuilder numString = new StringBuilder();
        int dotCount = 0;

        while (this.codeNavigation.getCurrentChar() != null &&
                (this.isNumber(this.codeNavigation.getCurrentChar()) ||
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

    public String makeMultiCharacter() {
        StringBuilder multiCharacter = new StringBuilder();
        while (this.codeNavigation.getCurrentChar() != null &&
                (isAlpha(this.codeNavigation.getCurrentChar()) ||
                isNumber(this.codeNavigation.getCurrentChar()) ||
                this.codeNavigation.getCurrentChar() == '_'))
        {
            multiCharacter.append(this.codeNavigation.getCurrentChar());
            this.codeNavigation.advance();
        }

        return multiCharacter.toString();
    }

    public LinkedList<Token> makeTokens() {
        // System.out.println(Keywords.KEYWORDS.get("var"));
        LinkedList<Token> tokens = new LinkedList<Token>();

        while (this.codeNavigation.getCurrentChar() != null) {
            switch (this.codeNavigation.getCurrentChar()) {
                case ' ', '\t':
                    this.codeNavigation.advance();
                    break;
                case '+', '-', '/', '*':
                    tokens.add(new Token(TokenType.BINARY_OPERATOR));
                    this.codeNavigation.advance();
                    break;
                case '=':
                    tokens.add(new Token(TokenType.EQUALS));
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
                case '{':
                    tokens.add(new Token(TokenType.OPEN_CURLY_BRACKETS));
                    this.codeNavigation.advance();
                    break;
                case '}':
                    tokens.add(new Token(TokenType.CLOSE_CURLY_BRACKETS));
                    this.codeNavigation.advance();
                    break;
                default:
                    if (isNumber(this.codeNavigation.getCurrentChar())) {
                        tokens.add(makeNumber());
                        continue;
                    }

                    if (isAlpha(this.codeNavigation.getCurrentChar())) {
                        Token token;
                        String multiCharacter = makeMultiCharacter();
                        if (Keywords.KEYWORDS.get(multiCharacter) != null) {
                            token = new Token(Keywords.KEYWORDS.get(multiCharacter), multiCharacter);
                        } else {
                            token = new Token(TokenType.IDENTIFIER, multiCharacter);
                        }
                        tokens.add(token);
                        continue;
                    }

                    Character lastChar = this.codeNavigation.getCurrentChar();
                    PositionSourceCode lastPosition = this.codeNavigation.getPosition().copy();

                    LinkedList<Token> exceptionTokenList = new LinkedList<Token>();
                    Exception_ IllegalCharacter = (Exception_) new IllegalCharException(lastPosition, lastChar);
                    Token exceptionToken = new Token(IllegalCharacter);
                    exceptionTokenList.add(exceptionToken);

                    return exceptionTokenList;
            }
        }

        return tokens;
    }
}
