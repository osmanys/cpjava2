package on2019_06.on2019_06_05_Educational_Codeforces_Round_66__Rated_for_Div__2_.A___From_Hero_to_Zero;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.readLong();
        long k = in.readLong();
        long p = 0;
        while(n > 0) {
            if(n % k == 0){
                p++;
                n /= k;
            } else {
                p += n % k;
                n -= n % k;
            }
        }
        out.printLine(p);
    }
}
