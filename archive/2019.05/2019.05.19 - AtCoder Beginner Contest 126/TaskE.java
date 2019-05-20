package net.oz;

import net.oz.graph.Edge;
import net.oz.graph.Graph;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskE {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        Graph g = new Graph(n);
        int m = in.readInt();
        int u, v;
        for(int i = 0; i < m; i++){
            u = in.readInt();
            v = in.readInt();
            in.readInt();
            g.addSimpleEdge(u - 1, v - 1);
            g.addSimpleEdge(v - 1, u - 1);
        }
        visited = new boolean[n];
        int r = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                r++;
                go(g, i);
            }
        }
        out.printLine(r);
    }
    private boolean[] visited;
    private void go(Graph g, int v){
        visited[v] = true;
        int next;
        Edge edge;
        for(int e = g.firstOutbound(v); e != -1; e = g.nextOutbound(e)){
            edge = g.edge(e);
            next = edge.getDestination();
            if(!visited[next])
                go(g, next);
        }
    }
}
