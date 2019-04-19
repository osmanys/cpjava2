package on2019_04.on2019_04_18_Codeforces_Round__553__Div__2_.B___Dima_and_a_Bad_XOR0;





import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int row = -1, col = -1, d, m = in.readInt();
        int r[] = new int[n];
        boolean distinct = false;
        for(int i = 0; i < n; i++){
            r[i] = in.readInt();
            for(int j = 1; j < m; j++){
                if(r[i] != in.readInt()) {
                    distinct = true;
                    row = i;
                    col = j + 1;
                }
            }
        }
        int v = 0;
        for(int i = 0; i < n; i++){
            v ^= r[i];
        }
        if(v == 0 && !distinct)
            out.printLine("NIE");
        else{
            out.printLine("TAK");
            for(int i = 0; i < n; i++){
                out.print(v != 0 || i != row ? "1 " : (col + " "));
            }
            out.printLine();
        }
    }
}
