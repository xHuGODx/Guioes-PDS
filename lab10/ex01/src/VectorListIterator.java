import java.util.ListIterator;

/**
 * The VectorListIterator class implements the ListIterator interface and provides
 * an iterator over a VectorGeneric object.
 *
 * @param <T> the type of elements in the VectorGeneric object
 */
public class VectorListIterator<T> implements ListIterator<T> {
    private VectorGeneric<T> vector;
    private int index;

    /**
     * Constructs a new VectorListIterator object.
     * 
     * @param vector the VectorGeneric object to iterate over
     * @param index the starting index of the iterator
     */
    public VectorListIterator(VectorGeneric<T> vector, int index) {
        this.vector = vector;
        this.index = index;
    }

    /**
     * Returns true if there is at least one more element in the list, false otherwise.
     *
     * @return true if there is at least one more element in the list, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return index < vector.totalElem();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
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

    /**
     * Returns true if this list iterator has a previous element.
     * 
     * @return true if this list iterator has a previous element, false otherwise
     */
    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    /**
     * Returns the previous element in the iteration.
     *
     * @return the previous element in the iteration
     * @throws IndexOutOfBoundsException if there is no previous element
     */
    @Override
    public T previous() {
        if(hasPrevious()) {
            return vector.getElem(--index);
        }
        else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Returns the index of the element that would be returned by a subsequent call to the next() method.
     *
     * @return the index of the element that would be returned by a subsequent call to the next() method
     */
    @Override
    public int nextIndex() {
        return index;
    }

    /**
     * Returns the index of the element that would be returned by a subsequent call to {@link #previous()}.
     *
     * @return the index of the previous element, or -1 if there is no previous element
     */
    @Override
    public int previousIndex() {
        return index - 1;
    }

    /**
     * Removes the last element returned by the iterator from the underlying list.
     * This method can only be called once per call to the `next` method.
     * The behavior of the iterator is unspecified if the underlying list is modified
     * while the iteration is in progress in any way other than by calling this method.
     */
    @Override
    public void remove() {
        vector.removeElem(vector.getElem(index));
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param e the element to be added
     */
    @Override
    public void add(T e) {
        vector.addElem(e);
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param e the element to be stored at the specified position
     */
    @Override
    public void set(T e) {
        VectorGeneric<T> newVector = new VectorGeneric<T>();
        for(int i = 0; i < vector.totalElem(); i++) {
            if(i == index) {
                newVector.addElem(e);
            }
            else {
                newVector.addElem(vector.getElem(i));
            }
        }
        vector = newVector;
    }
}