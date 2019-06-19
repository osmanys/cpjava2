package net.oz;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.io.OutputWriter;

import java.io.StringWriter;
import java.util.*;

public class ChefAndHisDishTestCase {
    private final int MAX = 300000;
    private final int MOD = 1000000007;
    private int[] inv;
    private int[] fact;

    @TestCase
    public Collection<Test> createTests() {
        List<Test> tests = new ArrayList<>();
        int cases = 1;
        init();
        Random rand = new Random();
        int tmp, l, l1, l2, r, r1, r2, ans, n, q;
        int s[];
        StringBuilder rs;
        for (int testNumber = 0; testNumber < cases; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            n = MAX;//Math.abs(rand.nextInt(MAX));
            q = MAX;//Math.abs(rand.nextInt(MAX));
            out.printLine(n, q);
            s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = Math.abs(rand.nextInt(MAX));
            }
            out.printLine(s);
            rs = new StringBuilder();
            ans = 0;
            for (int i = 0; i < q; i++) {
                l1 = Math.abs(rand.nextInt(n));
                l2 = Math.abs(rand.nextInt(n));
                r1 = Math.abs(rand.nextInt(n));
                r2 = Math.abs(rand.nextInt(n));
                l = (int) (((long) l1 * ans + l2) % n);
                r = (int) (((long) r1 * ans + r2) % n);
                if (l > r) {
                    tmp = l;
                    l = r;
                    r = tmp;
                }
                out.printLine(l1, l2, r1, r2);
                ans = 0;//calc(s, l, r);
                rs.append(ans + "\n");
            }
            tests.add(new Test(sw.toString(), rs.toString()));
        }
        return tests;
    }

    private int calc(int s[], int l, int r) {
        int cnt[] = new int[MAX];
        for (int i = l; i <= r; i++)
            cnt[s[i]]++;
        int ans = fact[r - l + 1];
        for (int i = 0; i < MAX; i++)
            ans = mul(ans, inv[cnt[i]]);
        return ans;
    }

    private void init() {
        fact = new int[MAX];
        fact[0] = 1;
        inv = new int[MAX];
        inv[0] = 1;
        for (int i = 1; i < MAX; ++i) {
            fact[i] = (int) (((long) fact[i - 1] * i) % MOD);
            inv[i] = inverse(fact[i]);
        }
    }

    private int mul(int a, int b) {
        long r = (long) a * b;
        return (int) (r >= MOD ? r % MOD : r);
    }

    private int power(int a, int b) {
        int x = 1, y = a;
        while (b != 0) {
            if ((b & 1) == 1) {
                x = mul(x, y);
            }
            y = mul(y, y);
            b >>= 1;
        }
        return x;
    }

    private int inverse(int a) {
        return power(a, MOD - 2);
    }
}
