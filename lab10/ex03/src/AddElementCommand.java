import java.util.Collection;

/**
 * The AddElementCommand class represents a command to add an element to a collection.
 * It extends the Command class and is parameterized with the type of elements in the collection.
 *
 * @param <E> the type of elements in the collection
 */
public class AddElementCommand<E> extends Command<E> {

    /**
     * Constructs an AddElementCommand with the specified elements and backup collections.
     *
     * @param elements the collection of elements to add the new element to
     * @param backup   the backup collection used for undo operations
     */
    public AddElementCommand(Collection<E> elements, Collection<E> backup) {
        super(elements, backup);
    }

    /**
     * Executes the command by adding the specified element to the collection.
     * Saves a backup of the collection before adding the element.
     *
     * @param element the element to be added to the collection
     */
    public void execute(E element) {
        saveBackup();
        elements.add(element);
    }
}
