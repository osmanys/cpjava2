package on2019_05.on2019_05_26_Codeforces_Round__562__Div__2_.C___Increasing_by_Modulo;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int m = in.readInt();
        int a[] = in.readIntArray(n);
        int s = 0;
        int mid, e = m - 1;
        while(s < e){
            mid = (s + e) / 2;
            if(check(n, m, a, mid))
                e = mid;
            else
                s = mid + 1;
        }
        out.printLine(s);
    }

    private boolean check(int n, int m, int a[], int k) {
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (cur - k > a[i])
                return false;
            if(cur < a[i] && (a[i] + k < m || a[i] + k - m < cur))
                cur = a[i];
        }
        return true;
    }
}
