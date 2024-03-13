package org.vytor.lang.lexer;

public class PositionSourceCode {

    private int index;
    private int line;
    private int column;

    public PositionSourceCode(int index, int line, int column) {
        this.index = index;
        this.line = line;
        this.column = column;
    }

    public void advancePosition(Character currentChar) {
        this.index += 1;
        this.column += 1;

        if (currentChar == '\n') {
            this.line += 1;
            this.column = 0;
        }
    }

    public PositionSourceCode copy() {
        return new PositionSourceCode(this.index, this.line, this.column);
    }

    public int getIndex() {
        return index;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}
