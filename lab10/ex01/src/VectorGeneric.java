import java.util.ListIterator;
import java.util.Iterator;

/**
 * This class represents a generic vector.
 * It provides methods to manipulate and access elements in the vector.
 *
 * @param <T> the type of elements in the vector
 */
public class VectorGeneric<T> implements Vector<T>{
	private T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	/**
	 * This class represents a generic vector.
	 * It provides methods to manipulate and access elements in the vector.
	 *
	 * @param <T> the type of elements in the vector
	 */
	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	/**
	 * Adds the specified element to the vector.
	 *
	 * @param elem the element to be added
	 * @return true if the element is added successfully, false otherwise
	 */
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	/**
	 * Ensures that the vector has enough space to accommodate additional elements.
	 * If the number of elements in the vector is equal to or greater than the current capacity,
	 * the capacity is increased by a fixed amount (ALLOC) and the elements are copied to a new array.
	 */
	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	/**
	 * Removes the specified element from the vector.
	 *
	 * @param elem the element to be removed
	 * @return true if the element is successfully removed, false otherwise
	 */
	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the total number of elements in the vector.
	 *
	 * @return the total number of elements in the vector
	 */
	public int totalElem() {
		return nElem;
	}
	
	/**
	 * Returns the element at the specified index in the vector.
	 *
	 * @param i the index of the element to retrieve
	 * @return the element at the specified index
	 */
	public T getElem(int i) {
		return (T) vec[i];
	}

	/**
	 * Returns an iterator over the elements in this vector in proper sequence.
	 *
	 * @return an iterator over the elements in this vector
	 */
	@Override
	public Iterator<T> Iterator() {
		return new VectorIterator<T>(this);
	}

	/**
	 * Returns a list iterator over the elements in this vector in proper sequence.
	 *
	 * @return a list iterator over the elements in this vector in proper sequence
	 */
	@Override
	public ListIterator<T> listIterator() {
		return new VectorListIterator<T>(this, 0);
	}

	/**
	 * Returns a list iterator over the elements in this vector (in proper sequence),
	 * starting at the specified position in the vector. The specified index indicates
	 * the first element that would be returned by an initial call to `next`.
	 *
	 * @param index the index of the first element to be returned from the list iterator
	 * @return a list iterator over the elements in this vector (in proper sequence),
	 * starting at the specified position in the vector
	 */
	@Override
	public ListIterator<T> listIterator(int index) {
		return new VectorListIterator<T>(this, index);
	}
}
