import StacksAndQueues.QueueLinkedList;
import StacksAndQueues.QueueLinkedList;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestQueueLinkedList {

//    @Test
//    public void TestEmptyAdd()
//    {
//            QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
//       testQueue.enqueue(1);
//       assertEquals("PEEK == 1", testQueue.peek().intValue(), 1);
//    }
//
//    @Test
//    public void TestEmptyAdd2()
//    {
//        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
//        testQueue.enqueue(1);
//        testQueue.enqueue(4);
//        assertEquals("PEEK == 1", testQueue.peek().intValue(), 1);
//    }
////
//    @Test
//    public void TestEmptyAdd3()
//    {
//        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
//        testQueue.enqueue(1);
//        testQueue.enqueue(2);
//        testQueue.enqueue(3);
//        testQueue.enqueue(4);
//        testQueue.enqueue(5);
//        assertEquals("PEEK == 1", testQueue.peek().intValue(), 1);
//    }
//
//    @Test
//    public void TestEmptyAdd4()
//    {
//        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
//        testQueue.enqueue(1);
//        testQueue.enqueue(2);
//        testQueue.enqueue(3);
//        testQueue.enqueue(4);
//        testQueue.enqueue(5);
//        testQueue.enqueue(6);
//        testQueue.enqueue(7);
//        testQueue.enqueue(8);
//        testQueue.enqueue(9);
//        testQueue.enqueue(10);
//
//        System.out.println(testQueue.toString());
//
//        assertEquals("PEEK == 1", testQueue.peek().intValue(), 1);
//    }
//
//    @Test
//    public void TestEmptyAdd5()
//    {
//        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
//        testQueue.enqueue(1);
//        testQueue.enqueue(2);
//        testQueue.enqueue(3);
//        testQueue.enqueue(4);
//        testQueue.enqueue(5);
//        testQueue.enqueue(6);
//        testQueue.enqueue(7);
//        testQueue.enqueue(8);
//        testQueue.enqueue(9);
//        testQueue.enqueue(10);
//        testQueue.enqueue(11);
//        testQueue.enqueue(12);
//        testQueue.enqueue(13);
//
//        System.out.println(testQueue.toString());
//
//        assertEquals("PEEK == 1", testQueue.peek().intValue(), 1);
//    }
//
//    @Test
//    public void TestEmptyAddDel()
//    {
//        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
//        testQueue.enqueue(4);
//        testQueue.enqueue(2);
//        testQueue.enqueue(3);
//
////        System.out.println(testQueue.toString());
//
//        int shouldBe4 = testQueue.dequeue();
//        int shouldBe2 = testQueue.dequeue();
//
////        System.out.println("4=?: " + shouldBe4);
////        System.out.println("2=?: " + shouldBe2);
//
//        assertEquals("SHOULD BE 4 REMOVED" , shouldBe4, 4);
//        assertEquals("SHOULD BE 2 REMOVED" , shouldBe2, 2);
//
//        System.out.println(testQueue.toString());
//
//        assertEquals("PEEK == 3", testQueue.peek().intValue(), 3);
//    }
//
//    @Rule
//    public ExpectedException exception = ExpectedException.none();
//    @Test
//    public void TestEmptyAddDel2()
//    {
//        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
//        testQueue.enqueue(4);
//        testQueue.enqueue(2);
//        testQueue.enqueue(3);
//
////        System.out.println(testQueue.toString());
//
//        int shouldBe4 = testQueue.dequeue();
//        int shouldBe2 = testQueue.dequeue();
//
//
////        System.out.println(testQueue.toString());
//
//        int shouldBe3 = testQueue.dequeue();
//
////        System.out.println(testQueue.toString());
//
////        System.out.println("4=?: " + shouldBe4);
////        System.out.println("2=?: " + shouldBe2);
////
////        assertEquals("SHOULD BE 4 REMOVED" , shouldBe4, 4);
////        assertEquals("SHOULD BE 2 REMOVED" , shouldBe2, 2);
////        assertEquals("SHOULD BE 3 REMOVED" , shouldBe3, 3);
////        assertTrue("Should be empty : true", testQueue.isEmpty());
//
////        System.out.println(testQueue.toString());
//
//
//            assertTrue("List should be null", testQueue.isEmpty());
//
////        assertEquals("PEEK == 3", testQueue.peek().intValue(), 3);
//    }
//
//
//    @Test
//    public void TestEmptyAddDelAdd()
//    {
//        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
//        testQueue.enqueue(4);
//        testQueue.enqueue(2);
//        testQueue.enqueue(3);
//
////        System.out.println(testQueue.toString());
//
//        int shouldBe4 = testQueue.dequeue();
//        int shouldBe2 = testQueue.dequeue();
//        int shouldBe3 = testQueue.dequeue();
////        System.out.println("4=?: " + shouldBe4);
////        System.out.println("2=?: " + shouldBe2);
//
//        assertEquals("SHOULD BE 4 REMOVED" , shouldBe4, 4);
//        assertEquals("SHOULD BE 2 REMOVED" , shouldBe2, 2);
//        assertEquals("SHOULD BE 3 REMOVED" , shouldBe3, 3);
//        assertTrue("Should be empty : true", testQueue.isEmpty());
//
//        System.out.println(testQueue.toString());
//
//
//        testQueue.enqueue(5);
//        testQueue.enqueue(6);
//        testQueue.enqueue(7);
//        System.out.println(testQueue.toString());
//
//        assertEquals("PEEK == 5", testQueue.peek().intValue(), 5);
//    }
//
////
//    @Test
//    public void TestEmptyAddDelAdd2()
//    {
//        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
//        testQueue.enqueue(4);
//        testQueue.enqueue(2);
//        testQueue.enqueue(3);
//
////        System.out.println(testQueue.toString());
//
//        int shouldBe4 = testQueue.dequeue();
//        int shouldBe2 = testQueue.dequeue();
//        int shouldBe3 = testQueue.dequeue();
////        System.out.println("4=?: " + shouldBe4);
////        System.out.println("2=?: " + shouldBe2);
//
//        assertEquals("SHOULD BE 4 REMOVED" , shouldBe4, 4);
//        assertEquals("SHOULD BE 2 REMOVED" , shouldBe2, 2);
//        assertEquals("SHOULD BE 3 REMOVED" , shouldBe3, 3);
//        assertTrue("Should be empty : true", testQueue.isEmpty());
//
//        System.out.println(testQueue.toString());
//
//
//        testQueue.enqueue(1);
//        testQueue.enqueue(2);
//        testQueue.enqueue(3);
//        testQueue.enqueue(4);
//        testQueue.enqueue(5);
//        testQueue.enqueue(6);
//        testQueue.enqueue(7);
//        testQueue.enqueue(8);
//        testQueue.enqueue(9);
//
//        System.out.println(testQueue.toString());
//
//        assertEquals("SHOULD BE 1 REMOVED" , testQueue.dequeue().intValue(), 1);
//        assertEquals("SHOULD BE 2 REMOVED" , testQueue.dequeue().intValue(), 2);
//
//        System.out.println(testQueue.toString());
//
//
//
//        testQueue.enqueue(10);
//        testQueue.enqueue(11);
//
//        System.out.println(testQueue.toString());
//
//        testQueue.enqueue(12);
//
//        System.out.println(testQueue.toString());
//
////        testQueue.enqueue(13);
//
////        System.out.println(testQueue.toString());
//    }
//
//    @Test
//    public void TestEmptyPreExpand()
//    {
//        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();
//
//        testQueue.enqueue(1);
//        testQueue.enqueue(2);
//        testQueue.enqueue(3);
//        testQueue.enqueue(4);
//        testQueue.enqueue(5);
//        testQueue.enqueue(6);
//        testQueue.enqueue(7);
//        testQueue.enqueue(8);
//        testQueue.enqueue(9);
//
//        System.out.println(testQueue.toString());
//
//        assertEquals("SHOULD BE 1 REMOVED" , testQueue.dequeue().intValue(), 1);
//        assertEquals("SHOULD BE 2 REMOVED" , testQueue.dequeue().intValue(), 2);
//
//        System.out.println(testQueue.toString());
//
//
//
//        testQueue.enqueue(10);
//        testQueue.enqueue(11);
//
//        System.out.println(testQueue.toString());
//
//        testQueue.enqueue(12);
//
//        System.out.println(testQueue.toString());
//
//    }
////
    @Test
    public void TestEmptyPostExpand()
    {
        QueueLinkedList<Integer> testQueue = new QueueLinkedList<Integer>();

        testQueue.enqueue(1);
        testQueue.enqueue(2);
        testQueue.enqueue(3);
        testQueue.enqueue(4);
        testQueue.enqueue(5);
        testQueue.enqueue(6);
        testQueue.enqueue(7);
        testQueue.enqueue(8);
        testQueue.enqueue(9);

//        System.out.println(testQueue.toString());

//        assertEquals("SHOULD BE 1 REMOVED" , testQueue.dequeue().intValue(), 1);
//        assertEquals("SHOULD BE 2 REMOVED" , testQueue.dequeue().intValue(), 2);

//        System.out.println(testQueue.toString());



        testQueue.enqueue(10);
//        testQueue.enqueue(11);
//
        System.out.println(testQueue.toString());

//        testQueue.enqueue(12);

        testQueue.enqueue(11);
////
//        System.out.println(testQueue.toString());
////
////        testQueue.enqueue(13);



//
        System.out.println(testQueue.toString());
//        System.out.println(testQueue.toString());
//        System.out.println(testQueue.toString());
//        System.out.println(testQueue.toString());

//        assertArrayEquals(testQueue.getQueue(), new Integer[]{});

//        assertEquals("PEEK == 11", testQueue.peek().intValue(), 11);

    }

}