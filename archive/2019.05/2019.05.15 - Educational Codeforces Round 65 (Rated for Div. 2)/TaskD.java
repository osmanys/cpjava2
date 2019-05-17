package net.oz;

import net.oz.generated.collections.queue.IntArrayQueue;
import net.oz.generated.collections.queue.IntQueue;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        String s = in.readString();
        StringBuilder sb = new StringBuilder();
        int q[] = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (idx == 0) {
                sb.append(0);
                q[idx++] = 0;
                continue;
            }
            if (s.charAt(i) == '(') {
                q[idx] = q[idx - 1] ^ 1;
                idx++;
                sb.append(q[idx - 1]);
            } else {
                sb.append(q[--idx]);
            }
        }
        out.printLine(sb);
    }
}
