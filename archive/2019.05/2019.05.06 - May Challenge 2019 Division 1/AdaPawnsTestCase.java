package net.oz;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.io.OutputWriter;

import java.io.StringWriter;
import java.util.*;

public class AdaPawnsTestCase {
    @TestCase
    public Collection<Test> createTests() {
        List<Test> tests = new ArrayList<>();
        int testCount = 1000;

        Random rand = new Random();
        boolean b;
        String res;
        int p, v, n = 5;
        loadOutput(n);

        for (int testNumber = 0; testNumber < testCount; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            out.printLine(1);
            out.printLine(n);

            res = "";
            v = 0;
            p = 1;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    b = rand.nextInt(2) == 0;
                    if (b)
                        v += p;
                    out.print(b ? 'O' : '.');
                    p *= 2;
                }
                out.printLine();
            }
            res += results[v] + "\n";
            tests.add(new Test(sw.toString(), res));
        }
        return tests;
    }

    private int results[];
    private void loadOutput(int n){
        int left, right, min, pos, max = 1 << n * n;
        results = new int[max];
        for(int i = 1; i < max; i++){
            min = Integer.MAX_VALUE;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    pos = n * r + c;
                    if((i & (1 << pos)) > 0){
                        if(r > 0 && c > 0){
                            left = n * (r - 1) + c - 1;
                            if((i & (1 << left)) > 0 && min > results[i - (1 << pos)]){
                                min = results[i - (1 << pos)] + 1;
                            }
                        }
                        if(r > 0 && c < n - 1){
                            right = n * (r - 1) + c + 1;
                            if((i & (1 << right)) > 0 && min > results[i - (1 << pos)]){
                                min = results[i - (1 << pos)] + 1;
                            }
                        }
                    }
                }
            }
            results[i] = min == Integer.MAX_VALUE ? 0 : min;
        }
    }
}
