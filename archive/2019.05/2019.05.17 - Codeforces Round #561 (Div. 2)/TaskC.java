package net.oz;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.Arrays;

import static net.oz.misc.ArrayUtils.sort;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int lower, d[] = new int[n];
        for (int i = 0; i < n; i++)
            d[i] = Math.abs(in.readInt());
        sort(d);
        long cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            lower = Arrays.binarySearch(d, 2 * d[i]);
            if (lower < 0)
                lower = -lower - 2;
            if(lower < n - 1 && d[lower] == d[lower + 1])
                lower++;
            cnt += lower - i;
        }
        out.printLine(cnt);
    }
}
