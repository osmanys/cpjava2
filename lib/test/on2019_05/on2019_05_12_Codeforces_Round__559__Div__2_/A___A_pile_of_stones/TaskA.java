package on2019_05.on2019_05_12_Codeforces_Round__559__Div__2_.A___A_pile_of_stones;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String s = in.readString();
        int st = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '-')
                st--;
            else
                st++;
            if(st < 0)
                st = 0;
        }
        out.printLine(st);
    }
}
