package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int d[] = in.readIntArray(n);
        long sum = 0;
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            sum += Math.abs(d[i]);
            if(min > Math.abs(d[i]))
                min = Math.abs(d[i]);
        }
        int m[] = new int[n];
        m[0] = 1;
        for(int i = 0; i < n - 1; i++){
            m[i + 1] = 1;
            if(m[i] * d[i] < 0) {
                m[i] *= -1;
                m[i + 1] *= -1;
            }
        }
        if(d[n - 1] * m[n - 1] >= 0)
            out.printLine(sum);
        else
            out.printLine(sum - 2 * min);
    }
}
