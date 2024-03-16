package org.vytor.lang.ast;

import java.util.LinkedList;

public class Program extends Statement{

    public LinkedList<Statement> allStatements = new LinkedList<Statement>();

    public Program() {
        super(NodeType.Program);
    }

    public LinkedList<Statement> getAllStatements() {
        return allStatements;
    }
}
