import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E>{

    private ArrayList<E> arrayList;

    public ArrayListStack() {
        arrayList = new ArrayList<>();
    }

    /**
     * method checks to see if the arraylist is empty
     * @return
     */
    public boolean empty() {
        return arrayList.isEmpty();
    }

    /**
     * method displays what element is at the top of the stack
     * @return element that is at the top of the stack
     */
    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return arrayList.get(arrayList.size() - 1);
    }

    /**
     * method removes from the top of the stack
     * @return element that was removed
     */
    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return arrayList.remove(arrayList.size() - 1);
    }

    /**
     * method pushes object to top of the stack
     * @param object
     * @return object that was pushed on top of stack
     */
    @Override
    public E push(E object) {
        arrayList.add(object);
        return object;
    }

}
