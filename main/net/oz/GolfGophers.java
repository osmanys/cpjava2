package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;
import net.oz.numbers.IntegerUtils;

import static net.oz.misc.ArrayUtils.createArray;
import static net.oz.misc.ArrayUtils.sumArray;
import static net.oz.numbers.IntegerUtils.findCommon;

public class GolfGophers {
    int[] p = {7, 11, 13, 15, 16, 17};

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.readInt();
        int n = in.readInt();
        int m = in.readInt();
        for (int tn = 0; tn < t; tn++) {
            long answer = 0;
            long mod = 1;
            for (int i = 0; i < 6; i++) {
                out.printLine(createArray(18, p[i]));
                out.flush();
                int[] rem = in.readIntArray(18);
                long current = sumArray(rem) % p[i];
                answer = findCommon(answer, mod, current, p[i]);
                mod *= p[i];
            }
            out.printLine(answer);
            out.flush();
            if (in.readInt() != 1) {
                return;
            }
        }
    }
}
