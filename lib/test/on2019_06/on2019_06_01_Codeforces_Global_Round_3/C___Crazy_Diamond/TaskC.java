package on2019_06.on2019_06_01_Codeforces_Global_Round_3.C___Crazy_Diamond;



import net.oz.collections.Pair;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.ArrayList;

public class TaskC {
    private void change(int x, int y, int idx[], int p[], ArrayList<Pair<Integer, Integer>> m){
        int px = p[x];
        int py = p[y];
        idx[px] = y;
        idx[py] = x;

        p[x] = py;
        p[y] = px;

        m.add(Pair.makePair(x, y));
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int p[] = new int[n];
        int idx[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.readInt() - 1;
            idx[p[i]] = i;
        }
        int tmp;
        ArrayList<Pair<Integer, Integer>> m = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if(i == idx[i])
                continue;
            if(2 * Math.abs(i - idx[i]) >= n){
                change(i, idx[i], idx, p, m);
            } else {
                if(idx[i] < n / 2){
                    change(idx[i], idx[i] + n / 2, idx, p, m);
                    change(idx[i], i, idx, p, m);
                } else {
                    if(i >= n / 2) {
                        tmp = idx[i];
                        change(idx[i], i - n / 2, idx, p, m);
                        change(i - n / 2, i, idx, p, m);
                        change(i - n / 2, tmp, idx, p, m);
                    } else {
                        tmp = idx[i];
                        change(idx[i], idx[i] - n / 2, idx, p, m);
                        change(idx[i], i + n / 2, idx, p, m);
                        change(i, i + n / 2, idx, p, m);
                        change(tmp - n / 2, tmp, idx, p, m);
                    }
                }
            }
        }
        out.printLine(m.size());
        for(Pair<Integer, Integer> pair : m){
            out.printLine(pair.first + 1, pair.second + 1);
        }
    }
}
