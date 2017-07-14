package StacksAndQueues;

public class QueueLinkedList<E> extends QueueExceptions implements IQueue {

    private Node head;
    private Node tail;
    private int size;

    public QueueLinkedList()
    {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * Peek at data at front of queue
     *
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        try {
            if (!isEmpty())
                return (E) tail.data;
            else
                throw new QueueEmptyException("Queue is empty");
        } catch (QueueEmptyException e) {
            e.printStackTrace();
            return null;
        }
    }

        /**
     * Add data to queue
     *
     * @param data
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public void enqueue(Object data) {



        Node newNode = new Node((E) data);

        if(isEmpty())
        {
            this.head = newNode;
            this.tail = newNode;
        }
        else
        {
            newNode.next = head;
            this.head.prev = newNode;
            this.head = newNode;
        }

        this.size++;
    }

    /**
     * return the front of the queue and remove it from queue
     *
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public E dequeue() {

        try {
            if (!isEmpty()) {
                E element = (E) this.tail.data;

                this.size--;

                if(isEmpty())
                {
                    this.tail = null;
                    this.head = null;
                }
                else
                {
                    Node prev = this.tail.prev;
                    this.tail.prev = null;
                    prev.next = null;
                    this.tail = prev;
                }

                return element;
            } else
                throw new QueueEmptyException("Queue is empty");
        } catch (QueueEmptyException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        for(Node cur = this.head; cur != null; cur = cur.next)
        {
            str.append(cur.data);
            str.append(", ");
        }

        return str.toString();
    }

    /**
     * Check is queue is empty
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
//        return this.tail == null || this.head == null;
    }


    public static class Node<E>
    {
        public Node next;
        public Node prev;
        public E data;

        public Node(E data)
        {
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

}
