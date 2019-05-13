package on2019_05.on2019_05_04_Round_1C_2019___Google_Code_Jam_2019.Robot_Programming_Strategy;



import net.oz.generated.collections.list.IntArray;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.ArrayList;

public class RobotProgrammingStrategy {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.readInt();
        String d[] = new String[a];
        ArrayList<Integer> current = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            d[i] = in.readString();
            current.add(i);
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> r, p, s;
        int idx;
        boolean win = false;
        for (int i = 0; i < 500; i++) {
            r = new ArrayList<>();
            p = new ArrayList<>();
            s = new ArrayList<>();
            for (int k = 0; k < current.size(); k++) {
                idx = current.get(k);
                if (d[idx].charAt(i % d[idx].length()) == 'R')
                    r.add(idx);
                else if (d[idx].charAt(i % d[idx].length()) == 'P')
                    p.add(idx);
                else
                    s.add(idx);
            }
            if (r.size() > 0 && p.size() > 0 && s.size() > 0) {
                break;
            } else if (r.size() == 0) {
                if (s.size() == 0) {
                    sb.append(check('P'));
                    win = true;
                    break;
                } else if (p.size() == 0) {
                    sb.append(check('S'));
                    win = true;
                    break;
                } else {
                    current = s;
                    sb.append('S');
                }
            } else if (p.size() == 0) {
                if (r.size() == 0) {
                    sb.append(check('S'));
                    win = true;
                    break;
                } else if (s.size() == 0) {
                    sb.append(check('R'));
                    win = true;
                    break;
                } else {
                    current = r;
                    sb.append('R');
                }
            } else {
                if (p.size() == 0) {
                    sb.append(check('R'));
                    win = true;
                    break;
                } else if (r.size() == 0) {
                    sb.append(check('P'));
                    win = true;
                    break;
                } else {
                    current = p;
                    sb.append('P');
                }
            }
            if(win)
                break;
        }
        if(!win){
            out.printLine("Case #" + testNumber + ": IMPOSSIBLE");
        } else {
            out.printLine("Case #" + testNumber + ": " + sb.toString());
        }
    }
    private char check(char c){
        if(c == 'R')
            return 'P';
        else if(c == 'P')
            return 'S';
        else
            return 'R';
    }
}
