
package ru.job4j.set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleSetTest {

    Set<Integer> set;

    @Before
    public void initData() {
        set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
    }

 @Test
 public void whenCheckIterator() {
     Iterator<Integer> iterator = set.iterator();
     Assert.assertTrue(iterator.hasNext());
     Assert.assertEquals(Integer.valueOf(1), iterator.next());
     Assert.assertTrue(iterator.hasNext());
     Assert.assertEquals(Integer.valueOf(2), iterator.next());
     Assert.assertTrue(iterator.hasNext());
     Assert.assertEquals(Integer.valueOf(3), iterator.next());
     Assert.assertFalse(iterator.hasNext());
 }


    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void iterator() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        assertTrue(set.iterator().hasNext());
    }
}