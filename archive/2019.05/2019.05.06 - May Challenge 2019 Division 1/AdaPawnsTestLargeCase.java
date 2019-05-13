package net.oz;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.io.OutputWriter;

import java.io.StringWriter;
import java.util.*;

public class AdaPawnsTestLargeCase {
    @TestCase
    public Collection<Test> createTests() {
        List<Test> tests = new ArrayList<>();
        int testCount = 10;

        Random rand = new Random();
        boolean b;
        int n = 100;
        for (int testNumber = 0; testNumber < testCount; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            out.printLine(1);
            out.printLine(n);
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    b = rand.nextInt(2) == 0;
                    out.print(b ? 'O' : '.');
                }
                out.printLine();
            }
            tests.add(new Test(sw.toString()));
        }
        return tests;
    }
}
