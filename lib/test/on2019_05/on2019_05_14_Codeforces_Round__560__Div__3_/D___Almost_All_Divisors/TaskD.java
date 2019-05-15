package on2019_05.on2019_05_14_Codeforces_Round__560__Div__3_.D___Almost_All_Divisors;



import net.oz.generated.collections.pair.LongIntPair;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static net.oz.numbers.IntegerUtils.*;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int d[] = in.readIntArray(n);
        List<LongIntPair> fct;
        HashMap<Long, Integer> mp = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max < d[i])
                max = d[i];
            fct = factorize(d[i]);
            for (LongIntPair p : fct) {
                if (!mp.containsKey(p.first)) {
                    mp.put(p.first, p.second);
                } else if (mp.get(p.first) < p.second) {
                    mp.replace(p.first, p.second);
                }
            }
        }
        long res = 1;
        Iterator it = mp.entrySet().iterator();
        Map.Entry pair = null;
        long pow, cnt = 1;
        while (it.hasNext()) {
            pair = (Map.Entry) it.next();
            pow = power((long) pair.getKey(), (int) pair.getValue());
            res *= pow;
            cnt *= (int) pair.getValue() + 1;
        }
        if (mp.size() == 1) {
            pow = (long) pair.getKey();
            res *= pow;
            cnt++;
        }
        if (max == res || n != cnt - 2)
            out.printLine(-1);
        else
            out.printLine(res);
    }
}
