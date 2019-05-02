package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class ManhattanCrepeCart {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int p = in.readInt();
        int x, y, q = in.readInt();
        char d;
        int[] arrx = new int[q + 2];
        int[] arry = new int[q + 2];
        for(int i = 0; i < p; i++){
            x = in.readInt();
            y = in.readInt();
            d = in.readCharacter();
            if(d == 'N'){
                arrx[0] += 1;
                arrx[q + 1] -= 1;

                arry[y + 1] += 1;
                arry[q + 1] -= 1;
            }
            else if(d == 'S'){
                arrx[0] += 1;
                arrx[q + 1] -= 1;

                arry[0] += 1;
                arry[y] -= 1;
            }
            else if(d == 'E'){
                arrx[x + 1] += 1;
                arrx[q + 1] -= 1;

                arry[0] += 1;
                arry[q + 1] -= 1;
            }
            else if(d == 'W'){
                arrx[0] += 1;
                arrx[x] -= 1;

                arry[0] += 1;
                arry[q + 1] -= 1;
            }
        }
        int sumx = arrx[0];
        int indx = 0;
        for(int i = 1; i <= q; i++){
            arrx[i] += arrx[i - 1];
            if (sumx < arrx[i]) {
                sumx = arrx[i];
                indx = i;
            }
        }
        int sumy = arry[0];
        int indy = 0;
        for(int i = 1; i <= q; i++){
            arry[i] += arry[i - 1];
            if (sumy < arry[i]) {
                sumy = arry[i];
                indy = i;
            }
        }
        out.printLine("Case #" + testNumber + ": " + indx + " " + indy);
    }
}
