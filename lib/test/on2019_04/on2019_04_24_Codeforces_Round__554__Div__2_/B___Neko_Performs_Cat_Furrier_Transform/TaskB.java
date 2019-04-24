package on2019_04.on2019_04_24_Codeforces_Round__554__Div__2_.B___Neko_Performs_Cat_Furrier_Transform;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.*;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int p = 1;
        int idx = 1;
        while(2 * p <= n){
            idx++;
            p *= 2;
        }
        int maxp = p;
        ArrayList<Integer> op = new ArrayList<>();
        int opc = 0;
        for(int i = idx; i > 0 ; i--){
            if((n / p) % 2 == 0) {
                op.add(i);
                n = n ^ (2 * p - 1);
                opc++;
                if(n == 2 * maxp - 1) {
                    break;
                }
                n++;
                opc++;
            }
            p /= 2;
        }
        out.printLine(opc);
        for(int _op : op){
            out.print(_op + " ");
        }
        out.printLine();
    }
}
