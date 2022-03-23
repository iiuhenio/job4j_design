package ru.job4j.collection;

/**
 * Термин FIFO - first input first output. Первый пришел, первый ушел.
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countIn = 0;
    private int countOut = 0;

    public int outIsFull(T value) {
        out.push(value);
        countOut++;
        return countOut;
    }
    public int outIsEmpty() {
        out.pop();
        countOut--;
        return countOut;
    }
    public boolean outEmpty() {
        return countOut == 0;
    }
    public int inIsFull(T value) {
        in.push(value);
        countIn++;
        return countIn;
    }
    public int inIsEmpty() {
        in.pop();
        countIn--;
        return countIn;
    }
    public boolean inEmpty() {
        return countIn == 0;
    }

    /**
     * Метод poll() - должен удалять первое значение из коллекции.
     * и возвращать его.
     */
    public T poll() {
        if (this.outEmpty()) { /* если out пуст */
            while (!this.inEmpty()) { /* пока в in есть элементы */
                out.push(in.pop()); /* добавляем их из in в out (значение элемента получаем, удаляя его из in */
            }
        }
        return out.pop(); /* удаляем первое значение из коллекции и возвращаем его */
    }

    /**
     * Метод push(T value) - помещает значение в конец.
     */
    public void push(T value) {
        in.push(value);
        countIn++;
    }
}