package on2019_05.on2019_05_01_Educational_Codeforces_Round_64__Rated_for_Div__2_.A___Inscribed_Figures;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int r = 0, d, last0 = -1, last = in.readInt();
        boolean isInfinite = false;
        for(int i = 1; i < n; i++){
            d = in.readInt();
            if(isInfinite)
                continue;
            if(last == 1){
                if(d == 2){
                    r += 3;
                    if(last0 == 3)
                        r--;
                }
                else{
                    r += 4;
                }
            }
            else if(last == 2){
                if(d == 1){
                    r += 3;
                }
                else{
                    isInfinite = true;
                }
            }
            else{
                if(d == 1){
                    r += 4;
                }
                else{
                    isInfinite = true;
                }
            }
            last0 = last;
            last = d;
        }
        if(isInfinite)
            out.printLine("Infinite");
        else{
            out.printLine("Finite");
            out.printLine(r);
        }
    }
}
