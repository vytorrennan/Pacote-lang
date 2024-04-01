package org.vytor.lang;

import org.vytor.lang.runtimeValues.FloatValue;
import org.vytor.lang.runtimeValues.IntValue;
import org.vytor.lang.runtimeValues.NullValue;
import org.vytor.lang.runtimeValues.RuntimeValue;

import java.util.Scanner;

public class Shell {


    public static void shell() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pacote-lang v0.1");
        while (true) {
            System.out.print("> ");
            String sourceCode = scanner.nextLine();
            // LinkedList<Token> tokens = Run.run(sourceCode);
            RuntimeValue result = Run.run(sourceCode);
            if (result instanceof IntValue) {
                System.out.println(((IntValue) result).value);
            } else if (result instanceof FloatValue) {
                System.out.println(((FloatValue) result).value);
                System.out.println("Float");
            } else if (result instanceof NullValue) {
                System.out.println(((NullValue) result).value);
            }
            /*
            LinkedList<Statement> allStatements = Run.run(sourceCode);

            System.out.println(allStatements);
            for (Statement stmt: allStatements) {
                System.out.println(stmt);
                if (stmt.nodeType == NodeType.BinaryExpression) {
                    BinaryExpression bynaryExpr = (BinaryExpression) stmt;
                    System.out.println(bynaryExpr.left);
                    System.out.println(bynaryExpr.operator);
                    System.out.println(bynaryExpr.right);
                }
            }
            */
            /*
            if (tokens.get(0).exception != null) {
                System.out.println(tokens.get(0).exception);
            } else {
                System.out.println(tokens);
            }
            */
        }
    }
}
