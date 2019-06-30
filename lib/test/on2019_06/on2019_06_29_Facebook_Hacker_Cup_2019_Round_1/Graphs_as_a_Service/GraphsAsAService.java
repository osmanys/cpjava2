package on2019_06.on2019_06_29_Facebook_Hacker_Cup_2019_Round_1.Graphs_as_a_Service;



import net.oz.collections.Pair;
import net.oz.graph.Graph;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import static net.oz.graph.ShortestDistance.dijkstraAlgorithm;

public class GraphsAsAService {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        out.print("Case #" + testNumber + ": ");
        int n = in.readInt();
        int x, y, z, m = in.readInt();
        Graph g = new Graph(n);
        int[][] mp = new int[n][n];
        for (int i = 0; i < m; i++) {
            x = in.readInt() - 1;
            y = in.readInt() - 1;
            z = in.readInt();
            g.addWeightedEdge(x, y, z);
            g.addWeightedEdge(y, x, z);
            mp[x][y] = z;
            mp[y][x] = z;
        }
        Pair<long[], int[]> p;
        boolean valid = true;
        for (int i = 0; valid && i < n; i++) {
            p = dijkstraAlgorithm(g, i);
            for (int j = i + 1; j < n; j++) {
                if (p.first[j] < mp[i][j]) {
                    valid = false;
                    break;
                }
            }
        }
        if (!valid)
            out.printLine("Impossible");
        else {
            out.printLine(g.edgeCount() / 2);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (mp[i][j] > 0)
                        out.printLine(i + 1, j + 1, mp[i][j]);
                }
            }
        }
    }
}
