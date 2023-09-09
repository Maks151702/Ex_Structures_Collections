package Collection;

public class MyHashMap<T> implements MyMap<T> {
    private static final int INITIAL_CAPACITY = 16;
    private Entry<T>[] table;
    private int size;

    public MyHashMap() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(String key, T value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не введён");
        }

        int hash = key.hashCode();
        int index = hash % table.length;

        Entry<T> entry = new Entry<>(key, value, hash, null);

        if (table[index] == null) {
            table[index] = entry;
        } else {
            Entry<T> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = entry;
            }
        }

        size++;
    }

    @Override
    public boolean remove(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не введён");
        }

        int hash = key.hashCode();
        int index = hash % table.length;

        Entry<T> current = table[index];
        Entry<T> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    table[index] = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не введён");
        }

        int hash = key.hashCode();
        int index = hash % table.length;

        Entry<T> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public String[] keyArray() {
        String[] keys = new String[size];
        int currentIndex = 0;

        for (int i = 0; i < table.length; i++) {
            Entry<T> current = table[i];
            while (current != null) {
                keys[currentIndex] = current.key;
                currentIndex++;
                current = current.next;
            }
        }

        return keys;
    }

    @Override
    public T[] valueArray() {
        T[] values = (T[]) new Object[size];
        int currentIndex = 0;

        for (int i = 0; i < table.length; i++) {
            Entry<T> current = table[i];
            while (current != null) {
                values[currentIndex] = current.value;
                currentIndex++;
                current = current.next;
            }
        }

        return values;
    }

    private static class Entry<T> {
        String key;
        T value;
        int hash;
        Entry<T> next;

        Entry(String key, T value, int hash, Entry<T> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }
}

