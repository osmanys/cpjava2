package on2019_05.on2019_05_19_AtCoder_Beginner_Contest_126.D___Even_Relation;



import net.oz.graph.Edge;
import net.oz.graph.Graph;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

public class TaskD {
    private int[] r;
    private boolean[] visited;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        Graph g = new Graph(n);
        int u, v, w;
        for(int i = 0; i < n - 1; i++){
            u = in.readInt();
            v = in.readInt();
            w = in.readInt();
            g.addWeightedEdge(u - 1, v - 1, w);
            g.addWeightedEdge(v - 1, u - 1, w);
        }
        r = new int[n];
        visited = new boolean[n];
        go(g, 0, 0);
        for(int i = 0; i < n; i++)
            out.printLine(r[i]);
    }
    private void go(Graph g, int v, int c){
        visited[v] = true;
        r[v] = c;
        int next;
        Edge edge;
        for(int e = g.firstOutbound(v); e != -1; e = g.nextOutbound(e)){
            edge = g.edge(e);
            next = edge.getDestination();
            if(!visited[next])
                go(g, next, (edge.getWeight() & 1) == 0 ? c : (c + 1) & 1);
        }
    }
}
