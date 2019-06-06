package on2019_06.on2019_06_05_Educational_Codeforces_Round_66__Rated_for_Div__2_.B___Catch_Overflow_;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    private int cur;
    private final long MAX = (1L << 32) - 1;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int l = in.readInt();
        cur = 0;
        long value = 0;
        String cmd;
        int v;
        while (cur < l) {
            cmd = in.readString();
            cur++;
            if (cmd.equals("add")) {
                value++;
                if (value > MAX) {
                    out.printLine("OVERFLOW!!!");
                    return;
                }
            } else if (cmd.equals("for")) {
                v = in.readInt();
                value += _for(v, in);
                if (value > MAX) {
                    out.printLine("OVERFLOW!!!");
                    return;
                }
            }
        }
        out.printLine(value);
    }

    private long _for(int n, InputReader in) {
        long _value = 0;
        int v;
        String cmd = in.readString();
        cur++;
        while (!cmd.equals("end")) {
            if (cmd.equals("add")) {
                _value++;
            } else if (cmd.equals("for")) {
                v = in.readInt();
                _value += _for(v, in);
                if (_value > MAX)
                    return MAX + 1;
            }
            cmd = in.readString();
            cur++;
        }
        if (_value > MAX || n * _value > MAX)
            return MAX + 1;
        return n * _value;
    }
}
