package net.oz.generated.collections.queue;

import net.oz.generated.collections.IntCollection;

public interface IntQueue extends IntCollection {
    default public int first() {
        return peek();
    }

    public int peek();

    public int poll();
}
