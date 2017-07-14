package StacksAndQueues;


public interface IStack<E> {
    /**
     * Peek at data at top of stack
     * @return
     */
    public E top() throws StackExceptions.StackEmptyException;

    /**
     * Add data to stack
     * @param data
     * @return
     */
    public void push(Object data) throws StackExceptions.StackFullException;

    /**
     * return the top of the stack
     * @return
     */
    public E pop() throws StackExceptions.StackEmptyException;

    /**
     * Check is stack is empty
     * @return
     */
    public boolean isEmpty();

}
