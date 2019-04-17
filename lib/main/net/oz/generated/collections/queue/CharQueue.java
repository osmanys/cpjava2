package net.oz.generated.collections.queue;

import net.oz.generated.collections.CharCollection;

public interface CharQueue extends CharCollection {
    default public char first() {
        return peek();
    }

    public char peek();

    public char poll();
}
