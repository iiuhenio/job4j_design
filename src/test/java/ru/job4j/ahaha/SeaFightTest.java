package ru.job4j.ahaha;


import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SeaFightTest {

    /**
     * Проверяем, что заданное поле действительно 10 * 10
     */
    @Test
    public void testSet() {
        SeaFight sf = new SeaFight();
        int[][] result = new int[10][10];
        Assert.assertArrayEquals(sf.set(), result);
    }

    /**
     * Проверяем, что после расстановки кораблей размер игрового поля не изменился
     */
    @Test
    public void testLocation() {
        SeaFight sf = new SeaFight();
        int[][] result = new int[10][10];
        Assert.assertArrayEquals(sf.location(), result);
    }

    /**
     * Проверяем, что количество одно-трублных кораблей равно 4
     */
    @Test
    public void testCount1() {
        int count1 = 4;
        SeaFight sf = new SeaFight();
        sf.location();
        sf.count1();
        assertThat(sf.count1(), is(count1));
    }

    /**
     * Проверяем, что количество двух-трублных кораблей равно 3
     */
    @Test
    public void testCount2() {
        int count2 = 3;
        SeaFight sf = new SeaFight();
        sf.location();
        sf.count2();
        assertThat(sf.count2(), is(count2));
    }

    /**
     * Проверяем, что количество трех-трублных кораблей равно 2
     */
    @Test
    public void testCount3() {
        int count3 = 2;
        SeaFight sf = new SeaFight();
        sf.location();
        assertThat(sf.count3(), is(count3));
    }

    /**
     * Проверяем, что количество четырех-трублных кораблей равно 1
     */
    @Test
    public void testCount4() {
        int count4 = 1;
        SeaFight sf = new SeaFight();
        sf.location();
        assertThat(sf.count4(), is(count4));
    }
}