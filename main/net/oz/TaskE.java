package net.oz;

import net.oz.generated.collections.list.IntArray;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskE {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int d[] = new int[n];
        for(int i = 0; i < n; i++)
            d[i] = in.readInt() - 1;
        List<Integer> idx = go(d, -1, n);
        if(idx == null)
            out.printLine(-1);
        else {
            int res[] = new int[n];
            int k = 1;
            for (int i : idx)
                res[i] = k++;
            for(int i = 0; i < n; i++){
                if(res[i] == 0)
                    res[i] = k++;
            }
            out.printLine(res);
        }
    }

    private List<Integer> go(int d[], int s, int e){
        int cur = s + 1;
        List<Integer> res = new ArrayList<>();
        while(cur < e){
            if(d[cur] > e)
                return null;
            if(d[cur] == -2){
                res.add(cur);
            } else {
                res.addAll(go(d, cur, d[cur]));
                if(res == null)
                    return null;
            }
            res.add(cur);
            if(d[cur] < e)
                res.add(d[cur]);
            cur = d[cur];
        }
        return res;
    }
}
