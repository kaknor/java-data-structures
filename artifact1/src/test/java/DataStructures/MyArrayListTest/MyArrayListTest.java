package DataStructures.MyArrayListTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import DataStructures.MyArrayList.MyArrayList;

public class MyArrayListTest {
    @Test
    public void sizeMustBe0() {
        MyArrayList list = new MyArrayList(5);
        assertTrue(list.size() == 0);
    }

    @Test
    public void getMustBe5() {
        int[] array = {0, 1, 2, 3, 4, 5};
        MyArrayList list = new MyArrayList(array);
        assertTrue(list.get(5) == 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getMustThrowIndexOutOfBoundException() {
        MyArrayList l = new MyArrayList(1);
        l.get(2);
    }

    @Test
    public void comparisonOfArrayAndArrayListMustBeTrue() {
        int[] array = {1, 2, 3, 4, 5};
        MyArrayList l = new MyArrayList(array);
        assertTrue(l.equals(array));
    }

    @Test
    public void setIndex0To5() {
        MyArrayList l = new MyArrayList(1);
        l.set(0, 5);
        assertTrue(l.get(0) == 5);
    }

    @Test
    public void add3AtPos2() {
        int[] array = {1, 2, 4, 5};
        MyArrayList l = new MyArrayList(array);
        l.add(2, 3);

        int[] arrayAfterAddition = {1, 2, 3, 4, 5};
        for (int i = 0; i < l.size(); ++i) {
            assertTrue(arrayAfterAddition[i] == l.get(i));
        }
    }

    @Test
    public void add5CapacityIncreaseMustOccur() {
        MyArrayList l = new MyArrayList(1);
        assertTrue(l.size() == 0);
        l.add(5);
        l.add(5);
        assertTrue(l.size() == 2);
    }

    @Test
    public void addFirstPosMoveMustOccur() {
        int[] array = {1, 2};
        MyArrayList l = new MyArrayList(array);
        l.add(0, 0);
        l.add(0, -1);
        int[] arrayAfterAddition = {-1, 0, 1, 2};
        assertTrue(l.equals(arrayAfterAddition));
    }
}
