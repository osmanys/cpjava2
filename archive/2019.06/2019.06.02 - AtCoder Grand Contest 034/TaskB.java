package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.readString();
        int n = s.length();
        int idx = 0;
        long r = 0;
        int cntA = 0;
        char before = 'D';
        while (idx < n) {
            if (s.charAt(idx) == 'A') {
                if (before != 'A')
                    cntA = 0;
                cntA++;
                before = 'A';
            } else if (s.charAt(idx) == 'B') {
                if (before != 'A')
                    cntA = 0;
                before = 'B';
            } else {
                if (before != 'B') {
                    cntA = 0;
                    before = 'C';
                } else {
                    r += cntA;
                    before = 'A';
                }
            }
            idx++;
        }
        out.printLine(r);
    }
}
