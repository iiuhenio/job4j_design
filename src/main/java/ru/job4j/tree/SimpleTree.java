package ru.job4j.tree;

import java.util.*;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root; /* поле "корень дерева" */

    public SimpleTree(final E root) {
        this.root = new Node<>(root); /* конструктор нового узла */
    }

    /**
     * Метод add - Должен находить узел по значению parent и добавлять в него дочерний узел со значением child.
     * В этом методе нужно проверить, что значения child еще нет в дереве, а parent есть.
     * Если child есть, то метод должен вернуть false.
     * @param parent - искомый элемент
     * @param child - элемент, который добавляем в искомый
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        if (findBy(parent).isPresent() && findBy(child).isEmpty()) { /* если parent существует а child нет */
            findBy(parent).get().children.add(new Node<>(child)); /* то полчаем значение parent,
            и в поле children добавляем новый узел child  */
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) { /* принимает значение, которое нужно найти */
        Optional<Node<E>> rsl = Optional.empty(); /* создаем объект rsl типа Optional */
        Queue<Node<E>> data = new LinkedList<>(); /* создаем объект типа Линкедлист/Очередь (ПППУ) */
        data.offer(this.root); /* добавляем корневой узел в список */
        while (!data.isEmpty()) { /* перебираем пока список не пустой */
            Node<E> el = data.poll(); /* el = извлекаемый элемент */
            if (el.value.equals(value)) { /* если значение элемента el равно искомому значению */
                rsl = Optional.of(el); /* результат = el */
                break; /* заканчиваем выполнение программы */
            }
            data.addAll(el.children); /* добавляем все элементы в очередь */
        }
        return rsl; /* результат равен el */
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        System.out.println(tree);

    }
}