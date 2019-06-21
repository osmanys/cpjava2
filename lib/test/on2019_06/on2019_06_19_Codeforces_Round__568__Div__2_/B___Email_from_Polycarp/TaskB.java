package on2019_06.on2019_06_19_Codeforces_Round__568__Div__2_.B___Email_from_Polycarp;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.ArrayList;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s1 = in.readString();
        String s2 = in.readString();
        ArrayList<Character> ch1 = new ArrayList<>();
        ArrayList<Integer> cnt1 = new ArrayList<>();
        ArrayList<Character> ch2 = new ArrayList<>();
        ArrayList<Integer> cnt2 = new ArrayList<>();
        char ch = s1.charAt(0);
        int cnt = 1;
        for(int i = 1 ; i < s1.length(); i++){
            if(s1.charAt(i) != ch){
                ch1.add(ch);
                cnt1.add(cnt);
                ch = s1.charAt(i);
                cnt = 0;
            }
            cnt++;
        }
        ch1.add(ch);
        cnt1.add(cnt);
        ch = s2.charAt(0);
        cnt = 1;
        for(int i = 1 ; i < s2.length(); i++){
            if(s2.charAt(i) != ch){
                ch2.add(ch);
                cnt2.add(cnt);
                ch = s2.charAt(i);
                cnt = 0;
            }
            cnt++;
        }
        ch2.add(ch);
        cnt2.add(cnt);
        if(ch1.size() != ch2.size())
            out.printLine("NO");
        else {
            int i = 0;
            for (; i < ch1.size(); i++) {
                if(ch1.get(i) != ch2.get(i) || cnt1.get(i) > cnt2.get(i))
                    break;
            }
            if(i < ch1.size())
                out.printLine("NO");
            else
                out.printLine("YES");
        }
    }
}
