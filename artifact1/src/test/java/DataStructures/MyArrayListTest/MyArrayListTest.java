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
    public void getLastElementUsingMinusOneIndex() {
        int[] array = {0, 1, 2, 3, 4, 5};
        MyArrayList list = new MyArrayList(array);
        assertTrue(list.get(-1) == 5);
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

    @Test
    public void addAllMustAppendNewArray() {
        int[] array = {1, 2};
        int[] arrayToAdd = {3, 4};
        MyArrayList l = new MyArrayList(array);
        l.addAll(arrayToAdd);
        int[] arrayAfterInsertion = {1, 2, 3, 4};
        assertTrue(l.equals(arrayAfterInsertion));
    }

    @Test
    public void addAllMustAppendNewArrayAtSpecificIndex() {
        int[] array = {1, 4};
        int[] arrayToAdd = {2, 3};
        MyArrayList l = new MyArrayList(array);
        l.addAll(1, arrayToAdd);
        int[] arrayAfterInsertion = {1, 2, 3, 4};
        assertTrue(l.equals(arrayAfterInsertion));
    }

    @Test
    public void sizeMustBe0AfterClear() {
        int[] array = {1, 2, 3};
        MyArrayList l = new MyArrayList(array);
        l.clear();
        assertTrue(l.size() == 0);
    }

    @Test
    public void listMustContain5() {
        int[] array = {1, 2, 3, 5, 6};
        MyArrayList l = new MyArrayList(array);
        assertTrue(l.contains(5) == true);
    }

    @Test
    public void removeFirstElementFromList(){
        int[] array = {5, 4, 3, 2, 1};
        MyArrayList l = new MyArrayList(array);
        int[] arrayAfterDeletion = {4, 3, 2, 1};
        l.remove(0);
        assertTrue(l.equals(arrayAfterDeletion));
    }

    @Test
    public void removeLastElementFromList() {
        int[] array = {5, 4, 3, 2, 1};
        MyArrayList l = new MyArrayList(array);
        int[] arrayAfterDeletion = {5, 4, 3, 2};
        l.remove(l.size() - 1);
        assertTrue(l.equals(arrayAfterDeletion));
    }

    @Test
    public void removeElementAtIndex2FromList() {
        int[] array = {5, 4, 3, 2, 1};
        MyArrayList l = new MyArrayList(array);
        int[] arrayAfterDeletion = {5, 4, 2, 1};
        l.remove(2);
        assertTrue(l.equals(arrayAfterDeletion));
    }

    @Test
    public void findIndexOfLastEmelementOfTheList() {
        int[] array = {1, 2, 3, 4};
        MyArrayList l = new MyArrayList(array);
        assertTrue(l.indexOf(4) == l.size() - 1);
    }

    @Test
    public void findIndexOfElementNotPresentInTheList() {
        int[] array = {1, 2, 3, 4};
        MyArrayList l = new MyArrayList(array);
        assertTrue(l.indexOf(-123) == -1);
    }

    @Test
    public void find5UsingBinarySearchMustReturn6() {
        int[] array = {-42, -1, 0, 1, 2, 3, 5, 126, 127};
        MyArrayList l = new MyArrayList(array);
        assertTrue(l.binarySearch(5) == 6);
    }

    @Test
    public void find128UsingBinarySearchMustReturnMinus9() {
        int[] array = {-42, -1, 0, 1, 2, 3, 5, 126, 127};
        MyArrayList l = new MyArrayList(array);
        assertTrue(l.binarySearch(128) == -9); 
    }

    @Test
    public void findMinus43UsingBinarySearchMustReturnMinus1() {
        int[] array = {-42, -1, 0, 1, 2, 3, 5, 126, 127};
        MyArrayList l = new MyArrayList(array);
        assertTrue(l.binarySearch(-43) == -1); 
    }

}
