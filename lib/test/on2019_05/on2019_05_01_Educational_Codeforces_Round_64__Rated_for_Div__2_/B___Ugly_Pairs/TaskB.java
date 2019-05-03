package on2019_05.on2019_05_01_Educational_Codeforces_Round_64__Rated_for_Div__2_.B___Ugly_Pairs;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.readString();
        int d[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            d[s.charAt(i) - 'a']++;
        }
        int odd = 0;
        int even = 0;
        int seq = 0;
        for (int i = 0; i < 26; i++) {
            if (d[i] > 0) {
                if (i % 2 == 1)
                    odd++;
                else
                    even++;
                if (d[(i + 1) % 26] > 0)
                    seq++;
            }
        }
        StringBuilder sb0 = new StringBuilder();
        for (int i = 0; i < 26; i += 2) {
            for (int j = 0; j < d[i]; j++)
                sb0.append((char) (i + 'a'));
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = 25; i > 0; i -= 2) {
            for (int j = 0; j < d[i]; j++)
                sb1.append((char) (i + 'a'));
        }
        if (even == 0)
            out.printLine(sb1);
        else if (odd == 0)
            out.printLine(sb0);
        else if (Math.abs(sb0.charAt(sb0.length() - 1) - sb1.charAt(0)) != 1) {
            out.printLine(sb0.toString() + sb1.toString());
        } else if (Math.abs(sb0.charAt(0) - sb1.charAt(sb1.length() - 1)) != 1) {
            out.printLine(sb1.toString() + sb0.toString());
        } else if (Math.abs(sb0.charAt(0) - sb1.charAt(0)) != 1) {
            out.printLine(sb0.reverse().toString() + sb1.toString());
        } else if (Math.abs(sb0.charAt(sb0.length() - 1) - sb1.charAt(sb1.length() - 1)) != 1) {
            out.printLine(sb0.toString() + sb1.reverse().toString());
        } else
            out.printLine("No answer");
    }
}
