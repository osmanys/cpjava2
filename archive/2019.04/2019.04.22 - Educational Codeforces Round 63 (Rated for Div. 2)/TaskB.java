package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String s = in.readString();
        int c = 0;
        int i;
        for(i = 0; i < n; i++){
            if(s.charAt(i) == '8') {
                if(c++ == (n - 11) / 2)
                    break;
            }
        }
        if(i == n || i > (n - 11))
            out.printLine("NO");
        else
            out.printLine("YES");
    }
}
