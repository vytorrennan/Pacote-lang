package org.vytor;

import org.vytor.lang.ExecFile;
import org.vytor.lang.Shell;

import java.io.File;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/pacote/Projects/Pacote-lang/src/main/java/org/vytor/code.pact");
        Object result = ExecFile.execFile(file);
        System.out.println(result);
    }
}