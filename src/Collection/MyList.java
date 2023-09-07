package Collection;

public interface MyList {
    int size();

    boolean isEmpty();

    boolean contains(Integer object);

    void add(Integer object);

    void add(int index, Integer object);

    void remove(Integer object);

    void clear();

    Integer get(int index);
    int indexOf(Integer object);

    int lastIndexOf(Integer object);
}
