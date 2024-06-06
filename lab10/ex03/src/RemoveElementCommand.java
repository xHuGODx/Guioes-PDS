import java.util.Collection;

/**
 * The RemoveElementCommand class represents a command to remove an element from a collection.
 * It extends the Command class and is parameterized with the type of elements in the collection.
 *
 * @param <E> the type of elements in the collection
 */
public class RemoveElementCommand<E> extends Command<E> {

    /**
     * Constructs a new RemoveElementCommand with the specified elements and backup collections.
     *
     * @param elements the collection of elements to remove from
     * @param backup   the backup collection to store a copy of the elements before removal
     */
    public RemoveElementCommand(Collection<E> elements, Collection<E> backup) {
        super(elements, backup);
    }

    /**
     * Executes the command by removing the specified element from the collection.
     * It also saves a backup of the collection before removal.
     *
     * @param element the element to remove from the collection
     */
    public void execute(E element) {
        saveBackup();
        elements.remove(element);
    }
}
