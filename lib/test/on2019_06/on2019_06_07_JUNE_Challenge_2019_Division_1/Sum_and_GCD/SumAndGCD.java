package on2019_06.on2019_06_07_JUNE_Challenge_2019_Division_1.Sum_and_GCD;



import net.oz.generated.collections.list.LongList;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import static net.oz.misc.ArrayUtils.sort;
import static net.oz.numbers.IntegerUtils.gcd;
import static net.oz.numbers.IntegerUtils.getDivisors;

public class SumAndGCD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int a[] = in.readIntArray(n);
        sort(a);
        LongList div = getDivisors(a[0]);
        long g0, g1, r = 0;
        for (Long d : div) {
            g1 = 0;
            g0 = a[0];
            for (int i = 1; i < (g1 == 0 ? n - 1 : n); i++) {
                if (a[i] % d == 0) {
                    g0 = gcd(g0, a[i]);
                } else {
                    if (g1 == 0)
                        g1 = a[i];
                    else
                        g1 = gcd(g1, a[i]);
                }
                if (r > g0 + (g1 != 0 ? g1 : a[n - 1]))
                    break;
            }
            if (r < g0 + (g1 != 0 ? g1 : a[n - 1]))
                r = g0 + (g1 != 0 ? g1 : a[n - 1]);
        }
        out.printLine(r);
    }
}
