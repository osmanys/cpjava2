package on2019_06.on2019_06_02_AtCoder_Grand_Contest_034.A___Kenken_Race;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int a = in.readInt() - 1;
        int b = in.readInt() - 1;
        int c = in.readInt() - 1;
        int d = in.readInt() - 1;
        String s = in.readString();
        boolean possibleA = true;
        boolean canRestA = false;
        for (int i = a; i <= c; i++) {
            if (i > 0 && s.charAt(i - 1) == '#' && s.charAt(i) == '#')
                possibleA = false;
            else if (i > 0 && i + 1 < n && s.charAt(i - 1) == '.' && s.charAt(i) == '.' && s.charAt(i + 1) == '.')
                canRestA = true;
        }
        boolean possibleB = true;
        boolean canRestB = false;
        for (int i = b; i <= d; i++) {
            if (i > 0 && s.charAt(i - 1) == '#' && s.charAt(i) == '#')
                possibleB = false;
            else if (i > 0 && i + 1 < n && s.charAt(i - 1) == '.' && s.charAt(i) == '.' && s.charAt(i + 1) == '.')
                canRestB = true;
        }
        if (!possibleA || !possibleB || (d < c && !canRestB))
            out.printLine("No");
        else
            out.printLine("Yes");
    }
}
