package net.oz;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.io.OutputWriter;

import java.io.StringWriter;
import java.util.*;

public class TaskC2TestCase {
    @TestCase
    public Collection<Test> createTests() {
        List<Test> tests = new ArrayList<>();
        int cases = 1;

        Random rand = new Random();
        int n, m;

        for (int testNumber = 0; testNumber < cases; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            n = 10000;//Math.abs(rand.nextLong());
            m = 100;//Math.abs(rand.nextInt());
            out.printLine(n, m);
            StringBuilder rs = new StringBuilder();
            int[] t = new int[n];
            for (int i = 0; i < n; i++)
                t[i] = rand.nextInt(m) + 1;
            out.printLine(t);

            int[] r = solve(n, m, t);
            for (int i = 0; i < n; i++)
                rs.append(r[i] + " ");

            tests.add(new Test(sw.toString(), rs + "\n"));
        }
        return tests;
    }

    private static int[] solve(int n, int m, int[] t) {
        int dl, ac = 0;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            ac += t[i];
            if (ac > m) {
                Arrays.sort(t, 0, i);
                dl = 0;
                for (r[i] = 1; r[i] <= i; r[i]++) {
                    dl += t[i - r[i]];
                    if (ac - dl <= m)
                        break;
                }
            }
        }
        return r;
    }
}
