package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.ArrayList;
import java.util.Vector;

public class TaskD {
    private final int MAX_SIZE = 2750131 + 1;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        manipulated_seive(MAX_SIZE);
        int n = in.readInt();
        int d[] = in.readIntArray(2 * n);
        int cnt[] = new int[MAX_SIZE];
        for (int i = 0; i < 2 * n; i++) {
            cnt[d[i]]++;
        }
        int p;
        int r[] = new int[MAX_SIZE];
        for (int i = MAX_SIZE - 1; i >= 2 ; i--) {
            if (cnt[i] > 0) {
                if (isPrime.get(i)) {
                    if(i <= 199999) {
                        p = prime.get(i - 1);
                        r[i] += cnt[p];
                        cnt[i] -= cnt[p];
                        cnt[p] = 0;
                    }
                } else {
                    p = i / SPF.get(i);
                    r[i] += cnt[i];
                    cnt[p] -= cnt[i];
                    cnt[i] = 0;
                }
            }
        }
        for (int i =  2; i < MAX_SIZE ; i++) {
            if(r[i] > 0){
                for(int j = 0; j < r[i]; j++)
                    out.print(i + " ");
            }
        }
        out.printLine();
    }

    private Vector<Boolean> isPrime;
    private Vector<Integer> prime;
    private Vector<Integer> SPF;

    private void manipulated_seive(int N) {
        isPrime = new Vector<>(MAX_SIZE);
        prime = new Vector<>();
        SPF = new Vector<>(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++){
            isPrime.add(true);
            SPF.add(2);
        }

        isPrime.set(0, false);
        isPrime.set(1, false);

        for (int i = 2; i < N; i++) {
            if (isPrime.get(i)) {
                prime.add(i);
                SPF.set(i, i);
            }

            for (int j = 0; j < prime.size() && i * prime.get(j) < N && prime.get(j) <= SPF.get(i); j++) {
                isPrime.set(i * prime.get(j), false);
                SPF.set(i * prime.get(j), prime.get(j));
            }
        }
    }
}
