package on2019_06.on2019_06_07_JUNE_Challenge_2019_Division_1.Lent_Money;





import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.io.OutputWriter;
import net.oz.misc.ArrayUtils;

import java.io.StringWriter;
import java.util.*;

import static net.oz.misc.ArrayUtils.createOrder;

public class LentMoneyTestCase {
    @TestCase
    public Collection<Test> createTests() {
        List<Test> tests = new ArrayList<>();
        int cases = 10;

        Random rand = new Random();
        int n, x, k, arr[];

        for (int testNumber = 0; testNumber < cases; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            out.printLine(1);
            n = Math.abs(rand.nextInt(7)) + 1;
            out.printLine(n);
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Math.abs(rand.nextInt(100));
            out.printLine(arr);

            k = Math.abs(rand.nextInt(n)) + 1;
            out.printLine(k);
            x = Math.abs(rand.nextInt(100));
            out.printLine(x);

            long total = 0;
            for (int a : arr)
                total += a;

            comb = new ArrayList<>();
            int order[] = createOrder(n);
            combinationUtil(order, n, k, 0, new int[k], 0);

            tests.add(new Test(sw.toString(), calc(arr, k, x, total) + "\n"));
        }
        return tests;
    }

    private long calc(int arr[], int k, int x, long r) {
        long _calc, d, max = r;
        for (Integer[] c : comb) {
            d = 0;
            for (int i = 0; i < k; i++)
                d += (arr[c[i]] ^ x) - arr[c[i]];
            if (d > 0) {
                for (int i = 0; i < k; i++)
                    arr[c[i]] = arr[c[i]] ^ x;
                _calc = calc(arr, k, x, r + d);
                for (int i = 0; i < k; i++)
                    arr[c[i]] = arr[c[i]] ^ x;
                if (max < _calc)
                    max = _calc;
            }
        }
        return max;
    }

    private ArrayList<Integer[]> comb;

    private void combinationUtil(int arr[], int n, int r, int index, int data[], int i) {
        if (index == r) {
            Integer d[] = new Integer[r];
            for (int j = 0; j < r; j++)
                d[j] = data[j];
            comb.add(d);
            return;
        }

        if (i >= n)
            return;

        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1, data, i + 1);

        combinationUtil(arr, n, r, index, data, i + 1);
    }
}
