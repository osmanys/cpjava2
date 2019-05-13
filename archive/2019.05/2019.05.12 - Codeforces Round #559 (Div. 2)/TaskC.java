package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import static net.oz.misc.ArrayUtils.sort;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        int b[] = new int[n];
        int g[] = new int[m];
        long totalb = 0;
        for (int i = 0; i < n; i++) {
            b[i] = in.readInt();
            totalb += b[i];
        }
        long totalg = 0;
        for (int i = 0; i < m; i++) {
            g[i] = in.readInt();
            totalg += g[i];
        }
        sort(b);
        sort(g);
        if (b[n - 1] > g[0])
            out.printLine(-1);
        else if(b[n - 1] == g[0]){
            out.printLine(totalg + m * (totalb - b[n - 1]));
        } else {
            out.printLine(totalg + b[n - 1] + 1L * (m - 1) * b[n - 2] + m * (totalb - b[n - 1] - b[n - 2]));
        }
    }
}
