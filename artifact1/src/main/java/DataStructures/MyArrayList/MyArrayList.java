package DataStructures.MyArrayList;

// Information from https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html
public class MyArrayList {

    private int[] array_;
    private int capacity_;
    private int size_ = 0;

    public MyArrayList(int capacity) {
        this.capacity_ = capacity;
        this.array_ = new int[this.capacity_];
    }

    public MyArrayList(int[] array) {
        this.capacity_ = array.length;
        this.size_ = array.length;
        this.array_ = new int[this.capacity_];
        for (int i = 0; i < this.size_; ++i) {
            this.array_[i] = array[i];
        }
    }

    public int size() {
        return this.size_;
    }

    public int get(int i) {
        if (i > this.size_)
            throw new IndexOutOfBoundsException();
        return (i >= 0) ? this.array_[i] : this.array_[this.size_ + i];
    }

    public Boolean equals(int[] array) {
        if (this.size_ != array.length)
            return false;

        for (int i = 0; i < this.size_; ++i)
            if (this.array_[i] != array[i])
                return false;

        return true;
    }

    public void set(int index, int value) {
        if (index > this.size_)
            throw new IndexOutOfBoundsException();
        this.array_[index] = value;
    }

    public void add(int index, int value) {
        if (index > this.size_ || index < 0)
            throw new IndexOutOfBoundsException();

        if (this.capacity_ <= this.size_) {
            this.size_++;
            // Reallocate memory
            this.capacity_ *= 2;
            int[] tmp = new int[this.capacity_];
            // Copy memory
            int i = 0;
            for (; i < index; ++i) {
                tmp[i] = this.array_[i];
            }
            tmp[index] = value;
            for (; i < this.size_ - 1; ++i) {
                tmp[i + 1] = this.array_[i];
            }
            this.array_ = tmp;
        } else {
            // Move inplace elements of array_ from index to size.
            for (int i = this.size_; i > index; --i) {
                this.array_[i] = this.array_[i - 1];
            }
            ++this.size_;
            this.array_[index] = value;
        }
    }

    public void add(int e) {
        this.add(this.size_, e);
    }

    public void addAll(int index, int[] arrayToAdd) {
        if (index < 0 || index > this.size_)
            throw new IndexOutOfBoundsException();

        if (arrayToAdd == null)
            throw new NullPointerException();

        for (int i = 0; i < arrayToAdd.length; ++i) {
            this.add(index + i, arrayToAdd[i]);
        }
    }

    public void addAll(int[] arrayToAdd) {
        this.addAll(this.size_, arrayToAdd);
    }

    public void clear() {
        this.size_ = 0;
    }

    public boolean contains(int e) {
        for (int i = 0; i < this.size_; ++i)
            if (this.array_[i] == e)
                return true;
        return false;
    }

    public void remove(int index) {
        if (index == this.size_ - 1) {
            this.size_--;
            return;
        }
        for (int i = index; i < this.size_ - 1; ++i) {
            this.array_[i] = this.array_[i + 1];
        }
        this.size_--;
    }

	public int indexOf(int e) {
		for (int i = 0; i < this.size_; ++i)
            if (this.array_[i] == e)
                return i;
        return -1;
	}

}
