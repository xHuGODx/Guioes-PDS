import java.util.Collection;
import java.util.ArrayList;

public class App {
    public static void main(String[] args){

        Collection<Integer> elements = new ArrayList<Integer>();
        Collection<Integer> backup = new ArrayList<Integer>();
        Command<Integer> addCommand = new AddElementCommand<Integer>(elements, backup);
        Command<Integer> removeCommand = new RemoveElementCommand<Integer>(elements, backup);

        // Add elements 1, 2, 3
        addCommand.execute(1);
        addCommand.execute(2);
        addCommand.execute(3);
        //Should print 1, 2, 3
        System.out.println(elements);
        assert(elements.size() == 3);

        // Undo the last add
        addCommand.undo();

        //Should print 1, 2
        System.out.println(elements);
        assert(elements.size() == 2);

        // Remove element 2
        removeCommand.execute(2);
        //Should print 1
        System.out.println(elements);
        assert(elements.size() == 1);
        // Undo the last remove
        removeCommand.undo();
        //Should print 1, 2
        System.out.println(elements);
        assert(elements.size() == 2);
        System.out.println("All good");
    }
}
