package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;
import net.oz.numbers.IntegerUtils;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long a = in.readLong();
        long b = in.readLong();
        if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        if (b % a == 0) {
            out.printLine(0);
        } else if (b - a < a) {
            out.printLine(((b - a) - a % (b - a)) % (b - a));
        } else {
            long[] div = IntegerUtils.getDivisors(b - a).toArray();
            long xres = 0, x, lcm = Long.MAX_VALUE;
            for (long d : div) {
                if (d > a) {
                    x = d - a;
                    if (lcm > b + x) {
                        lcm = b + x;
                        xres = x;
                    }
                }
            }
            out.printLine(xres);
        }
    }
}
