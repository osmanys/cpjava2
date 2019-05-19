package on2019_05.on2019_05_17_Codeforces_Round__561__Div__2_.A___Silent_Classroom;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String s[] = in.readStringArray(n);
        int g, cnt[] = new int[26];
        for(int i = 0; i < n; i++)
            cnt[s[i].charAt(0) - 'a']++;
        int res = 0;
        for(int i = 0; i < 26; i++){
            g = cnt[i] / 2;
            if(g > 0)
                res += g * (g - 1) / 2;
            if(cnt[i] - g > 0)
                res += (cnt[i] - g) * (cnt[i] - g - 1) / 2;
        }
        out.printLine(res);
    }
}
