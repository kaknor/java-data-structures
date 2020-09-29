package DataStructures.MyArrayListTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import DataStructures.MyArrayList.MyArrayList;

public class MyArrayListTest {
    @Test
    public void sizeShouldBe5() {
        MyArrayList list = new MyArrayList(5);
        assertTrue(list.size() == 5);
    }
}
