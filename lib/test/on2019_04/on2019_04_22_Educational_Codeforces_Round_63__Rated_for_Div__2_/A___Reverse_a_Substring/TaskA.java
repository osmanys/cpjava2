package on2019_04.on2019_04_22_Educational_Codeforces_Round_63__Rated_for_Div__2_.A___Reverse_a_Substring;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String s = in.readString();
        int i;
        for(i = 0; i < n - 1; i++){
            if(s.charAt(i) > s.charAt(i + 1))
                break;
        }
        if(i == n - 1)
            out.printLine("NO");
        else {
            out.printLine("YES");
            out.printLine((i + 1) + " " + (i + 2));
        }
    }
}
