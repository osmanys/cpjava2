package net.oz.misc;

/**
 * @author Egor Kulikov (kulikov@devexperts.com)
 */
public interface PowerOperation<V> extends Operation<V> {
    public V power(V base, int exponent);
}
