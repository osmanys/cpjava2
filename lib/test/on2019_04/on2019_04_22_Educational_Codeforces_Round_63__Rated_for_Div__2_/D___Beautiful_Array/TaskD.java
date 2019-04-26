package on2019_04.on2019_04_22_Educational_Codeforces_Round_63__Rated_for_Div__2_.D___Beautiful_Array;





import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int x = in.readInt();
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.readInt();
        }
        long s[] = new long[n + 1];
        for (int i = 1; i <= n; i++)
            s[i] = s[i - 1] + a[i];
        long left[] = new long[n + 1];
        long smin = 0;
        for (int i = 1; i <= n; i++) {
            smin = Math.min(s[i], smin);
            left[i] = Math.max(0, s[i] - smin);
        }
        long right[] = new long[n + 2];
        long smax = s[n];
        for (int i = n; i >= 1; i--) {
            smax = Math.max(s[i], smax);
            right[i] = Math.max(0, smax - s[i - 1]);
        }
        long res = 0, best = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, x * s[i] + right[i + 1] + best);
            res = Math.max(res, left[i]);
            best = Math.max(best, left[i] - x * s[i]);
        }
        out.printLine(res);
    }
}