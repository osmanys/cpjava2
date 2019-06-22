package on2019_06.on2019_06_21_Codeforces_Round__569__Div__2_.B___Nick_and_Array;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] s = in.readIntArray(n);
        int[] r = new int[n];
        if (n == 1) {
            if (s[0] < 0)
                r[0] = -s[0] - 1;
            else
                r[0] = s[0];
        } else {
            int sign = 1;
            int max = Integer.MIN_VALUE;
            int imax = -1;
            for (int i = 0; i < n; i++) {
                if (s[i] >= 0) {
                    r[i] = -s[i] - 1;
                    sign *= -1;
                } else {
                    r[i] = s[i];
                    sign *= -1;
                }
                if (Math.abs(r[i]) > max) {
                    max = Math.abs(-s[i] - 1);
                    imax = i;
                }
            }
            if (sign == -1) {
                r[imax] = -r[imax] - 1;
            }
        }
        out.printLine(r);
    }
}
