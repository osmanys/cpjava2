package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.readInt();
        int b = in.readInt();
        int t = in.readInt();
        out.printLine((t / a) * b);
    }
}
