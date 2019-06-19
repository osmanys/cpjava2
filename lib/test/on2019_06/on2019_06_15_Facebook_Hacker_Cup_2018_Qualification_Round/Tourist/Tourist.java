package on2019_06.on2019_06_15_Facebook_Hacker_Cup_2018_Qualification_Round.Tourist;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class Tourist {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        out.print("Case #" + testNumber + ": ");
        int n = in.readInt();
        int k = in.readInt();
        long v = in.readLong();
        String s[] = in.readStringArray(n);
        for (int i = 0; i < k - n + ((v - 1) * k) % n; i++)
            out.print(s[i], " ");
        for (int i = 0; i + ((v - 1) * k) % n < n && i < k; i++)
            out.print(s[(int) (i + ((v - 1) * k) % n)], " ");
        out.printLine();
    }
}
