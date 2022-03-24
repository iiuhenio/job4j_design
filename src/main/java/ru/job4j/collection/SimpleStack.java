package ru.job4j.collection;

import java.util.Iterator;

/**
 Данные очереди нужно хранить в ru.job4j.collection.SimpleStack. Для этого задания нужны два стека.
 Представьте, что у вас стопка с тарелками. Вам нужно достать нижнюю тарелку.
 Для этого вы перекладываете все тарелки в другую стопку.
 Стопка - это стек. Для операции извлечения первой тарелки нужны две стопки.
 */

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }

    public boolean isEmpty() {
        Iterator<T> it = linked.iterator();
        return !it.hasNext();
    }
}