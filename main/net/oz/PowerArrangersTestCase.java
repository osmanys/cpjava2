package net.oz;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.io.OutputWriter;

import java.io.StringWriter;
import java.util.*;

public class PowerArrangersTestCase {
    @TestCase
    public Collection<Test> createTests() {
        List<Test> tests = new ArrayList<>();
        int testCount = 1;
        for (int testNumber = 0; testNumber < testCount; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            out.printLine(1, 150);
            int limit = 120;
            char order[] = new char[]{'B', 'A', 'E', 'D', 'C'};
            for (int d = 0; d < 5; d++) {
                limit = limit / (5 - d);
                for (int i = d; i < 5; i++) {
                    for (int j = 0; j < limit - (i == d ? 1 : 0); j++) {
                        out.printLine(order[i]);
                    }
                }
            }
            out.printLine('Y');
            tests.add(new Test(sw.toString()));
        }
        return tests;
    }
}
