package on2019_06.on2019_06_08_JUNE_Challenge_2019_Division_1.Lent_Money;



import net.oz.generated.collections.comparator.IntComparator;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.Comparator;
import java.util.PriorityQueue;

import static net.oz.misc.ArrayUtils.sort;

public class LentMoney {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int a[] = in.readIntArray(n);
        int k = in.readInt();
        int x = in.readInt();

        long neg = 0, pos = 0, r = 0;
        int min = Integer.MAX_VALUE, d, cntp = 0;
        for (int i = 0; i < n; i++) {
            r += a[i];
            d = (a[i] ^ x) - a[i];
            if (d > 0) {
                pos += d;
                cntp++;
            } else
                neg += d;
            if(min > Math.abs(d))
                min = Math.abs(d);
        }
        if(k == 1) {
            r += pos;
        } else if(k == n) {
            if(pos + neg > 0)
                r += pos + neg;
        } else if((cntp & 1) == 0 || (k & 1) == 1){
            r += pos;
        } else
            r += pos - min;
        out.printLine(r);
    }
}
