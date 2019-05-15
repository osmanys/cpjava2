package on2019_05.on2019_05_14_Codeforces_Round__560__Div__3_.C___Good_String;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String s = in.readString();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(s.charAt(i + 1));
                i++;
            }
        }
        out.printLine(n - sb.length());
        out.printLine(sb);
    }
}
