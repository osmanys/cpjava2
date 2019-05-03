package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import static net.oz.misc.ArrayUtils.sort;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int z = in.readInt();
        int d[] = in.readIntArray(n);
        sort(d);
        int l = 0;
        int mid, r = n / 2 + 1;
        boolean valid;
        while(l + 1 < r){
            mid = (l + r) / 2;
            valid = true;
            for(int i = 0; i < mid; i++) {
                if (d[n - mid + i] - d[i] < z) {
                    valid = false;
                    break;
                }
            }
            if(valid)
                l = mid;
            else
                r = mid;
        }
        out.printLine(l);
    }
}
