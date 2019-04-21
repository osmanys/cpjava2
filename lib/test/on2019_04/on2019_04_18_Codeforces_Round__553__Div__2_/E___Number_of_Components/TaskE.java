package on2019_04.on2019_04_18_Codeforces_Round__553__Div__2_.E___Number_of_Components;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskE {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int a[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i + 1] = in.readInt();
        }
        long r = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] > a[i - 1])
                r += (long) (a[i] - a[i - 1]) * (n - a[i] + 1);
            else
                r += (long) a[i] * (a[i - 1] - a[i]);
        }
        out.printLine(r);
    }
}
