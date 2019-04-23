package on2019_04.on2019_04_22_Educational_Codeforces_Round_63__Rated_for_Div__2_.B___Game_with_Telephone_Numbers;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String s = in.readString();
        int c = 0;
        int i;
        for(i = 0; i < n; i++){
            if(s.charAt(i) == '8') {
                if(c++ == (n - 11) / 2)
                    break;
            }
        }
        if(i == n || i > (n - 11))
            out.printLine("NO");
        else
            out.printLine("YES");
    }
}
