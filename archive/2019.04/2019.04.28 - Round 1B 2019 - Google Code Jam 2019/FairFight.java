package net.oz;

import net.oz.collections.intervaltree.IntervalTree;
import net.oz.collections.intervaltree.LongIntervalTree;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class FairFight {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int k = in.readInt();
        int c[] = new int[n];
        SegmentTreeRMQ cst = new SegmentTreeRMQ(n);
        for(int i = 0; i < n; i++){
            c[i] = in.readInt();
            cst.update(i, i, c[i]);
        }
        SegmentTreeRMQ dst = new SegmentTreeRMQ(n);
        int d[] = new int[n];
        for(int i = 0; i < n; i++){
            d[i] = in.readInt();
            dst.update(i, i, d[i]);
        }
        long res = 0;
        for(int l = 0; l < n; l++){
            for(int r = l; r < n; r++){
                if(Math.abs(cst.query(l, r) - dst.query(l, r)) <= k)
                    res++;
            }
        }
        out.printLine("Case #" + testNumber + ": " + res);
    }
}
class SegmentTreeRMQ extends LongIntervalTree {

    protected SegmentTreeRMQ(int size) {
        super(size);
    }

    @Override
    protected long joinValue(long left, long right) {
        return Math.max(left, right);
    }

    @Override
    protected long joinDelta(long was, long delta) {
        return Math.max(was, delta);
    }

    @Override
    protected long accumulate(long value, long delta, int length) {
        return Math.max(value, delta);
    }

    @Override
    protected long neutralValue() {
        return -1;
    }

    @Override
    protected long neutralDelta() {
        return -1;
    }
}
