package net.oz.generated.collections.set;

import net.oz.generated.collections.CharCollection;

public interface CharSet extends CharCollection {
    @Override
    default public int count(char value) {
        return contains(value) ? 1 : 0;
    }
}
