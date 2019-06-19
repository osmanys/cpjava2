package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int d[] = in.readIntArray(n);
        int cnt4 = 0, cnt8 = 0, cnt15 = 0, cnt16 = 0, cnt23 = 0, cnt42 = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] == 4) {
                cnt4++;
            } else if (d[i] == 8) {
                if (cnt4 > 0) {
                    cnt8++;
                    cnt4--;
                }
            } else if (d[i] == 15) {
                if (cnt8 > 0) {
                    cnt15++;
                    cnt8--;
                }
            } else if (d[i] == 16) {
                if (cnt15 > 0) {
                    cnt16++;
                    cnt15--;
                }
            } else if (d[i] == 23) {
                if (cnt16 > 0) {
                    cnt23++;
                    cnt16--;
                }
            } else if (d[i] == 42) {
                if (cnt23 > 0) {
                    cnt42++;
                    cnt23--;
                }
            }
        }
        out.printLine(n - 6 * cnt42);
    }
}
