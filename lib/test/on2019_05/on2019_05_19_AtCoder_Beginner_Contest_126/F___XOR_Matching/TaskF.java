package on2019_05.on2019_05_19_AtCoder_Beginner_Contest_126.F___XOR_Matching;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskF {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int m = in.readInt();
        int k = in.readInt();
        if(k >= (1 << m) || (k == 1 && m == 1))
            out.printLine(-1);
        else{
            if(k == 0){
                for (int i = 0; i < (1 << m); i++)
                    out.print(i + " " + i + " ");
                out.printLine();
            } else {
                for (int i = 0; i < (1 << m); i++) {
                    if (i != k)
                        out.print(i + " ");
                }
                out.print(k + " ");
                for (int i = (1 << m) - 1; i >= 0; i--) {
                    if (i != k)
                        out.print(i + " ");
                }
                out.printLine(k);
            }
        }
    }
}
