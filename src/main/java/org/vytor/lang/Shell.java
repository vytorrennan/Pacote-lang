package org.vytor.lang;

import org.vytor.lang.interpreter.Environment;
import org.vytor.lang.runtimeValues.*;

import java.util.Scanner;

public class Shell {


    public static void shell() {
        Scanner scanner = new Scanner(System.in);

        Environment env = new Environment();
        env.assignVariable("x", new IntValue(100));
        env.assignVariable("true", new BooleanValue(true));
        env.assignVariable("false", new BooleanValue(false));
        env.assignVariable("null", new NullValue());
        System.out.println("Pacote-lang v0.1");
        while (true) {
            System.out.print("> ");
            String sourceCode = scanner.nextLine();
            // LinkedList<Token> tokens = Run.run(sourceCode);
            RuntimeValue result = Run.run(sourceCode, env);
            System.out.println(result.value);
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
