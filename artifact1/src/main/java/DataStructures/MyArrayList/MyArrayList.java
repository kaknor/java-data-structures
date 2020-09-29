package DataStructures.MyArrayList;

// Information from https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html
public class MyArrayList {

    private int[] array_;

	public MyArrayList(int i) {
        this.array_ = new int[i];
	}

	public int size() {
		return this.array_.length;
	}
    
}
