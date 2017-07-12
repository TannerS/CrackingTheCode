package StacksAndQueues;


import java.util.Arrays;

public class QueueArray<E> extends Queue implements IQueue{

    public static void main (String[] args)
    {

            QueueArray<Integer> testQueue = new QueueArray<Integer>();

            testQueue.enqueue(1);
            testQueue.enqueue(2);
            testQueue.enqueue(3);
            testQueue.enqueue(4);
            testQueue.enqueue(5);
            testQueue.enqueue(6);
            testQueue.enqueue(7);
            testQueue.enqueue(8);
            testQueue.enqueue(9);

        System.out.println(testQueue.toString());

        testQueue.dequeue();
        testQueue.dequeue();

        System.out.println(testQueue.toString());



            testQueue.enqueue(10);
            testQueue.enqueue(11);
//
            System.out.println(testQueue.toString());

            testQueue.enqueue(12);


////
            System.out.println(testQueue.toString());
////
            testQueue.enqueue(13);



//
            System.out.println(testQueue.toString());

        testQueue.enqueue(14);
        testQueue.enqueue(15);
        testQueue.enqueue(16);
        System.out.println(testQueue.toString());
        testQueue.dequeue();
        testQueue.dequeue();

        System.out.println(testQueue.toString());
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();



        System.out.println(testQueue.toString());

//        testQueue.dequeue();



        System.out.println(testQueue.toString());

//        assertArrayEquals(testQueue.getQueue(), new Integer[]{});

//        assertEquals("PEEK == 11", testQueue.peek().intValue(), 11);


    }

    public E[] getQueue() {
        return queue;
    }

    public void setQueue(E[] queue) {
        this.queue = queue;
    }

    // queue
    private E queue[];
    // default size
    private final int default_size = 10;
    // basically a cursor to point to which element for the queue is at end
    private int end;
    // basically a cursor to point to which element for the queue is at front
    private int start;
    // check to see if array is expandable
    private boolean limit;

    private int size;

    /**
     *
     */
    @SuppressWarnings("unchecked")
    public QueueArray()
    {
        // set queue size
        this.queue = (E[]) new Object[default_size];
        // set index to a non index array element
        this.end = 0;
        // set limit to false
        this.limit = false;

        this.size = 0;
        this.start = 0;
    }

