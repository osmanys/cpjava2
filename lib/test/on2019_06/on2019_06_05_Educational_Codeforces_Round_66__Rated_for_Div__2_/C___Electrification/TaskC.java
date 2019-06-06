package on2019_06.on2019_06_05_Educational_Codeforces_Round_66__Rated_for_Div__2_.C___Electrification;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int k = in.readInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.readInt();
        int d = Integer.MAX_VALUE;
        int r = 0;
        for (int i = 0; i + k < n; i++) {
            if (d > a[i + k] - (a[i] + a[i + k]) / 2) {
                d = a[i + k] - (a[i] + a[i + k]) / 2;
                r = (a[i] + a[i + k]) / 2;
            }
        }
        out.printLine(r);
    }
}
