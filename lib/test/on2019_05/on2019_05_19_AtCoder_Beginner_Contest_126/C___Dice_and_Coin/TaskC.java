package on2019_05.on2019_05_19_AtCoder_Beginner_Contest_126.C___Dice_and_Coin;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int k = in.readInt();
        double c, res = 0;
        int p;
        for (int i = 1; i <= n && i < k; i++) {
            c = Math.log((double) k / i) / Math.log(2);
            p = (int) c;
            if (c > p)
                p++;
            res += Math.pow(0.5, p) / n;
        }
        if(n >= k){
            res += 1 - ((double)k - 1) / n;
        }
        out.printLine(res);
    }
}
