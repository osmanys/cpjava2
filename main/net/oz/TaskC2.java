package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int d[] = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = in.readInt();
        }
        boolean straight[] = new boolean[n + 1];
        int max = -1;
        boolean closed = false;
        for (int i = 0; i < n; i++) {
            if (!closed && d[i] > max) {
                straight[d[i]] = true;
                max = d[i];
            } else {
                closed = true;
            }
        }
        boolean reverse[] = new boolean[n + 1];
        max = -1;
        closed = false;
        for (int i = n - 1; i >= 0; i--) {
            if (!closed && d[i] > max) {
                reverse[d[i]] = true;
                max = d[i];
            } else {
                closed = true;
            }
        }
        int cleft = 0, cright = 0;
        for (int i = n; i > 0; i--) {
            if(straight[i] && reverse[i]){
                if(cleft == cright){
                    cright++;
                    cleft++;
                }
                else if(cleft > cright){
                    cright = 0;
                    cleft++;
                    reverse[i] = false;
                }
                else{
                    cleft = 0;
                    cright++;
                    straight[i] = false;
                }
            }
            else if(straight[i]){
                cleft++;
            }
            else if(reverse[i]){
                cright++;
            }
        }
        max = -1;
        closed = false;
        for (int i = 0; i < n; i++) {
            if (!straight[d[i]] || closed || d[i] < max) {
                closed = true;
                straight[d[i]] = false;
            }
            else{
                max = d[i];
            }
        }
        max = -1;
        closed = false;
        for (int i = n - 1; i >= 0; i--) {
            if (!reverse[d[i]] || closed || d[i] < max) {
                closed = true;
                reverse[d[i]] = false;
            }
            else{
                max = d[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean last = true;
        for (int i = 1; i <= n; i++) {
            if (straight[i] && reverse[i]){
                if(last)
                    sb.append("L");
                else
                    sb.append("R");
            }
            else if (straight[i]) {
                sb.append("L");
                last = true;
            }
            else if (reverse[i]) {
                sb.append("R");
                last = false;
            }
        }
        out.printLine(sb.length());
        out.printLine(sb.toString());
    }
}
