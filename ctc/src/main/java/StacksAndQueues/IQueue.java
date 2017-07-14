package StacksAndQueues;


public interface IQueue<E> {
    /**
     * Peek at data at front of queue
     * @return
     */
    public E peek() throws QueueExceptions.QueueEmptyException;

    /**
     * Add data to queue
     * @param data
     * @return
     */
    public void enqueue(Object data) throws QueueExceptions.QueueFullException;

    /**
     * return the front of the queue and remove it from queue
     * @return
     */
    public E dequeue() throws QueueExceptions.QueueEmptyException;

    /**
     * Check is queue is empty
     * @return
     */
    public boolean isEmpty();

}
