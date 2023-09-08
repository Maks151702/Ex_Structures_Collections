package Collection;

public interface Queue<T> {


    void offer(T object);

    T poll();

    T peek();
}
