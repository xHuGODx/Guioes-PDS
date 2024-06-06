import java.util.Collection;

/**
 * The abstract base class for commands that operate on a collection of elements.
 *
 * @param <E> the type of elements in the collection
 */
public abstract class Command<E> {
    protected Collection<E> elements;
    protected Collection<E> backup;

    /**
     * Constructs a new Command object with the specified elements and backup collections.
     *
     * @param elements the collection of elements to operate on
     * @param backup   the backup collection to store the previous state of elements
     */
    public Command(Collection<E> elements, Collection<E> backup) {
        this.elements = elements;
        this.backup = backup;
    }
    
    /**
     * Saves the current state of the elements collection into the backup collection.
     */
    public void saveBackup() {
        backup.clear();
        backup.addAll(elements);
    }

    /**
     * Restores the elements collection to its previous state stored in the backup collection.
     */
    public void undo() {
        elements.clear();
        elements.addAll(backup);
    }

    /**
     * Executes the command on the specified element.
     *
     * @param element the element to operate on
     */
    public abstract void execute(E element);
}
