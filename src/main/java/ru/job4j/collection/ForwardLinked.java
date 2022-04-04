package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * В этом задании необходимо реализовать метод delete для односвязного списка.
 *  Для организации однотипных данных мы использовали массивы. Есть другой способ решить эту задачу.
 * Объекты - это ссылочные типы.
 * Значит, можно создать цепочку ссылок и таким образом организовать контейнер для данных.
 * @param <T>
 */
public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public boolean revert() {
        boolean rsl = head != null && head.next != null;
        if (rsl) {
            tail = head; /* Тот элемент, кот. был первым, станет последним. Конец списка - бывашая голова списка */
            Node<T> current = head.next; /* создаем переменную, ссылку на текущий узел. */
            head.next = null; /* head теперь последний эл-т списка, а значит, не должен не на что указывать */
            while (current != null) { /* до тех пор, пока текущий элемент не равен null */
                Node<T> next = current.next; /* сохраняем ссылку на текущий элемент. Next ссылается на след. эл-т */
                current.next = head; /* раньше current.next ссылался на след. эл-т, а теперь - на предыдущий */
                head = current; /* смещаем все указатели вперед. В current ссылка на текущий элемент */
                current = next; /* в current записываем next */
            }
        }
        return rsl;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * head.value - получить значение первого элемента списка.
     * head.next - получить ссылку на второй элемент списка.
     * head.next.value - значение следующего узла и т.д.
     *
     * созадим новый узел, в котором полем value сделаем значение первого элемента,
     * а полем next - ссылку на первый элемент
     * и прировняем созданный нами элемент к head
     */
    public void addFirst(T value) {
        head = new Node(value, head); /* создаем новый элемент со значениями value = value, next = null */
        }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value; /* записываем значение первой переменной во временную переменную */
        Node<T> next = head.next; /* запис. ссылку 1й перем-й на след-ю в пер-ю next */
        head.next = null; /* удаляем ссылку 1й перем-й на след-ю */
        head.value = null; /* удаляем значение 1й перем-й */
        head = next; /* возвращаем  */
        return value; /* возвращаем удаленную переменную */
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> { /* создаем класс Node */
        T value; /* определяем поля: value типа Т */
        Node<T> next; /* и объект next класса Node, содержащий любые значения  */

        public Node(T value, Node<T> next) { /* создаем конструктор Node с перем. value типа Т и объект next Node */
            this.value = value; /* инициализируем поле value */
            this.next = next; /* инициализируем поле next */
        }
    }
}