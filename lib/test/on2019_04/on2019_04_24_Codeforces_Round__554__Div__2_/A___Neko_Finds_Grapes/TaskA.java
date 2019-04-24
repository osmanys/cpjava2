package on2019_04.on2019_04_24_Codeforces_Round__554__Div__2_.A___Neko_Finds_Grapes;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        long a[] = new long[n];
        long b[] = new long[m];
        int odda = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.readLong();
            if(a[i] % 2 == 1)
                odda++;
        }
        int oddb = 0;
        for (int i = 0; i < m; i++) {
            b[i] = in.readLong();
            if(b[i] % 2 == 1)
                oddb++;
        }
        out.printLine(Math.min(odda, m - oddb) + Math.min(n - odda, oddb));
    }
}
