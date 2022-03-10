package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddThenFindUsernameIsEugene() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Eugene"));
        Role result = store.findById("3");
        assertThat(result.getRole(), is("Eugene"));
    }

    @Test
    public void whenAddAndThenFindUsernameIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("4", "Eugene"));
        Role result = store.findById("6");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicadeAndFindUsernameIsEugene() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Eugene"));
        store.add(new Role("1", "Roman"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Eugene"));
    }

    @Test
    public void whenReplaceThenUsernameRoman() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Eugene"));
        store.replace("1", new Role("1", "Roman"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Roman"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChandeRole() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Eugene"));
        store.replace("10", new Role("10", "Roman"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Eugene"));
    }

    @Test
    public void whenDeleteRolethenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Eugene"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRolethenRoleIsEugene() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Eugene"));
        store.delete("5");
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Eugene"));
    }
}