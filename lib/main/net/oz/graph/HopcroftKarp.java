package net.oz.graph;

import net.oz.collections.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static net.oz.collections.Pair.makePair;

/**
 * @author osmanys@gmail.com
 */
public class HopcroftKarp {
    private final int NIL = 0;
    private final int INF = Integer.MAX_VALUE;
    private ArrayList<Integer>[] adj;
    private int[] pair;
    private int[] dist;
    private int cx, cy;
    private boolean[] visited;

    private boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 1; v <= cx; ++v)
            if (pair[v] == NIL) {
                dist[v] = 0;
                queue.add(v);
            } else
                dist[v] = INF;
        dist[NIL] = INF;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (dist[v] < dist[NIL])
                for (int u : adj[v])
                    if (dist[pair[u]] == INF) {
                        dist[pair[u]] = dist[v] + 1;
                        queue.add(pair[u]);
                    }
        }
        return dist[NIL] != INF;
    }

    private boolean dfs(int v) {
        if (v != NIL) {
            for (int u : adj[v]) {
                if (dist[pair[u]] == dist[v] + 1)
                    if (dfs(pair[u])) {
                        pair[u] = v;
                        pair[v] = u;
                        return true;
                    }
            }
            dist[v] = INF;
            return false;
        }
        return true;
    }

    private int hopcroftKarp() {
        pair = new int[cx + cy + 1];
        dist = new int[cx + cy + 1];
        int matching = 0;
        while (bfs()) {
            for (int v = 1; v <= cx; ++v) {
                if (pair[v] == NIL)
                    if (dfs(v)) {
                        matching++;
                    }
            }
        }
        return matching;
    }

    public List<Pair<Integer, Integer>> maximunMatching() {
        hopcroftKarp();
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        for (int v = 1; v <= cx; ++v) {
            if (pair[v] != NIL) {
                res.add(makePair(v - 1, pair[v - 1] - cx - 1));
            }
        }
        return res;
    }

    public List<Integer> vertexCover() {
        hopcroftKarp();
        visited = new boolean[cx + cy + 1];
        for (int v = 1; v <= cx; ++v) {
            if(pair[v] == NIL && !visited[v])
                dfsVertexCover(v, true);
        }
        List<Integer> res = new ArrayList<>();
        for (int v = 1; v <= cx + cy; ++v) {
            if((v <= cx && !visited[v]) || (v > cx && visited[v]))
                res.add((v < cx ? v : v - cx) - 1);
        }
        return res;
    }

    private void dfsVertexCover(int v, boolean left) {
        visited[v] = true;
        for (int u : adj[v]) {
            if (!visited[u] && ((left && pair[v] != u) || (!left && pair[v] == u))) {
                dfsVertexCover(u, !left);
            }
        }
    }

    public void makeGraph(List<Integer> x, List<Integer> y, int cx, int cy) {
        this.cx = cx;
        this.cy = cy;
        adj = new ArrayList[cx + cy + 1];
        for (int i = 0; i < adj.length; ++i)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < x.size(); ++i)
            addEdge(x.get(i) + 1, y.get(i) + 1);
    }

    private void addEdge(int u, int v) {
        adj[u].add(cx + v);
        adj[cx + v].add(u);
    }
}
