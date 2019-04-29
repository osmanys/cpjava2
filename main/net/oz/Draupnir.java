package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class Draupnir {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.readInt();
        in.readInt();
        for(int tc = 0; tc < t; tc++) {
            long d[] = new long[7];
            for(int i = 1; i <= 6; i++){
                out.printLine(i);
                out.flush();
                d[i] = in.readLong();
            }
            int res[] = new int[7];

            out.printLine(res);
            out.flush();
            if (in.readInt() != 1) {
                return;
            }
        }
    }
}
