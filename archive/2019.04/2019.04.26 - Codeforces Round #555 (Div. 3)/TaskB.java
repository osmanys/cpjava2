package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String s = in.readString();
        int d, ds[] = new int[10];
        for (int i = 1; i <= 9; i++) {
            ds[i] = in.readInt();
        }
        int st = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            d = s.charAt(i) - '0';
            if(st == 0){
                if(ds[d] > d){
                    sb.append(ds[d]);
                    st = 1;
                }
                else{
                    sb.append(d);
                }
            }
            else if(st == 1){
                if(ds[d] >= d){
                    sb.append(ds[d]);
                }
                else{
                    sb.append(d);
                    st = 2;
                }
            }
            else {
                sb.append(d);
            }
        }
        out.printLine(sb.toString());
    }
}
