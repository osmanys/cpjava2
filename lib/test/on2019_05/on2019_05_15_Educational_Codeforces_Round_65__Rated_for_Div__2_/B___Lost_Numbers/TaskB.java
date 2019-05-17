package on2019_05.on2019_05_15_Educational_Codeforces_Round_65__Rated_for_Div__2_.B___Lost_Numbers;



import net.oz.generated.collections.pair.IntIntPair;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int res[] = new int[7];
        IntIntPair p;

        out.print("? ");
        out.printLine(1, 2);
        out.flush();
        p = check(in.readInt());
        res[0] = p.first;
        res[1] = p.second;

        out.print("? ");
        out.printLine(2, 3);
        out.flush();
        p = check(in.readInt());
        res[2] = p.first;
        res[3] = p.second;

        if (res[2] == res[0]) {
            res[0] = res[1];
            res[1] = res[2];
            res[2] = res[3];
        } else if (res[2] == res[1]) {
            res[2] = res[3];
        } else if (res[3] == res[0]) {
            res[0] = res[1];
            res[1] = res[3];
        }

        out.print("? ");
        out.printLine(4, 5);
        out.flush();
        p = check(in.readInt());
        res[3] = p.first;
        res[4] = p.second;

        out.print("? ");
        out.printLine(5, 6);
        out.flush();
        p = check(in.readInt());
        res[5] = p.first;
        res[6] = p.second;

        if (res[5] == res[3]) {
            res[3] = res[4];
            res[4] = res[5];
            res[5] = res[6];
        } else if (res[5] == res[4]) {
            res[5] = res[6];
        } else if (res[6] == res[3]) {
            res[3] = res[4];
            res[4] = res[6];
        }

        out.print("! ");
        for (int i = 0; i < 6; i++)
            out.print(res[i] + " ");
        out.printLine();
        out.flush();
    }

    private IntIntPair check(int n) {
        int val[] = new int[]{4, 8, 15, 16, 23, 42};
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (val[i] * val[j] == n)
                    return new IntIntPair(val[i], val[j]);
        return null;
    }
}
