package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        int ta = in.readInt();
        int tb = in.readInt();
        int k = in.readInt();
        long a[] = in.readLongArray(n);
        long b[] = in.readLongArray(m);
        if (n <= k || m <= k) {
            out.printLine(-1);
        } else {
            long max = 0;
            int lower;
            for (int i = 0; i <= k && i < n; i++) {
                if (a[i] + ta > b[m - 1 - (k - i)]) {
                    max = -1;
                    break;
                } else {
                    lower = Arrays.binarySearch(b, 1L * a[i] + ta);
                    if (lower < 0)
                        lower = -lower - 1;
                    if(lower + k - i >= m) {
                        max = -1;
                        break;
                    } else {
                        if (max < 1L * b[lower + k - i] + tb)
                            max = 1L * b[lower + k - i] + tb;
                    }
                }
            }
            out.printLine(max);
        }
    }
}
