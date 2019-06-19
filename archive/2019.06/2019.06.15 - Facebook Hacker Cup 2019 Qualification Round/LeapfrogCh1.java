package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class LeapfrogCh1 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        out.print("Case #" + testNumber + ": ");
        String s = in.readString();
        int b = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'B')
                b++;
        }
        if (b > (s.length() - 2) / 2 && b < s.length() - 1)
            out.printLine("Y");
        else
            out.printLine("N");
    }
}
