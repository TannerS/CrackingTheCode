import StacksAndQueues.QueueLinkedList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestQueueLinkedList {
    @Test
    public void TestEmptyAdd()
    {
        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
        testQueue.enqueue(1);
        assertEquals("PEEK == 1", testQueue.peek().intValue(), 1);
    }

    @Test
    public void TestEmptyAdd2()
    {
        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
        testQueue.enqueue(1);
        testQueue.enqueue(2);
        testQueue.enqueue(3);
        testQueue.enqueue(4);
        testQueue.enqueue(5);
        assertEquals("PEEK == 5", testQueue.peek().intValue(), 5);
    }

    @Test
    public void TestEmptyAddDel()
    {
        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
        testQueue.enqueue(4);
        testQueue.enqueue(2);
        testQueue.enqueue(3);
        testQueue.dequeue();
        testQueue.dequeue();
        assertEquals("PEEK == 4", testQueue.peek().intValue(), 4);
    }

    @Test
    public void TestEmptyAddDelAdd()
    {
        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
        testQueue.enqueue(4);
        testQueue.enqueue(2);
        testQueue.enqueue(3);
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.enqueue(8);
        testQueue.enqueue(9);
        assertEquals("PEEK == 9", testQueue.peek().intValue(), 9);
    }

    @Test
    public void TestEmptyAddDelAll()
    {
        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
        testQueue.enqueue(4);
        testQueue.enqueue(2);
        testQueue.enqueue(3);
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.enqueue(5);
        testQueue.enqueue(6);
        testQueue.enqueue(7);
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();

        assertTrue("SHOULD BE EMPTY", testQueue.isEmpty());
    }

    @Test
    public void TestEmptyAddDelAll2()
    {
        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();

        assertTrue("SHOULD BE EMPTY2", testQueue.isEmpty());
    }

    @Test
    public void TestEmptyAddDelAll3()
    {
        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
        testQueue.enqueue(4);
        testQueue.dequeue();
        assertTrue("SHOULD BE EMPTY3", testQueue.isEmpty());
    }

}