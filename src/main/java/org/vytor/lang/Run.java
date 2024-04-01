package org.vytor.lang;


import org.vytor.lang.interpreter.Environment;
import org.vytor.lang.interpreter.Interpreter;
import org.vytor.lang.lexer.Lexer;
import org.vytor.lang.parser.Parser;
import org.vytor.lang.runtimeValues.BooleanValue;
import org.vytor.lang.runtimeValues.IntValue;
import org.vytor.lang.runtimeValues.NullValue;
import org.vytor.lang.runtimeValues.RuntimeValue;


public class Run {

    public static RuntimeValue run(String sourceCode, Environment env) {
        Lexer lexer = new Lexer(sourceCode);
        Parser parser = new Parser(lexer.makeTokens());
        Interpreter interpreter = new Interpreter();
        return interpreter.evaluate(parser.parseToAST(), env);
    }
}
