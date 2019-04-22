package net.oz;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;
import net.oz.string.*;

public class AlienRhyme {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        Trie t = new Trie();
        for(int i = 0; i < n; i++){
            t.add(StringUtils.reverse(in.readString()));
        }
        int r = n;
        for(Trie.Node ch : t.root.links){
            r -= go(ch);
        }
        out.printLine("Case #" + testNumber + ": " + r);
    }

    int go(Trie.Node node) {
        if (node == null)
            return 0;
        int r = 0;
        if (node.leaf)
            r++;
        for (Trie.Node ch : node.links) {
            r += go(ch);
        }
        if (r >= 2)
            r -= 2;
        return r;
    }
}
