package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.ArrayList;


public class PowerArrangers {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.readInt();
        in.readInt();
        int last = 0, idx, r;
        ArrayList<Integer> cur = new ArrayList<>();
        for (int i = 0; i < 119; i++) {
            cur.add(i);
        }
        ArrayList<Integer> tmp[];
        StringBuilder sb;
        for (int tn = 0; tn < t; tn++) {
            sb = new StringBuilder();
            for (int d = 1; d < 5; d++) {
                tmp = new ArrayList[5];
                for (int i = 0; i < 5; i++)
                    tmp[i] = new ArrayList<>();
                for (int k : cur) {
                    out.printLine(5 * k + d);
                    out.flush();
                    r = in.readCharacter() - 'A';
                    tmp[r].add(k);
                }
                if (d < 4) {
                    for (idx = 0; idx < 5; idx++) {
                        if (tmp[idx].size() == val(d))
                            break;
                    }
                    sb.append((char) ('A' + idx));
                    cur = tmp[idx];
                } else {
                    for (idx = 0; idx < 5; idx++) {
                        if (tmp[idx].size() == 1) {
                            last = idx;
                            break;
                        }
                    }
                }
            }
            int cnt[] = new int[5];
            for (int i = 0; i < sb.length(); i++) {
                cnt[sb.charAt(i) - 'A']++;
            }
            for (int i = 0; i < 5; i++) {
                if (cnt[i] == 0 && i != last) {
                    sb.append((char) ('A' + i));
                    break;
                }
            }
            sb.append((char) ('A' + last));
            out.printLine(sb.toString());
            out.flush();
            if (in.readCharacter() != 'Y') {
                return;
            }
        }
    }
    private int val(int d){
        if(d == 1)
            return 23;
        else if(d == 2)
            return 5;
        else
            return 1;
    }
}
