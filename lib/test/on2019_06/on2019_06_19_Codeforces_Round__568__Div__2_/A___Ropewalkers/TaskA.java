package on2019_06.on2019_06_19_Codeforces_Round__568__Div__2_.A___Ropewalkers;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int[] s = new int[3];
        s[0] = in.readInt();
        s[1] = in.readInt();
        s[2] = in.readInt();
        Arrays.sort(s);
        int d = in.readInt();
        int s0, s2;
        s0 = Math.min(s[1] - d, s[0]);
        s2 = Math.max(s[1] + d, s[2]);
        out.printLine(Math.abs(s[0] - s0) + Math.abs(s[2] - s2));
    }
}
