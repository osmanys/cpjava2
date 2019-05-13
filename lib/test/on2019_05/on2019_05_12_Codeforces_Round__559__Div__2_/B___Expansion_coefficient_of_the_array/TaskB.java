package on2019_05.on2019_05_12_Codeforces_Round__559__Div__2_.B___Expansion_coefficient_of_the_array;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import static net.oz.misc.ArrayUtils.orderBy;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int d[] = new int[n];
        int idx[] = new int[n];
        for(int i = 0; i < n; i++) {
            d[i] = in.readInt();
            idx[i] = i;
        }
        orderBy(d, idx);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(min > d[i] / Math.max(idx[i], n - 1 - idx[i]))
                min = d[i] / Math.max(idx[i], n - 1 - idx[i]);
        }
        out.printLine(min);
    }
}
