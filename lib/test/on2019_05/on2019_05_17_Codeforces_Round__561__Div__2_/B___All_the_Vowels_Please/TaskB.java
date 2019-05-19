package on2019_05.on2019_05_17_Codeforces_Round__561__Div__2_.B___All_the_Vowels_Please;



import net.oz.generated.collections.pair.LongIntPair;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.List;

import static net.oz.numbers.IntegerUtils.factorize;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int k = in.readInt();
        int f = -1;
        for (int i = 5; i < k; i++) {
            if (k % i == 0) {
                f = i;
                break;
            }
        }
        if (f == -1 || k / f < 5)
            out.printLine(-1);
        else {
            StringBuilder sb = new StringBuilder();
            char c[] = new char[]{'a', 'e', 'i', 'o', 'u'};
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < k / f; j++) {
                    sb.append(c[(i + j) % 5]);
                }
            }
            out.printLine(sb);
        }
    }
}
