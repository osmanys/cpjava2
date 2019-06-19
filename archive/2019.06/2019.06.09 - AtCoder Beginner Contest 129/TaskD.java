package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int h = in.readInt();
        int w = in.readInt();
        boolean t[][] = new boolean[h][w];
        String line;
        for (int i = 0; i < h; i++) {
            line = in.readString();
            for (int j = 0; j < w; j++) {
                if (line.charAt(j) == '#')
                    t[i][j] = true;
            }
        }
        int last;
        int up[][] = new int[h][w];
        for (int j = 0; j < w; j++) {
            last = -1;
            for (int i = 0; i < h; i++) {
                if (t[i][j]) {
                    last = i;
                }
                up[i][j] = last;
            }
        }
        int down[][] = new int[h][w];
        for (int j = 0; j < w; j++) {
            last = h;
            for (int i = h - 1; i >= 0; i--) {
                if (t[i][j]) {
                    last = i;
                }
                down[i][j] = last;
            }
        }
        int left[][] = new int[h][w];
        for (int i = 0; i < h; i++) {
            last = -1;
            for (int j = 0; j < w; j++) {
                if (t[i][j]) {
                    last = j;
                }
                left[i][j] = last;
            }
        }
        int right[][] = new int[h][w];
        for (int i = 0; i < h; i++) {
            last = w;
            for (int j = w - 1; j >= 0; j--) {
                if (t[i][j]) {
                    last = j;
                }
                right[i][j] = last;
            }
        }
        int c, max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                c = (down[i][j] - up[i][j] - 1) + (right[i][j] - left[i][j] - 1) - 1;
                if(c < 0)
                    c = 0;
                if(max < c)
                    max = c;
            }
        }
        out.printLine(max);
    }
}
