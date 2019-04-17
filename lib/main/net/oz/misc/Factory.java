package net.oz.misc;

/**
 * @author Egor Kulikov (kulikov@devexperts.com)
 */
public interface Factory<V> {
    public V create();
}
