package on2019_06.on2019_06_07_JUNE_Challenge_2019_Division_1.Intersecting_Paths;



import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;
import net.oz.collections.Pair;
import net.oz.generated.collections.list.IntList;
import net.oz.graph.Edge;
import net.oz.graph.Graph;
import net.oz.io.OutputWriter;

import java.io.StringWriter;
import java.util.*;

import static net.oz.graph.ShortestDistance.dijkstraAlgorithm;

public class IntersectingPathsTestCase {
    @TestCase
    public Collection<Test> createTests() {
        List<Test> tests = new ArrayList<>();
        int cases = 1;

        Random rand = new Random();
        int u, v, n, q;
        Graph g;
        StringBuilder res;

        for (int testNumber = 0; testNumber < cases; testNumber++) {
            StringWriter sw = new StringWriter();
            OutputWriter out = new OutputWriter(sw);
            out.printLine(1);
            n = 300000;//Math.abs(rand.nextInt());
            q = 300000;//Math.abs(rand.nextInt());
            out.printLine(n, q);
            g = new Graph(n);
            /*for (int i = 1; i < n; i++) {
                u = i - 1;
                g.addSimpleEdge(u, i);
                g.addSimpleEdge(i, u);
                out.printLine(u + 1, i + 1);
            }*/
            for (int i = 1; i < n; i++) {
                u = rand.nextInt(i);
                g.addSimpleEdge(u, i);
                g.addSimpleEdge(i, u);
                out.printLine(u + 1, i + 1);
            }
            res = new StringBuilder();
            for (int i = 0; i < q; i++) {
                u = rand.nextInt(n);
                v = rand.nextInt(n);
                out.printLine(u + 1, v + 1);
                //res.append(calc(g, u, v) + "\n");
            }
            //tests.add(new Test(sw.toString(), res.toString()));
            tests.add(new Test(sw.toString()));
        }
        return tests;
    }

    private long calc(Graph g, int u, int v) {
        boolean[] isPath = new boolean[g.vertexCount()];
        Pair<Long, IntList> p = dijkstraAlgorithm(g, u, v);
        isPath[u] = true;
        isPath[v] = true;
        Edge edge;
        for (int i = 0; i < p.second.size(); i++) {
            edge = g.edge(p.second.get(i));
            isPath[edge.getDestination()] = true;
        }
        long res = 0;
        boolean found;
        int k;
        for (int i = 0; i < g.vertexCount(); i++) {
            if (isPath[i])
                res++;
            for (int j = i + 1; j < g.vertexCount(); j++) {
                found = false;
                p = dijkstraAlgorithm(g, i, j);
                for (k = 0; k < p.second.size(); k++) {
                    edge = g.edge(p.second.get(k));
                    if (isPath[edge.getDestination()]) {
                        found = !found;
                        if (!found)
                            break;
                    }
                }
                if (k == p.second.size() && p.second.size() > 0 && isPath[g.edge(p.second.get(0)).getSource()])
                    found = !found;

                if (found)
                    res++;
            }
        }
        return res;
    }
}
