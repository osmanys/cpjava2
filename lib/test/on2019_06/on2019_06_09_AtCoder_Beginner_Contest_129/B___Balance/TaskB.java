package on2019_06.on2019_06_09_AtCoder_Beginner_Contest_129.B___Balance;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int w[] = in.readIntArray(n);
        int ac[] = new int[n];
        ac[0] = w[0];
        for(int i = 1; i < n; i++){
            ac[i] = ac[i - 1] + w[i];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(min > Math.abs(ac[n - 1] - 2 * ac[i]))
                min = Math.abs(ac[n - 1] - 2 * ac[i]);
        }
        out.printLine(min);
    }
}
