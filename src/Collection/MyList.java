package Collection;

public interface MyList<T>{
    int size();

    boolean isEmpty();

    boolean contains(T object);

    void add(T object);

    void add(int index, T object);

    void remove(T object);

    void clear();

    T get(int index);
    int indexOf(T object);

    int lastIndexOf(T object);
}
