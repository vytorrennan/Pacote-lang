package org.vytor.lang;

import org.vytor.lang.exceptions.Exception_;
import org.vytor.lang.lexer.Token;

import java.util.ArrayList;
import java.util.Scanner;

public class Shell {


    public static void shell() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("pacote-lang: ");
            String sourceCode = scanner.nextLine();
            ArrayList<Token> tokens = Run.run(sourceCode);

            if (tokens.get(0).exception != null) {
                System.out.println(tokens.get(0).exception);
            } else {
                System.out.println(tokens);
            }

        }
    }
}
