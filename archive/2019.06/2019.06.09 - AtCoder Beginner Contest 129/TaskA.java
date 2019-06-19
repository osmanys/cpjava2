package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int p = in.readInt();
        int q = in.readInt();
        int r = in.readInt();
        out.printLine(Math.min(Math.min(p + q, p + r), q + r));
    }
}
