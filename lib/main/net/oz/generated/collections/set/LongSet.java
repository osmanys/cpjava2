package net.oz.generated.collections.set;

import net.oz.generated.collections.LongCollection;

public interface LongSet extends LongCollection {
    @Override
    default public int count(long value) {
        return contains(value) ? 1 : 0;
    }
}
