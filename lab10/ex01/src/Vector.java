import java.util.Iterator;
import java.util.ListIterator;

/**
 * The Vector interface represents a collection of elements.
 * It provides methods to iterate over the elements in the collection.
 *
 * @param <T> the type of elements in the vector
 */
public interface Vector<T> {
    /**
     * Returns an iterator over the elements in the vector.
     *
     * @return an iterator over the elements in the vector
     */
    public Iterator<T> Iterator();

    /**
     * Returns a list iterator over the elements in the vector.
     *
     * @return a list iterator over the elements in the vector
     */
    public ListIterator<T> listIterator();

    /**
     * Returns a list iterator over the elements in the vector,
     * starting at the specified index.
     *
     * @param index the index to start the iteration from
     * @return a list iterator over the elements in the vector,
     *         starting at the specified index
     */
    public ListIterator<T> listIterator(int index);
}
