package org.vytor.lang;

import org.vytor.lang.interpreter.Environment;
import org.vytor.lang.runtimeValues.BooleanValue;
import org.vytor.lang.runtimeValues.IntValue;
import org.vytor.lang.runtimeValues.NullValue;
import org.vytor.lang.runtimeValues.RuntimeValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecFile {

    public static Object execFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        Environment env = new Environment();
        env.assignVariable("x", new IntValue(100));
        env.assignVariable("true", new BooleanValue(true));
        env.assignVariable("false", new BooleanValue(false));
        env.assignVariable("null", new NullValue());

        RuntimeValue value = new IntValue(0);
        while(scanner.hasNextLine()) {
            value = Run.run(scanner.nextLine(), env);
        }
        scanner.close();

        return value.value;
    }
}
