package on2019_06.on2019_06_09_AtCoder_Beginner_Contest_129.C___Typical_Stairs;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC {
    private final int MOD = 1000000007;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        boolean broke[] = new boolean[n + 1];
        for(int i = 0; i < m; i++)
            broke[in.readInt()] = true;
        long cnt[] = new long[n + 1];
        cnt[0] = 1;
        cnt[1] = broke[1] ? 0 : 1;
        for(int i = 2; i <= n; i++) {
            if(!broke[i]) {
                cnt[i] = (cnt[i - 1] + cnt[i - 2]) % MOD;
            }
        }
        out.printLine(cnt[n]);
    }
}
