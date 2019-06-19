package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.readLong();
        int t = 0;
        while (n % 2 == 0) {
            t++;
            n /= 2;
        }
        int y = 0;
        while (n % 3 == 0) {
            y++;
            n /= 3;
        }
        int z = 0;
        while (n % 5 == 0) {
            z++;
            n /= 5;
        }
        if (n > 1)
            out.printLine(-1);
        else
            out.printLine(z + y + t + y + 2 * z);
    }
}
