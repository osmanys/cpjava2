package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class FairFight {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int k = in.readInt();
        int c[] = new int[n];
        SegmentTreeRMQ cst = new SegmentTreeRMQ();
        for(int i = 0; i < n; i++){
            c[i] = in.readInt();
        }
        cst.constructST(c, n);
        SegmentTreeRMQ dst = new SegmentTreeRMQ();
        int d[] = new int[n];
        for(int i = 0; i < n; i++){
            d[i] = in.readInt();
        }
        dst.constructST(d, n);
        long res = 0;
        for(int l = 0; l < n; l++){
            for(int r = l; r < n; r++){
                if(Math.abs(cst.RMQ(n, l, r) - dst.RMQ(n, l, r)) <= k)
                    res++;
            }
        }
        out.printLine("Case #" + testNumber + ": " + res);
    }
}
class SegmentTreeRMQ {
    int[] st;

    int maxVal(int x, int y) {
        return (x > y) ? x : y;
    }

    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    int RMQUtil(int ss, int se, int qs, int qe, int index) {
        if (qs <= ss && qe >= se)
            return st[index];

        if (se < qs || ss > qe)
            return Integer.MIN_VALUE;

        int mid = getMid(ss, se);
        return maxVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1),
                RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
    }

    int RMQ(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return RMQUtil(0, n - 1, qs, qe, 0);
    }

    int constructSTUtil(int arr[], int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        int mid = getMid(ss, se);
        st[si] = maxVal(constructSTUtil(arr, ss, mid, si * 2 + 1),
                constructSTUtil(arr, mid + 1, se, si * 2 + 2));
        return st[si];
    }

    void constructST(int arr[], int n) {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size];

        constructSTUtil(arr, 0, n - 1, 0);
    }
}
