package Collection;

public class MyHashMap implements MyMap{
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void put(String key, Integer value) {

    }

    @Override
    public boolean remove(String key) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Integer get(String key) {
        return null;
    }

    @Override
    public String[] keyArray() {
        return new String[0];
    }

    @Override
    public Integer[] valueArray() {
        return new Integer[0];
    }
}
