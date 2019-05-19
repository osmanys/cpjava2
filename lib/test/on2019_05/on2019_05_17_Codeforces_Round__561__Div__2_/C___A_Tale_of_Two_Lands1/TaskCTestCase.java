package on2019_05.on2019_05_17_Codeforces_Round__561__Div__2_.C___A_Tale_of_Two_Lands1;



import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.io.OutputWriter;

import java.io.StringWriter;
import java.util.*;

public class TaskCTestCase {
    @TestCase
    public Collection<Test> createTests() {
        List<Test> tests = new ArrayList<>();
        int testCount = 1000;
        Random rand = new Random();
        int d[];
        int n = 10;
        for (int testNumber = 0; testNumber < testCount; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            out.printLine(n);
            d = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = rand.nextInt(200) - 100;
            }
            out.printLine(d);
            tests.add(new Test(sw.toString(), String.valueOf(resolve(d, n))));
        }
        return tests;
    }

    private long resolve(int d[], int n) {
        long r = 0;
        int iabs, jabs;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                iabs = Math.abs(d[i]);
                jabs = Math.abs(d[j]);
                if ((iabs >= jabs && iabs <= 2 * jabs) || (jabs >= iabs && jabs <= 2 * iabs))
                    r++;
            }
        }
        return r;
    }
}
