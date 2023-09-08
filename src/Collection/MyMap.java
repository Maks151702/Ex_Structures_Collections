package Collection;

public interface MyMap<T> {

    int size();

    boolean isEmpty();

    void put(String key, T value);

    boolean remove(String key);

    void clear();

    T get(String key);

    String[] keyArray();

    T[] valueArray();
}
