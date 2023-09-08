package Collection;

public class MyLinkedList<T> implements MyList<T>, Queue<T>{

    private Node<T> head; // Головной элемент списка
    private Node<T> tail; // Последний элемент списка
    private int size;     // Размер списка

    // Вложенный класс для узла списка
    private static class Node<T> {
        T data;         // Значение узла
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
                return true; // Нашли элемент
            }
            current = current.next; // Переходим к следующему узлу
        }
        return false;
    }

    @Override
    public void add(T object) {
        // Создаем новый узел с заданным значением
        Node<T> newNode = new Node<T>((T) object);

        if (isEmpty()) {
            // Если список пустой, устанавливаем голову и хвост на новый узел
            head = newNode;
            tail = newNode;
        } else {
            // Иначе добавляем новый узел в конец списка и обновляем хвост
            tail.next = newNode;
            tail = newNode;
        }
        size++; // Увеличиваем размер списка
    }

    @Override
    public void add(int index, T object) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс находится вне допустимых границ");
        }

        Node<T> newNode = new Node<>(object);

        if (isEmpty()) {
            // Если список пустой, устанавливаем новый узел как head и tail
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            // Вставляем в начало списка
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            // Вставляем в конец списка
            tail.next = newNode;
            tail = newNode;
        } else {
            // Вставляем в середину списка
            Node<T> previousNode = (Node<T>) get(index - 1);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }

        size++;
    }

    @Override
    public void remove(T object) {
        if (isEmpty()) {
            // Список пустой, ничего не делаем
            return;
        }

        if (head.data.equals(object)) {
            // Удаляемый элемент находится в голове списка
            head = head.next;
            if (head == null) {
                // Если голова стала null, значит список стал пустым, обновляем tail
                tail = null;
            }
            size--;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.data.equals(object)) {
                // Нашли элемент для удаления
                currentNode.next = currentNode.next.next;
                if (currentNode.next == null) {
                    // Если следующий элемент стал null, обновляем tail
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
        size = 0;    // Устанавливаем размер списка в ноль
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
                return index; // Нашли совпадение, возвращаем индекс
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
                return index; // Нашли последнее совпадение, возвращаем индекс
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
            // Если список пустой, устанавливаем новый узел как head и tail
            head = newNode;
            tail = newNode;
        } else {
            // Вставляем новый узел в конец списка
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }


    @Override
    public T poll() {
        if (isEmpty()) {
            return null; // Возвращаем null, если список пустой
        }

        T removedElement = head.data;
        head = head.next;
        size--;

        if (head == null) {
            // Если удалили последний элемент, обновляем tail
            tail = null;
        }

        return removedElement;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null; // Возвращаем null, если коллекция пуста
        }

        return head.data; // Возвращаем значение первого элемента
    }

}
