package net.oz;

import net.oz.graph.Graph;
import net.oz.misc.*;
import net.oz.io.InputReader;
import net.oz.io.OutputWriter;
import java.util.*;

public class Pylons {
    private int[] path;
    private boolean[] visited;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int r = in.readInt();
        int c = in.readInt();
        int idx, tmp, order[] = ArrayUtils.createOrder(r * c);
        Random rand = new Random(360);
        for(int i = 0; i < r * c; i++){
            idx = rand.nextInt(i + 1);
            tmp = order[idx];
            order[idx] = order[i];
            order[i] = tmp;
        }
        Graph g = new Graph(r * c);
        for(int i = 0; i < r * c; i++){
            for(int j = 0; j < r * c; j++){
                if(i / c != order[j] / c && i % c != order[j] % c && i / c + i % c != order[j] / c + order[j] % c && i / c - i % c != order[j] / c - order[j] % c)
                    g.addSimpleEdge(i, order[j]);
            }
        }
        visited = new boolean[r * c];
        path = new int[r * c];
        if(go(g, 0, c + 1)){
            out.printLine("Case #" + testNumber + ": POSSIBLE");
            for(int cell : path){
                out.printLine((cell / c + 1) + " " + (cell % c + 1));
            }
        }
        else{
            out.printLine("Case #" + testNumber + ": IMPOSSIBLE");
        }
    }
    private boolean go(Graph g, int idx, int v){
        path[idx] = v;
        if(idx == g.vertexCount() - 1){
            return true;
        }
        else{
            visited[v] = true;
            int next;
            for(int e = g.firstOutbound(v); e != -1; e = g.nextOutbound(e)){
                next = g.destination(e);
                if(!visited[next]){
                    if(go(g, idx + 1, next)){
                        return true;
                    }
                }
            }
            visited[v] = false;
            return false;
        }
    }
}
