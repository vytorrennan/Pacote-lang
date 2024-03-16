package org.vytor.lang;

import org.vytor.lang.exceptions.Exception_;
import org.vytor.lang.lexer.Token;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Shell {


    public static void shell() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pacote-lang v0.1");
        while (true) {
            System.out.print("> ");
            String sourceCode = scanner.nextLine();
            LinkedList<Token> tokens = Run.run(sourceCode);

            if (tokens.get(0).exception != null) {
                System.out.println(tokens.get(0).exception);
            } else {
                System.out.println(tokens);
            }

        }
    }
}
