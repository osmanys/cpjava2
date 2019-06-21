package on2019_06.on2019_06_19_Codeforces_Round__568__Div__2_.C2___Exam_in_BerSU__hard_version_;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.Collections;
import java.util.PriorityQueue;

public class TaskC2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        int[] t = in.readIntArray(n);
        int[] cnt = new int[101];
        cnt[t[0]]++;
        int c, s, ac = t[0];
        int[] r = new int[n];
        for (int i = 1; i < n; i++) {
            ac += t[i];
            s = 0;
            for (int j = 100; j > 0 && ac - s > m; j--) {
                c = Math.min((int) Math.ceil((double) (ac - s - m) / j), cnt[j]);
                if(c > 0) {
                    r[i] += c;
                    s += c * j;
                }
            }
            cnt[t[i]]++;
        }
        out.printLine(r);
    }
}
