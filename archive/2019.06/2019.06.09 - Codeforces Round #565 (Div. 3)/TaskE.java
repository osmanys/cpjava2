package net.oz;

import net.oz.graph.Edge;
import net.oz.graph.Graph;
import net.oz.graph.HopcroftKarp;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskE {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int u, v, m = in.readInt();
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            u = in.readInt() - 1;
            v = in.readInt() - 1;
            g.addSimpleEdge(u, v);
            g.addSimpleEdge(v, u);
        }
        boolean selected[] = new boolean[n];
        boolean visited[] = new boolean[n];
        int r = go(g, 0, visited, selected);
        if(r <= n / 2) {
            out.printLine(r);
            for (int i = 0; i < n; i++) {
                if (selected[i])
                    out.print((i + 1) + " ");
            }
        } else {
            out.printLine(n - r);
            for (int i = 0; i < n; i++) {
                if (!selected[i])
                    out.print((i + 1) + " ");
            }
        }
        out.printLine();
    }

    private int go(Graph g, int v, boolean visited[], boolean selected[]) {
        visited[v] = true;
        int next;
        Edge edge;
        boolean found = false;
        for (int e = g.firstOutbound(v); e != -1; e = g.nextOutbound(e)) {
            edge = g.edge(e);
            next = edge.getDestination();
            if (selected[next]) {
                found = true;
                break;
            }
        }
        int r = 0;
        if (!found) {
            selected[v] = true;
            r++;
        }
        for (int e = g.firstOutbound(v); e != -1; e = g.nextOutbound(e)) {
            edge = g.edge(e);
            next = edge.getDestination();
            if (!visited[next])
                r += go(g, next, visited, selected);
        }
        return r;
    }
}
