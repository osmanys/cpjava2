package on2019_05.on2019_05_12_Codeforces_Round__559__Div__2_.D___The_minimal_unique_substring;





import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int k = in.readInt();
        int a = (n - k) / 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; sb.length() < n; i++){
            for(int j = 0; j < a && sb.length() < n; j++)
                sb.append(0);
            if(sb.length() < n)
                sb.append(1);
        }
        out.printLine(sb);
    }
}
