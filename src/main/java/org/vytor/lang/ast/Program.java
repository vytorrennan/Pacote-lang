package org.vytor.lang.ast;

public class Program extends Statement{

    public Statement[] allStatements = new Statement[];

    public Program() {
        super(NodeType.Program);
    }

    public Statement[] getAllStatements() {
        return allStatements;
    }
}
