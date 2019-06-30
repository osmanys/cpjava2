package net.oz;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.io.OutputWriter;

import java.io.StringWriter;
import java.util.*;

public class ClassTreasurerTestCase {
    @TestCase
    public Collection<Test> createTests() {
        init();
        List<Test> tests = new ArrayList<>();
        int cases = 1;

        Random rand = new Random();
        int n, k;

        for (int testNumber = 0; testNumber < cases; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            out.printLine(1);
            n = 30;//rand.nextInt(50) + 1;
            k = rand.nextInt(7) + 1;
            out.printLine(n, k);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(rand.nextBoolean() ? 'A' : 'B');
            }
            out.printLine(sb);
            Integer r = calc(sb.toString(), k);
            //List<Integer> r = calc(sb.toString(), k);
            StringBuilder res = new StringBuilder("Case #1: ");
            /*for(Integer i : r)
                res.append(i + " ");*/
            res.append(r);
            tests.add(new Test(sw.toString(), res.toString()));
        }
        return tests;
    }

    private final int MOD = 1000000007;
    private int[] pow;

    private void init() {
        pow = new int[1000001];
        pow[0] = 1;
        for (int i = 1; i < 1000001; i++)
            pow[i] = (2 * pow[i - 1]) % MOD;
    }

    private boolean check(boolean[] v, int k) {
        int cnt;
        for (int i = 0; i < v.length; i++) {
            cnt = 0;
            for (int j = i; j < v.length; j++) {
                if (v[j])
                    cnt++;
                if (cnt > j - i + 1 - cnt + k)
                    return false;
            }
        }
        return true;
    }

    private Integer calc(String s, int k) {
        int r;
        //ArrayList<Integer> r;
        boolean[] b;
        for (long i = 0; i < (1L << s.length()); i++) {
            b = new boolean[s.length()];
            r = 0;
            //r = new ArrayList<>();
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == 'B') {
                    if (((i >> j) & 1) == 0)
                        b[j] = true;
                    else {
                        r = (r + pow[j + 1]) % MOD;
                        //r.add(j + 1);
                    }
                }
            }
            if (check(b, k))
                return r;
        }
        return 0;//new ArrayList<>();
    }
}
