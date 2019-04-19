package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String s = in.readString();
        int da, dc, dt, dg, r = Integer.MAX_VALUE;
        for(int i = 0; i < n - 3; i++){
            da = Math.abs(s.charAt(i) - 'A');
            if(da > 13)
                da = 26 - da;
            dc = Math.abs(s.charAt(i + 1) - 'C');
            if(dc > 13)
                dc = 26 - dc;
            dt = Math.abs(s.charAt(i + 2) - 'T');
            if(dt > 13)
                dt = 26 - dt;
            dg = Math.abs(s.charAt(i + 3) - 'G');
            if(dg > 13)
                dg = 26 - dg;
            if(r > da + dc+ dt +dg)
                r = da + dc + dt + dg;
        }
        out.printLine(r);
    }
}
