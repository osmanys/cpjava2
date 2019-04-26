package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC1 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int d[] = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = in.readInt();
        }
        boolean straight[] = new boolean[n + 1];
        int max = -1;
        boolean closed = false;
        for (int i = 0; i < n; i++) {
            if (!closed && d[i] > max) {
                straight[d[i]] = true;
                max = d[i];
            } else {
                closed = true;
            }
        }
        boolean reverse[] = new boolean[n + 1];
        max = -1;
        closed = false;
        for (int i = n - 1; i >= 0; i--) {
            if (!closed && d[i] > max) {
                reverse[d[i]] = true;
                max = d[i];
            } else {
                closed = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (straight[i])
                sb.append("L");
            else if (reverse[i])
                sb.append("R");
        }
        out.printLine(sb.length());
        out.printLine(sb.toString());
    }
}
