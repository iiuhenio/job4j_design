package ru.job4j.collection;

/**
 * Термин FIFO - first input first output. Первый пришел, первый ушел.
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countIn = 0;
    private int countOut = 0;
    private int size;

    public int getSize() {
        return size;
    }

    /**
     * Метод poll() - должен удалять первое значение из коллекции.
     * и возвращать его.
     */

    public T poll() {


        return out.pop(); /* удаляем первое значение из коллекции и возвращаем его */
    }

    /**
     * Метод push(T value) - помещает значение в конец.
     */
    public void push(T value) {
        in.push(value);
    }


    public int inAdd(T value) {
        in.push(value);
        countIn++;
        return countIn;
    }
    public int intOdd() {
        in.pop();
        size--;
        return size;
    }
}