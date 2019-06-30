package net.oz;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.io.OutputWriter;

import java.io.StringWriter;
import java.util.*;

public class GraphsAsAServiceTestCase {
    @TestCase
    public Collection<Test> createTests() {
        List<Test> tests = new ArrayList<>();
        int cases = 1;

        Random rand = new Random();
        int u, v, z, n, m;

        for (int testNumber = 0; testNumber < cases; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            out.printLine(1);
            n = 50;//rand.nextInt(50) + 1;
            m = 10;//rand.nextInt(1000) + 1;
            out.printLine(n, m);
            for (int i = 0; i < m; i++) {
                u = rand.nextInt(n) + 1;
                v = rand.nextInt(n) + 1;
                z = rand.nextInt(1000000) + 1;
                out.printLine(u, v, z);
            }
            tests.add(new Test(sw.toString()));
        }
        return tests;
    }
}
