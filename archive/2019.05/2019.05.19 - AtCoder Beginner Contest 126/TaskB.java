package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int s = in.readInt();
        if(s / 100 >= 1 && s / 100 <= 12){
            if(s % 100 >= 1 && s % 100 <= 12)
                out.printLine("AMBIGUOUS");
            else
                out.printLine("MMYY");
        } else {
            if(s % 100 >= 1 && s % 100 <= 12)
                out.printLine("YYMM");
            else
                out.printLine("NA");
        }
    }
}
