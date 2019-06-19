package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import static net.oz.numbers.IntegerUtils.mul;
import static net.oz.numbers.IntegerUtils.power;

public class CountArrays {
    private final int MOD = 1000000007;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        int k = in.readInt();
        long a, b, r = 0;
        for(int i = 1; i <= k; i++){
            a = (power(i, n, MOD) - power(i - 1, n, MOD) + MOD) % MOD;
            b = (power(i, m, MOD) - power(i - 1, m, MOD) + MOD) % MOD;
            r += mul(a, b, MOD);
            r %= MOD;
        }
        out.printLine(r);
    }
}
