package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.readInt();
        int b = in.readInt();
        int c = in.readInt();
        out.printLine(2L * c + 2L * Math.min(a, b) + (a != b ? 1 : 0));
    }
}
