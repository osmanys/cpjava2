package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int d[] = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = in.readInt();
        }
        StringBuilder sb = new StringBuilder();
        int l = 0, r = n - 1;
        int last = 0;
        while (l <= r) {
            if (last < d[l] && last < d[r]) {
                if (d[l] < d[r]) {
                    sb.append("L");
                    last = d[l];
                    l++;
                } else if (d[l] > d[r]) {
                    sb.append("R");
                    last = d[r];
                    r--;
                } else {
                    int cl = 0, cr = 0, clast = 0;
                    StringBuilder sbl = new StringBuilder();
                    for (int i = l; i <= r; i++) {
                        if (clast < d[i]) {
                            cl++;
                            clast = d[i];
                            sbl.append("L");
                        } else
                            break;
                    }
                    clast = 0;
                    StringBuilder sbr = new StringBuilder();
                    for (int i = r; i >= l; i--) {
                        if (clast < d[i]) {
                            cr++;
                            clast = d[i];
                            sbr.append("R");
                        } else
                            break;
                    }
                    if (cl >= cr) {
                        sb.append(sbl);
                        l = r + 1;
                    }
                    else {
                        sb.append(sbr);
                        r = l - 1;
                    }
                }
            } else if (last < d[l]) {
                sb.append("L");
                last = d[l];
                l++;
            } else if (last < d[r]) {
                sb.append("R");
                last = d[r];
                r--;
            } else
                break;
        }
        out.printLine(sb.length());
        out.printLine(sb.toString());
    }
}
