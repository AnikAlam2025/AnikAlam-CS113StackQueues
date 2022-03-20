import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayListStack<E> implements StackInterface<E>{

    private ArrayList<E> arrayList;

    public ArrayListStack() {
        arrayList = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public boolean empty() {
        return arrayList.isEmpty();
    }

    /**
     *
     * @return
     */
    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return arrayList.get(arrayList.size() - 1);
    }

    /**
     *
     * @return
     */
    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return arrayList.remove(arrayList.size() - 1);
    }

    /**
     *
     * @param object object to push onto top of stack
     * @return
     */
    @Override
    public E push(E object) {
        arrayList.add(object);
        return object;
    }
}
