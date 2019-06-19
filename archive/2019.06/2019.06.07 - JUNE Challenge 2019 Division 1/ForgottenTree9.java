package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.Arrays;

public class ForgottenTree9 {
    private int n;
    private int[] parent;
    private InputReader in;
    private OutputWriter out;
    private int cnt = 0;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        this.in = in;
        this.out = out;
        n = in.readInt();
        parent = new int[n];
        Arrays.fill(parent, -1);
        build(0, 1);
        out.print("A ");
        out.printLine(parent);
        out.flush();
    }

    private boolean query(int x, int a, int b) {
        if (x == 0)
            return b == n;
        cnt++;
        out.printLine("Q", x, a, b);
        out.flush();
        return in.readString().equals("Yes");
    }

    private int build(int x, int st) {
        int r = x;
        int last = -1;
        while (!query(x, st, r)) {
            if (last != -1)
                parent[last - 1] = r + 1;
            last = r + 1;
            r = build(r + 1, x + 1);
        }
        if (x > 0 && last != -1)
            parent[last - 1] = x;
        return r;
    }
}
