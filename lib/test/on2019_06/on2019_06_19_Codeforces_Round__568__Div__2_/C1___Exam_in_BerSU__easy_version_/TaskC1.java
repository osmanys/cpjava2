package on2019_06.on2019_06_19_Codeforces_Round__568__Div__2_.C1___Exam_in_BerSU__easy_version_;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.Arrays;

public class TaskC1 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        int[] t = in.readIntArray(n);
        int dl, ac = 0;
        int[] r = new int[n];
        for(int i = 0; i < n; i++){
            ac += t[i];
            if(ac > m){
                Arrays.sort(t, 0, i);
                dl = 0;
                for(r[i] = 1; r[i] <= i; r[i]++){
                    dl += t[i - r[i]];
                    if(ac - dl <= m)
                        break;
                }
            }
        }
        out.printLine(r);
    }
}
