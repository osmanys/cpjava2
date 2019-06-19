package net.oz;

import net.oz.collections.Pair;
import net.oz.graph.Edge;
import net.oz.graph.Graph;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import static net.oz.graph.ShortestDistance.dijkstraAlgorithm;

public class TreesAsAService {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        out.print("Case #" + testNumber + ": ");
        int n = in.readInt();
        int m = in.readInt();
        int[] x = new int[m];
        int[] y = new int[m];
        int[] z = new int[m];
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            x[i] = in.readInt();
            y[i] = in.readInt();
            z[i] = in.readInt();
            if (x[i] != z[i])
                g.addSimpleEdge(x[i], z[i]);
            if (y[i] != z[i])
                g.addSimpleEdge(y[i], z[i]);
        }
        boolean[][] parents = new boolean[n][n];
        Pair<long[], int[]> p;
        for (int i = 0; i < n; i++) {
            p = dijkstraAlgorithm(g, i);
            for (int j = 0; j < n; j++) {
                if (p.second[j] != -1)
                    parents[i][j] = true;
            }
        }
        boolean[] visited = new boolean[n];
        boolean[][] brothers = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                go0(g, i, visited, brothers);
        }
        //validate
        int k = 0;
        for(; k < m; k++){
            //if(x[k] )
        }
        if(k < m)
            out.printLine("Impossible");
        else{
            //build
        }
    }

    private void go0(Graph g, int v, boolean[] visited, boolean[][] brothers) {
        visited[v] = true;
        int next, nextf;
        Edge edge, edgef;
        for (int e = g.firstOutbound(v); e != -1; e = g.nextOutbound(e)) {
            edge = g.edge(e);
            next = edge.getDestination();
            for (int f = g.nextOutbound(e); f != -1; f = g.nextOutbound(f)) {
                edgef = g.edge(f);
                nextf = edgef.getDestination();
                brothers[next][nextf] = true;
                brothers[nextf][next] = true;
            }
            if (!visited[next]) {
                go0(g, next, visited, brothers);
            }
        }
    }
}
