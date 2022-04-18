package ru.job4j.map;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleMapTest {

SimpleMap<Integer, String> table = new SimpleMap<>();

    @Before
    public void initData() {
        table.put(1, "Volodya");
        table.put(2, "Anton");
        table.put(3, "Victor");
    }

    @Test
    public void whenAddAndTrue() {
        Assert.assertTrue(table.put(4, "Stepan"));
    }

    @Test
    public void whenAddAndFalse() {
        Assert.assertFalse(table.put(3, "Igor"));
    }

    @Test
    public void whenGetAndNull() {
        Assert.assertNull(table.get(5));
    }

    @Test
    public void whenGetandValue() {
        Assert.assertEquals("Victor", table.get(3));
    }

    @Test
    public void removeAndNull() {
        Assert.assertFalse(table.remove(5));
    }

    @Test
    public void removeAndTrue() {
        Assert.assertTrue(table.remove(2));
    }

    @Test
    public void removeAndFalse() {
        Assert.assertFalse(table.remove(6));
    }

    @Test
    public void iterator() {
        Assert.assertTrue(table.iterator().hasNext());
    }

    @Test
    public void whenNextIs1() {
        Iterator<Integer> it = table.iterator();
        Assert.assertEquals(Integer.valueOf(1), it.next());
    }



   //@Test (expected = NoSuchElementException.class)
   //public void iteratorNext() {
   //    Assert.assertTrue(table.iterator().next(), "Volodya");
   //}
}