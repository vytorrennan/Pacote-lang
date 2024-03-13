package org.vytor.lang.lexer;

public class CodeNavigation {

    private final PositionSourceCode positionSourceCode;
    private final String sourceCode;
    private Character currentChar;

    public CodeNavigation(PositionSourceCode position, String sourceCode) {
        this.positionSourceCode = position;
        this.sourceCode = sourceCode;
        this.currentChar = getCurrentCharFromSourceCode();
    }

    public void advance() {
        this.positionSourceCode.advancePosition(this.currentChar);
        this.currentChar = getCurrentCharFromSourceCode();
    }

    private Character getCurrentCharFromSourceCode() {
        if (this.positionSourceCode.getIndex() < sourceCode.length()) {
            return this.sourceCode.charAt(this.position.getIndex());
        } else {
            return null;
        }
    }

    public PositionSourceCode getPosition() {
        return positionSourceCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }
    public Character getCurrentChar() {
        return currentChar;
    }

}
