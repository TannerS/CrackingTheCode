package StacksAndQueues;


public interface IQueue<E> {
    /**
     * Peek at data at front of queue
     * @return
     */
    public E peek() throws Queue.QueueEmptyException;

    /**
     * Add data to queue
     * @param data
     * @return
     */
    public void enqueue(Object data) throws Queue.QueueFullException;

    /**
     * return the front of the queue and remove it from queue
     * @return
     */
    public E dequeue() throws Queue.QueueEmptyException;

    /**
     * Check is queue is empty
     * @return
     */
    public boolean isEmpty();

}
