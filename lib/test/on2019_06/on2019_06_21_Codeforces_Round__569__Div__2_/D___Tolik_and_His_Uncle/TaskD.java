package on2019_06.on2019_06_21_Codeforces_Round__569__Div__2_.D___Tolik_and_His_Uncle;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        int l = 1, r = n;
        while (l < r) {
            for (int i = 1; i <= m; i++) {
                out.printLine(l, i);
                out.printLine(r, m - i + 1);
            }
            l++;
            r--;
        }
        if (l == r) {
            int p = 1, q = m;
            while (p < q) {
                out.printLine(l, p);
                out.printLine(r, q);
                p++;
                q--;
            }
            if (p == q)
                out.printLine(l, p);
        }
    }
}
