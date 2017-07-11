package io.tanners.StacksAndQueues;


public class QueueArray<E> {
    // queue
    private E queue[];
    // default size
    private final int default_size = 10;
    // basically a cursor to point to which element for the queue is at front
    private int index;
    // check to see if array is expandable
    private boolean limit;

    /**
     *
     */
    @SuppressWarnings("unchecked")
    public QueueArray()
    {
        // set queue size
        this.queue = (E[]) new Object[default_size];
        // set index to a non index array element
        this.index = -1;
        // set limit to false
        this.limit = false;
    }

    /**
     * size of the queue
     * @param size
     */
    @SuppressWarnings("unchecked")
    public QueueArray(int size) throws NegativeNumberException {
        // check size value
        if(size <= 0)
            throw new NegativeNumberException("Size can't be negative ");
        // number is not negative
        else
        {
            // set queue size
            this.queue = (E[]) new Object[size];
            // set index to a non index array element
            this.index = -1;
            // set limit to false
            this.limit = false;
        }
    }


    /**
     * size of the queue
     * @param size
     * limit checks if queue can expand
     * @param limit
     */
    @SuppressWarnings("unchecked")
    public QueueArray(int size, boolean limit) throws NegativeNumberException {
        // check size value
        if(size <= 0)
            throw new NegativeNumberException("Size can't be negative ");
        // number is not negative
        else {
            // set queue size
            this.queue = (E[]) new Object[size];
            // set index to a non index array element
            this.index = -1;
            // set limit
            this.limit = limit;
        }
    }

    /**
     * Peek at data at front of queue
     * @return
     */
    public E peek() throws QueueEmptyException {
        // make sure queue has any data by using index value
        if(!isEmpty())
            // return element at that index
            return (E) this.queue[index];
        // queue is empty
        else
            throw new QueueEmptyException("Queue is empty");
    }

    /**
     * Add data to queue
     * @param data
     * @return
     */
    public void enqueue(E data) throws QueueFullException {
        // index starts at -1, increment for first time
        // or any other times due to previous insertion
        this.index++;
        // check if queue can fit the new data
        if(this.index >= this.queue.length)
        {
            // check if queue is expandable
            if(!this.limit)
            {
                // increase size of array
                expandQueue();
                // add data to queue
                this.queue[this.index] = data;
            }
            // queue can't be expanded
            else
                throw new QueueFullException("Queue is full and cannot be expanded");
        }
        // queue can fit more data
        else
        {
            // add data to queue
            this.queue[index] = data;
        }
    }

    /**
     * Increase capacity of queue
     * @return
     */
    @SuppressWarnings("unchecked")
    private void expandQueue()
    {
        // increase new queue at double the current size
        E newQueue[] = (E[]) new Object[this.queue.length * 2];
        // loop and move elements from new queue to the new queue
        System.arraycopy(this.queue, 0, newQueue, 0, this.queue.length);
        // set new queue
        this.queue = newQueue;
    }

    /**
     * return the front of the queue and remove it from queue
     * @return
     */
    public E dequeue() throws QueueEmptyException {
        // check if queue is not empty
        if(!isEmpty()) {
            // get element
            E element = this.queue[index];
            // reset element value
            this.queue[index] = null;
            // reduce index pointer
            this.index--;
            // return value
            return element;
        }
        else
            throw new QueueEmptyException("Queue is empty");

    }


    /**
     * Check is queue is empty
     * @return
     */
    public boolean isEmpty()
    {
        // check where index is pointing to in queue
        // this will tell if it is empty or not
        // if index is a 0 + or less than array size (this may always be true but worth checking)
        if(this.index >= 0 && this.index < this.queue.length)
            return false;
        else
            return true;
    }

    public class QueueFullException extends Exception {

        public QueueFullException(String message) {
            super(message);
        }

    }

    public class QueueEmptyException extends Exception {

        public QueueEmptyException(String message) {
            super(message);
        }

    }

    public class NegativeNumberException extends Exception {

        public NegativeNumberException(String message) {
            super(message);
        }

    }
}
