package on2019_04.on2019_04_18_Codeforces_Round__553__Div__2_.C___Problem_for_Nazar;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;
import net.oz.numbers.*;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int mod = 1000000007;
        long l = in.readLong();
        long r = in.readLong();
        long cr = calc(r);
        long cl = calc(l - 1);
        out.printLine((cr - cl + mod) % mod);
    }

    public long calc(long n){
        if(n == 0)
            return 0;
        int mod = 1000000007;
        long ne = 0, no = 0;
        /*int c = (int)(Math.log(n + 1) / Math.log(2) - 1);
        if(c % 2 == 0){
            ne = (IntegerUtils.power(2, c + 2) - 1) / 3;
            no = (IntegerUtils.power(2, c + 1) - 2) / 3;
            no += n - Math.pow(2, c + 1) + 1;
        }
        else{
            ne = (IntegerUtils.power(2, c + 1) - 1) / 3;
            no = (IntegerUtils.power(2, c + 2) - 2) / 3;
            ne += n - Math.pow(2, c + 1) + 1;
        }*/
        long pow, c = 0;
        int p = 0;
        while(c < n){
            pow = IntegerUtils.power(2, p);
            if(c + pow <= n){
                if((p & 1) == 0)
                    ne += pow;
                else
                    no += pow;
            }
            else{
                if((p & 1) == 0)
                    ne += n - c;
                else
                    no += n - c;
            }
            c += pow;
            p++;
        }
        ne = ne % mod;
        no = no % mod;
        return (ne * ne + no * (no + 1)) % mod;
    }
}
