package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.*;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = 200000;//in.readInt();
        int z = 10000;//in.readInt();
        int d[] = new int[n];
        Random rand = new Random(574);
        for(int i = 0; i < n; i++){
            d[i] = rand.nextInt(10000);//in.readInt();
        }
        Arrays.sort(d);
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
