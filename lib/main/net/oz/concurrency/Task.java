package net.oz.concurrency;

import net.oz.io.InputReader;
import net.oz.io.OutputWriter;

/**
 * @author egor@egork.net
 */
public interface Task {
    public void read(InputReader in);

    public void solve();

    public void write(OutputWriter out, int testNumber);
}
