package on2019_06.on2019_06_07_JUNE_Challenge_2019_Division_1.Chef_and_Ingredients;



import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.io.OutputWriter;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class ChefAndIngredientsTestCase {
    private final int MOD = 1000000007;

    @TestCase
    public Collection<Test> createTests() {
        List<Test> tests = new ArrayList<>();
        int cases = 1;

        Random rand = new Random();
        long rs, t, n, k;

        for (int testNumber = 0; testNumber < cases; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            out.printLine(1);
            n = 2;//Math.abs(rand.nextLong());
            k = Math.abs(rand.nextInt());
            out.printLine(n, k);

            rs = mod(k - 1);
            t = 1;
            while (k - t * n + t - 1 > 0) {
                rs += k - t * n + t - 1;
                rs %= MOD;
                t++;
            }
            tests.add(new Test(sw.toString(), rs + "\n"));
        }
        return tests;
    }
    private long mod(long n) {
        return n % MOD;
    }
}
