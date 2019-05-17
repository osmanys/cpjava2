package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String s = in.readString();
        int first8 = -1;
        for(int i = 0; i < n; i++)
            if(s.charAt(i) == '8') {
                first8 = i;
                break;
            }
        if(first8 != -1 && n - first8 >= 11)
            out.printLine("YES");
        else
            out.printLine("NO");
    }
}
