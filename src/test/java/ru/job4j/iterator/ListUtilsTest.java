package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void remove() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.removeIf(input, (x) -> x == 2);
        assertThat(input, is(Arrays.asList(1, 3)));
    }

    @Test
    public void replace() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 5, 3));
        ListUtils.replaceIf(input, (x) -> x == 5, 2);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

        @Test public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        ListUtils.removeAll(input, input2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }
}