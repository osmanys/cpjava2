package on2019_05.on2019_05_15_Educational_Codeforces_Round_65__Rated_for_Div__2_.C___News_Distribution;



import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int x, y, m = in.readInt();
        subset subsets[] = new subset[n];
        for(int i = 0; i < n; i++) {
            subsets[i] = new subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        int k, group[];
        for(int i = 0; i < m; i++){
            k = in.readInt();
            if(k > 0) {
                group = in.readIntArray(k);
                for (int j = 1; j < k; j++) {
                    x = find(subsets, group[0] - 1);
                    y = find(subsets, group[j] - 1);
                    if (x != y)
                        union(subsets, x, y);
                }
            }
        }
        int cnt[] = new int[n];
        for(int i = 0; i < n; i++) {
            cnt[find(subsets, i)]++;
        }
        int res[] = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = cnt[find(subsets, i)];
        }
        out.printLine(res);
    }

    class subset {
        int parent;
        int rank;
    }

    int find(subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[yroot].rank < subsets[xroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        }
    }
}
