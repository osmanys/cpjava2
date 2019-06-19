package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.HashMap;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.lang.System.arraycopy;
import static java.util.Arrays.fill;
import static net.oz.misc.MiscUtils.min;

public class ChefAndHisDish {
    private final int MOD = 1000000007;
    private int[] d;
    private int[] inv;
    private int[] fact;
    private int[] st;
    private int[] en;
    private int[] blk;
    private int[][] freq;
    private int[][] func;
    private int[] f;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int q = in.readInt();
        init(n);
        d = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int t, idx = 0;
        for (int i = 1; i <= n; i++) {
            t = in.readInt();
            if (!map.containsKey(t)) {
                idx++;
                map.put(t, idx);
            }
            d[i] = map.get(t);
        }
        build_blk(n, q);

        int l, l1, l2, r, r1, r2;
        long ans = 0;
        for (int i = 0; i < q; i++) {
            l1 = in.readInt();
            l2 = in.readInt();
            r1 = in.readInt();
            r2 = in.readInt();
            l = (int) (((long) l1 * ans + l2) % n);
            r = (int) (((long) r1 * ans + r2) % n);
            if (l > r) {
                l1 = l;
                l = r;
                r = l1;
            }
            ans = mul(fact[r - l + 1], calc_blk(l + 1, r + 1));
            out.printLine(ans);
        }
    }

    private int calc_blk(int l, int r) {
        int ans = 1;
        if (blk[l] == blk[r]) {
            for (int i = l; i <= r; ++i) {
                f[d[i]]++;
                ans = mul(ans, inv[f[d[i]]]);
            }
            for (int i = l; i <= r; ++i)
                f[d[i]] = 0;
            return ans;
        }
        ans = func[blk[l] + 1][blk[r] - 1];
        for (int i = l; i <= en[blk[l]]; ++i) {
            if (f[d[i]] == 0)
                f[d[i]] = freq[blk[r] - 1][d[i]] - freq[blk[l]][d[i]];

            f[d[i]]++;
            ans = mul(ans, inv[f[d[i]]]);
        }
        for (int i = st[blk[r]]; i <= r; ++i) {
            if (f[d[i]] == 0)
                f[d[i]] = freq[blk[r] - 1][d[i]] - freq[blk[l]][d[i]];

            f[d[i]]++;
            ans = mul(ans, inv[f[d[i]]]);
        }
        for (int i = l; i <= en[blk[l]]; ++i)
            f[d[i]] = 0;
        for (int i = st[blk[r]]; i <= r; ++i)
            f[d[i]] = 0;
        return ans;
    }

    private void build_blk(int n, int q) {
        int ctr = 0, cut = get_optimal(n, q);
        st = new int[(int) ceil((double) n / cut) + 1];
        en = new int[(int) ceil((double) n / cut) + 1];
        blk = new int[n + 1];
        for (int i = 1; i <= n; i += cut) {
            ctr++;
            st[ctr] = i;
            en[ctr] = min(n, i + cut - 1);
            for (int j = st[ctr]; j <= en[ctr]; ++j) {
                blk[j] = ctr;
            }
        }

        f = new int[n + 1];
        func = new int[ctr + 1][ctr + 1];
        freq = new int[ctr + 1][n + 1];
        for (int K = 1; K <= ctr; ++K) {
            arraycopy(freq[K - 1], 1, freq[K], 1, n);
            for (int i = st[K]; i <= en[K]; ++i)
                freq[K][d[i]]++;

            int L = K;
            int value = 1;
            func[K][K - 1] = 1;
            for (int i = st[K]; i <= n; ++i) {
                f[d[i]]++;
                value = mul(value, inv[f[d[i]]]);

                if (i == en[L]) {
                    func[K][L] = value;
                    L++;
                }
            }
            for (int i = st[K]; i <= n; ++i)
                f[d[i]] = 0;
        }
    }

    private int get_optimal(int n, int q) {
        return (int) ceil(n / sqrt(q));
    }

    private void init(int n) {
        fact = new int[n + 1];
        fact[0] = 1;
        inv = new int[n + 1];
        inv[0] = 1;
        for (int i = 1; i <= n; ++i) {
            fact[i] = (int) (((long) fact[i - 1] * i) % MOD);
            inv[i] = inverse(i);
        }
    }

    private int mul(int a, int b) {
        long r = (long) a * b;
        return (int) (r >= MOD ? r % MOD : r);
    }

    private int power(int a, int b) {
        int x = 1, y = a;
        while (b != 0) {
            if ((b & 1) == 1) {
                x = mul(x, y);
            }
            y = mul(y, y);
            b >>= 1;
        }
        return x;
    }

    private int inverse(int a) {
        return power(a, MOD - 2);
    }
}
