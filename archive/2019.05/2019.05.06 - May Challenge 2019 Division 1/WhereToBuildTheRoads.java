package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import static net.oz.misc.ArrayUtils.sort;

public class WhereToBuildTheRoads {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int points[][] = in.readIntTable(n, 2);
        int zeros[] = new int[n];
        int rzeros[] = new int[n];
        for(int i = 0; i < n; i++){
            zeros[i] = points[i][0] - points[i][1];
            rzeros[i] = points[i][0] + points[i][1];
        }
        sort(zeros);
        sort(rzeros);
        int min = Integer.MAX_VALUE;
        int rmin = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            if(min > zeros[i] - zeros[i - 1])
                min = zeros[i] - zeros[i - 1];
            if(rmin > rzeros[i] - rzeros[i - 1])
                rmin = rzeros[i] - rzeros[i - 1];
        }
        out.printLine(Math.min(min, rmin) / 2.0);
    }
}
