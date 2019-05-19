package on2019_04.on2019_04_27_AtCoder_Beginner_Contest_125.B___Resale;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int v[] = in.readIntArray(n);
        int c[] = in.readIntArray(n);
        int res = 0;
        for(int i = 0; i < n; i++)
            if(v[i] - c[i] > 0)
                res += v[i] - c[i];
        out.printLine(res);
    }
}
