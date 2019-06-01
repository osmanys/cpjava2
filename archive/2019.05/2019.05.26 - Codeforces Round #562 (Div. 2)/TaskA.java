package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int a = in.readInt();
        int x = in.readInt();
        int b = in.readInt();
        int y = in.readInt();

        for(; a != x && b != y; ) {
            if(a == b){
                out.printLine("YES");
                return;
            }
            a++;
            if(a > n)
                a = 1;
            b--;
            if(b < 1)
                b = n;
        }
        if(a == b){
            out.printLine("YES");
        } else {
            out.printLine("NO");
        }
    }
}
