package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int x = in.readInt();
        int y = in.readInt();
        String s = in.readString();
        int op = 0;
        for(int i = n - 1; i >= 0; i--){
            if(i == n - 1 - y) {
                if (s.charAt(i) == '0')
                    op++;
            } else if(i > n - 1 - x){
                if (s.charAt(i) == '1')
                    op++;
            }
        }
        out.printLine(op);
    }
}
