package on2019_06.on2019_06_07_JUNE_Challenge_2019_Division_1.Intersecting_Paths;



import net.oz.collections.intervaltree.LCA;
import net.oz.graph.Graph;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.util.Collections.binarySearch;
import static net.oz.misc.ArrayUtils.sort;

public class IntersectingPaths {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        Graph g = new Graph(n);
        int u, v, q = in.readInt();
        for (int i = 0; i < n - 1; i++) {
            u = in.readInt() - 1;
            v = in.readInt() - 1;
            g.addSimpleEdge(u, v);
            g.addSimpleEdge(v, u);
        }
        build(g);
        for (int i = 0; i < q; i++) {
            u = in.readInt() - 1;
            v = in.readInt() - 1;
            out.printLine(calc(n, u, v));
        }
    }

    private long calc(int n, int u, int v) {
        int lcp = lca.getLCA(u, v);
        int lv = lca.getLevel(lcp);
        int lpos, lcu, lcv;
        if (lcp == u)
            lcu = u;
        else {
            lpos = binarySearch(order[lv + 1], lca.getPosition(u));
            if (lpos < 0)
                lpos = -lpos - 2;
            lcu = position.get(order[lv + 1].get(lpos));
        }
        if (lcp == v)
            lcv = v;
        else {
            lpos = binarySearch(order[lv + 1], lca.getPosition(v));
            if (lpos < 0)
                lpos = -lpos - 2;
            lcv = position.get(order[lv + 1].get(lpos));
        }
        long r = ac[u] + ac[v] - 2 * ac[lcp] + value[lcp];
        if(lcp != u && lcp != v)
            r += (long) (childs[lcu] + 1) * (childs[lcv] + 1);
        r += (long) (n - childs[lcp] - 1) * (childs[lcp] - childs[lcu] - childs[lcv] - 1);
        if(lcp == u && lcp == v)
            r += (long) (n - childs[lcp] - 1) * (2 * childs[lcp] + 2);
        else if(lcp == u || lcp == v)
            r += (long) (n - childs[lcp] - 1) * (childs[lcp] + 1);
        return r;
    }

    private long[] value;
    private int[] childs;
    private long[] ac;
    private LCA lca;
    private ArrayList<Integer>[] order;
    private HashMap<Integer, Integer> position;

    private void build(Graph g) {
        lca = new LCA(g);
        position = new HashMap<>();
        int[] pos = new int[g.vertexCount()];
        int h = 0;
        for (int i = 0; i < g.vertexCount(); i++) {
            if(h < lca.getLevel(i))
                h = lca.getLevel(i);
            position.put(lca.getPosition(i), i);
            pos[i] = lca.getPosition(i);
        }
        order = new ArrayList[h + 1];
        for (int i = 0; i <= h; i++)
            order[i] = new ArrayList<>();
        sort(pos);
        for (int i = 0; i < g.vertexCount(); i++)
            order[lca.getLevel(position.get(pos[i]))].add(pos[i]);

        value = new long[g.vertexCount()];
        childs = new int[g.vertexCount()];
        Arrays.fill(value, 1);
        go0(h);
        ac = new long[g.vertexCount()];
        go1(h);
    }

    private void go0(int h) {
        long[] ord = lca.getOrder();
        int v, p;
        for (int i = h; i >= 0; i--) {
            for (int j = 0; j < order[i].size(); j++) {
                if (order[i].get(j) > 0) {
                    v = (int) ord[order[i].get(j)];
                    p = (int) ord[order[i].get(j) - 1];
                    value[p] += (long) (childs[p] + 1) * (childs[v] + 1);
                    childs[p] += childs[v] + 1;
                }
            }
        }
    }

    private void go1(int h) {
        long[] ord = lca.getOrder();
        int v, p;
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < order[i].size(); j++) {
                if (order[i].get(j) > 0) {
                    v = (int) ord[order[i].get(j)];
                    p = (int) ord[order[i].get(j) - 1];
                    ac[v] = ac[p] - (long) (childs[v] + 1) * (childs[p] - childs[v]) + value[v];
                }
            }
        }
    }
}
