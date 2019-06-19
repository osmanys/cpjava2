package on2019_06.on2019_06_09_Codeforces_Round__565__Div__3_.B___Merge_it_;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int cnt0 = 0, cnt1 = 0, cnt2 = 0, d[] = in.readIntArray(n);
        for (int i = 0; i < n; i++) {
            if (d[i] % 3 == 0)
                cnt0++;
            else if (d[i] % 3 == 1)
                cnt1++;
            else
                cnt2++;
        }
        int r = Math.min(cnt1, cnt2);
        cnt1 -= r;
        cnt2 -= r;
        out.printLine(r + cnt0 + cnt1 / 3 + cnt2 / 3);
    }
}
