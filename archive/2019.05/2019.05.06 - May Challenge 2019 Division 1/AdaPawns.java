package net.oz;

import net.oz.graph.HopcroftKarp;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.*;

public class AdaPawns {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        boolean d[][] = new boolean[n][n];
        String s;
        int res[][] = new int[n][n];
        int total = 0;
        HopcroftKarp hc = new HopcroftKarp();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        int _x, _y;
        for (int r = 0; r < n; r++) {
            s = in.readString();
            for (int c = 0; c < n; c++) {
                d[r][c] = s.charAt(c) == 'O';
                if (d[r][c]) {
                    if (isParent(d, r, c)) {
                        res[r][c] = 1;
                    } else if (hasLeftUp(d, r, c, res) && res[r - 1][c - 1] == 1) {
                        res[r][c] = 2;
                        total++;
                    } else if (hasRightUp(d, r, c, res) && res[r - 1][c + 1] == 1) {
                        res[r][c] = 3;
                        total++;
                    }
                    if (res[r][c] == 0) {
                        if (hasLeftUp(d, r, c, res)) {
                            if (r % 2 == 0) {
                                _x = r * n + c;
                                _y = (r - 1) * n + c - 1;
                            } else {
                                _x = (r - 1) * n + c - 1;
                                _y = r * n + c;
                            }
                            x.add(_x);
                            y.add(_y);
                        }
                        if (hasRightUp(d, r, c, res)) {
                            if (r % 2 == 0) {
                                _x = r * n + c;
                                _y = (r - 1) * n + c + 1;
                            } else {
                                _x = (r - 1) * n + c + 1;
                                _y = r * n + c;
                            }
                            x.add(_x);
                            y.add(_y);
                        }
                    }
                }
            }
        }
        hc.makeGraph(x, y, n * n + 1, n * n + 1);
        List<Integer> vertexCover = hc.vertexCover();
        for(Integer v : vertexCover) {
            _x = v / n;
            _y = v % n;
            if (hasLeftUp(d, _x, _y)) {
                res[_x][_y] = 2;
                total++;
            } else if (hasRightUp(d, _x, _y)) {
                res[_x][_y] = 3;
                total++;
            }
        }
        out.printLine(total);
        for (int r = n - 1; r >= 0; r--) {
            for (int c = 0; c < n; c++) {
                if (res[r][c] == 2) {
                    out.printLine(r + 1, c + 1, 'L');
                    assert d[r - 1][c - 1];
                } else if (res[r][c] == 3) {
                    out.printLine(r + 1, c + 1, 'R');
                    assert d[r - 1][c + 1];
                }
            }
        }
    }

    private boolean isParent(boolean d[][], int r, int c) {
        return r == 0 || ((c == 0 || !d[r - 1][c - 1]) && (c == d.length - 1 || !d[r - 1][c + 1]));
    }

    private boolean hasLeftUp(boolean d[][], int r, int c) {
        return r > 0 && c > 0 && d[r - 1][c - 1];
    }

    private boolean hasLeftUp(boolean d[][], int r, int c, int res[][]) {
        return r > 0 && c > 0 && d[r - 1][c - 1] && res[r - 1][c - 1] < 2;
    }

    private boolean hasRightUp(boolean d[][], int r, int c) {
        return r > 0 && c < d.length - 1 && d[r - 1][c + 1];
    }

    private boolean hasRightUp(boolean d[][], int r, int c, int res[][]) {
        return r > 0 && c < d.length - 1 && d[r - 1][c + 1] && res[r - 1][c + 1] < 2;
    }
}
