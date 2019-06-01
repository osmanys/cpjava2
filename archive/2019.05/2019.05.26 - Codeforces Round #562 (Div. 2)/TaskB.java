package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.HashMap;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int a0, b0, a1, b1, m = in.readInt();
        if(m == 1) {
            a0 = in.readInt();
            b0 = in.readInt();
            out.printLine("YES");
            return;
        }

        boolean b00 = true, b01 = true;
        int p00, p01, p02;
        boolean b10 = true, b11 = true;
        int p10, p11, p12;
        boolean b20 = true, b21 = true;
        int p20, p21, p22;
        boolean b30 = true, b31 = true;
        int p30, p31, p32;

        a0 = in.readInt();
        b0 = in.readInt();

        a1 = in.readInt();
        b1 = in.readInt();

        p00 = a0;
        p01 = a1;
        p02 = a1;

        p10 = a0;
        p11 = b1;
        p12 = b1;

        p20 = b0;
        p21 = a1;
        p22 = a1;

        p30 = b0;
        p31 = b1;
        p32 = b1;

        for (int i = 2; i < m; i++) {
            a0 = in.readInt();
            b0 = in.readInt();
            if ((b00 || b01) && ((p00 != a0 && p00 != b0 && p01 != a0 && p01 != b0) || (p00 != a0 && p00 != b0 && p02 != a0 && p02 != b0))) {
                if (p00 == p01) {
                    p01 = a0;
                    p02 = b0;
                } else {
                    if (b00 && p00 != a0 && p00 != b0 && p01 != a0 && p01 != b0) {
                        b00 = false;
                    }
                    if (b01 && p00 != a0 && p00 != b0 && p02 != a0 && p02 != b0) {
                        b01 = false;
                    }
                }
            }
            if ((b10 || b11) && ((p10 != a0 && p10 != b0 && p11 != a0 && p11 != b0) || (p10 != a0 && p10 != b0 && p12 != a0 && p12 != b0))) {
                if (p10 == p11) {
                    p11 = a0;
                    p12 = b0;
                } else {
                    if (b10 && p10 != a0 && p10 != b0 && p11 != a0 && p11 != b0) {
                        b10 = false;
                    }
                    if (b11 && p10 != a0 && p10 != b0 && p12 != a0 && p12 != b0) {
                        b11 = false;
                    }
                }
            }
            if ((b20 || b21) && ((p20 != a0 && p20 != b0 && p21 != a0 && p21 != b0) || (p20 != a0 && p20 != b0 && p22 != a0 && p22 != b0))) {
                if (p20 == p21) {
                    p21 = a0;
                    p22 = b0;
                } else {
                    if (b20 && p20 != a0 && p20 != b0 && p21 != a0 && p21 != b0) {
                        b20 = false;
                    }
                    if (b21 && p20 != a0 && p20 != b0 && p22 != a0 && p22 != b0) {
                        b21 = false;
                    }
                }
            }
            if ((b30 || b31) && ((p30 != a0 && p30 != b0 && p31 != a0 && p31 != b0) || (p30 != a0 && p30 != b0 && p32 != a0 && p32 != b0))) {
                if (p30 == p31) {
                    p31 = a0;
                    p32 = b0;
                } else {
                    if (b30 && p30 != a0 && p30 != b0 && p31 != a0 && p31 != b0) {
                        b30 = false;
                    }
                    if (b31 && p30 != a0 && p30 != b0 && p32 != a0 && p32 != b0) {
                        b31 = false;
                    }
                }
            }
        }

        if (b00 || b01 || b10 || b11 || b20 || b21 || b30 || b31)
            out.printLine("YES");
        else
            out.printLine("NO");
    }
}