    /**
     * size of the queue
     * @param size
     */
    @SuppressWarnings("unchecked")
    public QueueArray(int size){
        try {
            // check size value
            if(size <= 0)
                    throw new NegativeNumberException("Size can't be negative ");
                // number is not negative
            else
            {
                // set queue size
                this.queue = (E[]) new Object[size];
                // set index to a non index array element
                this.end = 0;
                // set limit to false
                this.limit = false;

                this.size = 0;
                this.start = 0;
            }
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * size of the queue
     * @param size
     * limit checks if queue can expand
     * @param limit
     */
    @SuppressWarnings("unchecked")
    public QueueArray(int size, boolean limit) {
        try {
            // check size value
            if (size <= 0)
                throw new NegativeNumberException("Size can't be negative ");
                // number is not negative
            else {
                // set queue size
                this.queue = (E[]) new Object[size];
                // set index to a non index array element
                this.end = 0;
                // set limit
                this.limit = limit;

                this.size = 0;
                this.start = 0;

            }
        }
        catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * Peek at data at front of queue
     * @return
     */
    @Override
    public E peek() {
        try {
            // make sure queue has any data by using index value
            if(!isEmpty())
                // return element at that index
                return (E) this.queue[start];
            // queue is empty
            else
                throw new QueueEmptyException("Queue is empty");
        } catch (QueueEmptyException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Add data to queue
     * @param data
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public void enqueue(Object data){
        try {
//            System.out.println("DEBUG 1: " + this.size);
//            System.out.println("DEBUG 1.1: " + this.queue.length);
//            System.out.println("DEBUG 1.2: " + this.end);
//            System.out.println("DEBUG 1.3: " + this.queue.length);


            // if queue as at end and full
//            if((this.end >= this.queue.length) && (this.size == this.queue.length))
            if((this.size == this.queue.length))
            {
//                System.out.println("DEBUG 2");

                // check if queue is expandable
                if(!this.limit)
                {

//                    System.out.println("DEBUG 3");

                    // increase size of array
                    expandQueue();
                    // add data to queue
                    this.queue[this.end] = (E) data;
                }
                // queue can't be expanded
                else
                    throw new QueueFullException("Queue is full and cannot be expanded");
            }
            // queue is at end but not full
            else if((this.end >= this.queue.length) && (this.size != this.queue.length))
            {

//                System.out.println("DEBUG 4");


                //int newPos = this.end % this.queue.length;

                // the new value will wrap around back to first element
                // this is assumed empty space since the size var != size of queue
                this.queue[0] = (E) data;
                // reset the end to new value
                this.end = 0;
            }
            else
            {
//                System.out.println("DEBUG 5:  " + data);
                this.queue[this.end] = (E) data;
            }

            // increase size
            this.size++;

            // index starts at -1, increment for first time
            // or any other times due to previous insertion
            this.end++;
        } catch (QueueFullException e) {
            e.printStackTrace();
        }


//        System.out.println("DEBUG &: " + Arrays.toString(this.queue));
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
//        System.out.println("DEBUG 33");




        int i = 0;

        for(int j = this.end ; i < this.size; i++, j++)
        {
//            System.out.println("DEBUG 34");

//            System.out.println("DEBUG !!: " + j);
//            System.out.println("DEBUG ##: " + (this.queue.length-1));

//            newQueue[i] = this.queue[j];

            // if start is at last element
            if(j == this.queue.length)
            {

                j = 0;


                newQueue[i] = this.queue[j];



            }
            else
            {

                newQueue[i] = this.queue[j];
            }




        }

        this.start = 0;
        this.end = i;
//        this.size

//        System.out.println("DEBUG 34");

//        System.out.println("DEBUG &%%: " + Arrays.toString(newQueue));


//        // loop and move elements from new queue to the new queue
//        System.arraycopy(this.queue, 0, newQueue, 0, this.queue.length);
//        // set new queue
        this.queue = newQueue;



    }

    /**
     * return the front of the queue and remove it from queue
     * @return
     */
    @Override
    public E dequeue() {
        try {
            // check if queue is not empty
            if (!isEmpty()) {
                // decrement size
                this.size--;
                // get element
                E element = this.queue[this.start];
                // reset element value
                this.queue[this.start] = null;
                // reduce index pointer
                this.start++;
//                // if empty after last dequeue
                if(isEmpty())
                {
                    // reset values
                    this.end = 0;
                    this.start = 0;
                }

//                System.out.println("REMOVED VALUE: " + element);
//                System.out.println("NEXT VALUE: " + this.queue[this.start]);

                // return value
                return element;
            } else
                throw new QueueEmptyException("Queue is empty");



        } catch (QueueEmptyException e) {
            e.printStackTrace();
            return null;
        }
    }


        /**
     * Check is queue is empty
     * @return
     */
    @Override
    public boolean isEmpty()
    {
        // check where index is pointing to in queue
        // this will tell if it is empty or not
        // if index is a 0 + or less than array size (this may always be true but worth checking)
//        if(this.index >= 0 && this.index < this.queue.length)
//        return this.size < this.queue.length;
        return this.size == 0;
    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();

//        System.out.println("SIZE: " + size);

//        for(int i = 0; i < this.size; i++)
        for(int i = 0; i < this.queue.length; i++)
        {
//            if(this.end % this.queue.length == 0)
            // if cursor is at end of the queue
            // it needs to wrap around
//            if(j == this.queue.length)
//            {
//                j = 0;
//                str.append(this.queue[j]);
//                str.append(", ");
//            }
//            else
//            {
//                str.append(this.queue[j]);
//                str.append(", ");
//            }

            str.append(this.queue[i]);
            str.append(", ");

        }

//        System.out.println(str.toString());

        return str.toString();
    }
}
