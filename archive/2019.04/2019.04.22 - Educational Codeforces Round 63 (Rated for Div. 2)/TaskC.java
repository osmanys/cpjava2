package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;
import net.oz.numbers.IntegerUtils;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        long x[] = new long[n];
        for (int i = 0; i < n; i++)
            x[i] = in.readLong();
        long p[] = new long[m];
        for (int i = 0; i < m; i++)
            p[i] = in.readLong();
        long gcd = x[1] - x[0];
        for (int i = 2; i < n; i++)
            gcd = IntegerUtils.gcd(gcd, x[i] - x[i - 1]);
        int idx;
        for (idx = 0; idx < m; idx++) {
            if (gcd % p[idx] == 0)
                break;
        }
        if(idx == m)
            out.printLine("NO");
        else{
            out.printLine("YES");
            out.printLine(x[0] + " " + (idx + 1));
        }
    }
}
