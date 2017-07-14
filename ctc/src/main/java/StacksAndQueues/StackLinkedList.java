package StacksAndQueues;

public class StackLinkedList<E> extends StackExceptions implements IStack<E>
{
    private int size;
    private Node head;
    private Node tail;

    public StackLinkedList()
    {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @SuppressWarnings("unchecked")
    public void push(Object data)
    {
        if(this.head != null)
        {
            Node newNode = new Node((E)  data);
            this.head = newNode;
            this.tail = newNode;
        }
        else
        {
            Node newNode = new Node((E) data);
            this.head.next = newNode;
            this.head = newNode;
        }

        this.size++;
    }


    /**
     * Peek at data at front of stack
     *
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public E top()  {
        try {
            if(!isEmpty())
                return (E) this.head.data;
            else
                throw new StackExceptions.StackEmptyException("Stack is empty");
        } catch (StackExceptions.StackEmptyException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  return the top of the stack and remove it from stack
     *
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public E pop() throws StackEmptyException {
        E data = (E) this.head.data;
        Node prev = this.head.prev;
        prev.next = null;
        this.head = prev;
        this.size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        for(Node cur = this.tail; cur != null; cur = cur.next)
        {
            str.append(cur.data);
            str.append(", ");
        }

        return str.toString();
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
