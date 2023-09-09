package Collection;

public class MyLinkedList<T> implements MyList<T>, Queue<T>{

    private Node<T> head; // Головной элемент списка
    private Node<T> tail; // Последний элемент списка
    private int size;

    // Вложенный класс для узла списка
    private static class Node<T> {
        T data;
        Node<T> next;   // Ссылка на следующий узел

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Конструктор списка
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T object) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(object)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void add(T object) {
        Node<T> newNode = new Node(object);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T object) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс находится вне допустимых границ");
        }

        Node<T> newNode = new Node<>(object);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node<T> previousNode = (Node<T>) get(index - 1);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }

        size++;
    }

    @Override
    public void remove(T object) {
        if (isEmpty()) {  // Список пустой, ничего не делаем
            return;
        }

        if (head.data.equals(object)) {
            head = head.next;
            if (head == null) { // Если голова стала null, значит список стал пустым, обновляем tail
                tail = null;
            }
            size--;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.data.equals(object)) {
                currentNode.next = currentNode.next.next;
                if (currentNode.next == null) {
                    tail = currentNode;
                }
                size--;
                return;
            }
            currentNode = currentNode.next;
        }
    }


    @Override
    public void clear() {
        head = null; // Обнуляем голову списка
        tail = null; // Обнуляем хвост списка
        size = 0;
    }


    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс находится вне допустимых границ");
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }


    @Override
    public int indexOf(T object) {
        Node<T> currentNode = head;
        int index = 0;

        while (currentNode != null) {
            if (currentNode.data.equals(object)) {
                return index;
            }

            currentNode = currentNode.next;
            index++;
        }

        return -1; // Элемент не найден
    }


    @Override
    public int lastIndexOf(T object) {
        Node<T> currentNode = tail;
        int index = size - 1;

        while (currentNode != null) {
            if (currentNode.data.equals(object)) {
                return index;
            }

            currentNode = currentNode.next;
            index--;
        }

        return -1; // Элемент не найден
    }


    @Override
    public void offer(T object) {
        Node<T> newNode = new Node<>(object);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }


    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }

        T removedElement = head.data;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return removedElement;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return head.data;
    }

}
