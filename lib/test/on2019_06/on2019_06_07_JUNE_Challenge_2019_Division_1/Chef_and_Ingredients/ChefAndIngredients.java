package on2019_06.on2019_06_07_JUNE_Challenge_2019_Division_1.Chef_and_Ingredients;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class ChefAndIngredients {
    private final int MOD = 1000000007;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.readLong();
        long k = in.readLong();
        long t = (k - 1) / (n - 1);
        long m;
        if ((t & 1) == 1)
            m = mod(t) * mod((t + 1) / 2);
        else
            m = mod(t / 2) * mod(t + 1);
        out.printLine(mod(MOD + mod(mod(t + 1) * mod(k - 1) - mod(n - 1) * mod(m))));
    }

    private long mod(long n) {
        return n % MOD;
    }
}
