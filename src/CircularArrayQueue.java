import java.util.*;

public class CircularArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
    private int front, rear, size, capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private E[] circularArray;

    /**
     * full constructor
     * @param initialCapacity
     */
    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int initialCapacity) {
        capacity = initialCapacity;
        circularArray = (E[]) new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    /**
     * default constructor with size of 10
     */
    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularArrayQueueIterator();
    }

    //Inner class implementing the iterator
    private class CircularArrayQueueIterator implements Iterator<E> {
        int index = front;
        int count = 0;

        /**
         * method checks to see if there are elements within the queue
         * @return true if there are elements
         */
        @Override
        public boolean hasNext() {
            return count < size;
        }

        public Iterator<E> iterator() {
            return new CircularArrayQueueIterator();
        }
        /**
         * method will move to the next element within the queue
         * @return the next element in queue
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = circularArray[index];
            index = (index + 1) % capacity;
            count++;
            return returnValue;
        }

        /**
         * removes the item accesed by Iter object
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * method doubles the capacity and reallocates the data within the original array
     */
    private void reallocate() {
        int newCapacity = 2 * capacity;
        E[] newData = (E[]) new Object[newCapacity]; //creates new array with new capacity doubled
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = circularArray[i];
            j = (j + 1) % capacity;
        }
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        circularArray = newData;
    }

    /**
     * method that checks to see if Array needs to be reallocated, adds new object to rear
     * @param e
     * @return true after item is adde
     */
    @Override
    public boolean offer(E e) {
        if(size == capacity) {
            reallocate();
        }
        size++;
        rear = (rear + 1) % capacity;
        circularArray[rear] = e;
        return true;
    }

    /**
     * method returns item at the front of the queue
     * @return front of queue item, null if no item
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        } else {
            return circularArray[front];
        }
    }

    /**
     * method removes the item at the front of the queue and returns if queue
     * @return item removed if present, null if no item
     */
    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        E result = circularArray[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }
}
