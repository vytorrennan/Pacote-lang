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

    public static RuntimeValue run(String sourceCode) {
        Lexer lexer = new Lexer(sourceCode);
        Parser parser = new Parser(lexer.makeTokens());
        Interpreter interpreter = new Interpreter();
        Environment env = new Environment();
        env.declareVariable("x", new IntValue(100));
        env.declareVariable("true", new BooleanValue(true));
        env.declareVariable("false", new BooleanValue(false));
        env.declareVariable("null", new NullValue());
        return interpreter.evaluate(parser.parseToAST(), env);
    }
}
