package interpreter;

public interface Memory<K, V> {
    void save(K key, V value);
    V read(K key);
    boolean has(K key);
}
