package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.Dictionary;
import java.util.HashSet;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long r, n = in.readLong();
        HashSet<Long> h = new HashSet<>();
        while(!h.contains(n)){
            h.add(n);
            n++;
            while(n % 10 == 0){
                n /= 10;
            }
        }
        out.printLine(h.size());
    }
}
