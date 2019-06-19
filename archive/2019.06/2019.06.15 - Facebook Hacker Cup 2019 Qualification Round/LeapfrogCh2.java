package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class LeapfrogCh2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        out.print("Case #" + testNumber + ": ");
        String s = in.readString();
        int b = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'B')
                b++;
        }
        if ((s.length() == 3 && b == 1) || (b < s.length() - 1 && b > 1))
            out.printLine("Y");
        else
            out.printLine("N");
    }
}
