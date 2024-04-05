package org.vytor.lang;


import org.vytor.lang.interpreter.Environment;
import org.vytor.lang.interpreter.Interpreter;
import org.vytor.lang.lexer.Lexer;
import org.vytor.lang.parser.Parser;
import org.vytor.lang.runtimeValues.RuntimeValue;


public class Run {

    public static RuntimeValue run(String sourceCode, Environment env) {
        Lexer lexer = new Lexer(sourceCode);
        Parser parser = new Parser(lexer.makeTokens());
        return Interpreter.evaluate(parser.parseToAST(), env);
    }
}
