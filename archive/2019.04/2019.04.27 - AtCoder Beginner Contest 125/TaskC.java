package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import static net.oz.misc.ArrayUtils.sort;
import static net.oz.numbers.IntegerUtils.gcd;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int d[] = in.readIntArray(n);
        int g[] = new int[n];
        g[0] = d[0];
        for(int i = 1; i < n; i++)
            g[i] = gcd(d[i], g[i - 1]);
        int rg[] = new int[n];
        rg[n - 1] = d[n - 1];
        for(int i = n - 2; i >= 0; i--)
            rg[i] = gcd(d[i], rg[i + 1]);
        int c, max = Math.max(g[n - 2], rg[1]);
        for(int i = 1; i < n - 1; i++){
            c = gcd(g[i - 1], rg[i + 1]);
            if(max < c)
                max = c;
        }
        out.printLine(max);
    }
}
