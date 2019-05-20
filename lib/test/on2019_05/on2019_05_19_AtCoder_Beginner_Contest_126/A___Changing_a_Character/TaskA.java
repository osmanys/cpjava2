package on2019_05.on2019_05_19_AtCoder_Beginner_Contest_126.A___Changing_a_Character;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int k = in.readInt();
        String s = in.readString();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(i + 1 == k)
                sb.append((char)(s.charAt(i) - 'A' + 'a'));
            else
                sb.append(s.charAt(i));
        }
        out.printLine(sb);
    }
}
