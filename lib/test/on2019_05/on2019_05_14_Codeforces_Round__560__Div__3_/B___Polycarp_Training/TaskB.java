package on2019_05.on2019_05_14_Codeforces_Round__560__Div__3_.B___Polycarp_Training;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import static net.oz.misc.ArrayUtils.sort;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int d[] = in.readIntArray(n);
        sort(d);
        int cur = 1;
        int res = 0;
        for(int i = 0; i < n; i++){
            if(cur <= d[i]) {
                res++;
                cur++;
            }
        }
        out.printLine(res);
    }
}
