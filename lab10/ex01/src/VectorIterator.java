import java.util.Iterator;

/**
 * An iterator for the VectorGeneric class.
 * @param <T> the type of elements in the vector
 */
public class VectorIterator<T> implements Iterator<T> {
    public VectorGeneric<T> vector;
    public int index;

    /**
     * Constructs a VectorIterator object for the given vector.
     * @param vector the vector to iterate over
     */
    public VectorIterator(VectorGeneric<T> vector) {
        this.vector = vector;
        this.index = 0;
    }

    /**
     * Returns true if there are more elements in the vector to iterate over.
     * @return true if there are more elements, false otherwise
     */
    @Override
    public boolean hasNext() {
        return index < vector.totalElem();
    }

    /**
     * Returns the next element in the vector and advances the iterator.
     * @return the next element in the vector
     * @throws IndexOutOfBoundsException if there are no more elements to iterate over
     */
    @Override
    public T next() {
        if(hasNext()) {
            return vector.getElem(index++);
        }
        else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
