package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class ClassTreasurer {
    private final int MOD = 1000000007;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        out.print("Case #" + testNumber + ": ");
        int n = in.readInt();
        int k = in.readInt();
        String s = in.readString();
        int[] pow = new int[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++)
            pow[i] = (2 * pow[i - 1]) % MOD;
        int cnt = 0;
        int r = 0;
        for (int i = n; i > 0; i--) {
            if (s.charAt(i - 1) == 'A') {
                cnt--;
            } else {
                cnt++;
                if (cnt > k) {
                    r = (r + pow[i]) % MOD;
                    cnt -= 2;
                }
            }
            if(cnt < 0)
                cnt = 0;
        }
        out.printLine(r);
    }
}
