package net.oz.generated.collections.set;

import net.oz.generated.collections.DoubleCollection;

public interface DoubleSet extends DoubleCollection {
    @Override
    default public int count(double value) {
        return contains(value) ? 1 : 0;
    }
}
