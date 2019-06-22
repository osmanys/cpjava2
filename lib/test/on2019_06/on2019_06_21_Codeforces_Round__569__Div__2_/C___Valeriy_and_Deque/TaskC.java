package on2019_06.on2019_06_21_Codeforces_Round__569__Div__2_.C___Valeriy_and_Deque;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int q = in.readInt();
        int[] a = in.readIntArray(n);
        int[] max = new int[n];
        int[] first = new int[n];
        int[] second = new int[n];
        int[] min = new int[n];
        max[0] = a[0];
        min[0] = a[0];
        first[0] = a[0];
        second[0] = a[1];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], a[i]);
            min[i] = Math.min(max[i - 1], a[i]);
            if (i < n) {
                first[i] = max[i - 1];
                second[i] = a[i];
            }
        }
        long m;
        for (int i = 0; i < q; i++) {
            m = in.readLong();
            if (m < n)
                out.printLine(first[(int) m], second[(int) m]);
            else
                out.printLine(max[n - 1], min[(int) ((m - n) % (n - 1)) + 1]);
        }
    }
}
