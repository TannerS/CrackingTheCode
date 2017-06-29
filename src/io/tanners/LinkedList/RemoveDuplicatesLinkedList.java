package io.tanners.LinkedList;

/*
    2.1
 */
public class RemoveDuplicatesLinkedList {
    public static void main(String[] args) {

        LinkedList list = new LinkedList(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(8);
        list.add(9);
        list.add(9);
        list.add(10);
        list.add(199);
        list.add(1);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        list.add(8);
        list.add(199) ;
        list.add(199) ;

        System.out.println("DISPLAY ORIGINAL");
        System.out.println(list.toString());
        list.Test();
        System.out.println("REMOVE DUPS");
        list.removeDups();
        System.out.println("DISPLAY NEW");
        System.out.println(list.toString());
        list.Test();



    }

    /*

    cur = !
    runner = *

    Started at first node, run through all nodes removing the duplicates

    [1!]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10]->null
    [1!]->[2*]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10]->null
    [1!]->[2]->[3*]->[4]->[5]->[6]->[7]->[8]->[9]->[10]->null
    [1!]->[2]->[3]->[4*]->[5]->[6]->[7]->[8]->[9]->[10]->null
    [1!]->[2]->[3]->[4]->[5*]->[6]->[7]->[8]->[9]->[10]->null
    [1!]->[2]->[3]->[4]->[5]->[6*]->[7]->[8]->[9]->[10]->null
    [1!]->[2]->[3]->[4]->[5]->[6]->[7*]->[8]->[9]->[10]->null
    [1!]->[2]->[3]->[4]->[5]->[6]->[7]->[8*]->[9]->[10]->null
    [1!]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9*]->[10]->null
    [1!]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10*]->null
    [1!]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10*]->null*

    Progress head node up by one, repeat process, remove all duplicates

    [1]->[2!]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10]->null
    [1!]->[2]->[3*]->[4]->[5]->[6]->[7]->[8]->[9]->[10]->null
    [1!]->[2]->[3]->[4*]->[5]->[6]->[7]->[8]->[9]->[10]->null
    [1!]->[2]->[3]->[4]->[5*]->[6]->[7]->[8]->[9]->[10]->null
    [1!]->[2]->[3]->[4]->[5]->[6*]->[7]->[8]->[9]->[10]->null
    [1!]->[2]->[3]->[4]->[5]->[6]->[7*]->[8]->[9]->[10]->null
    [1!]->[2]->[3]->[4]->[5]->[6]->[7]->[8*]->[9]->[10]->null
    [1!]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9*]->[10]->null
    [1!]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10*]->null
    [1!]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10*]->null*
     */

    private static class LinkedList
    {
        Node head;
        Node tail;

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getTail() {
            return tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public LinkedList()
        {
            head = new Node();
            tail = head;
        }

        public LinkedList(int data)
        {
            head = new Node(data);
            tail = head;
        }

        // [1H]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10T]->null

        // [1HT]->null
        // [1H]->[2T]->null
        public void add(int data)
        {
            // [1HT]->null
            Node newNode = new Node(data);
            // [1HT]->[2]->null
            tail.setNext(newNode);
            // [1H]->[2T]->null
            tail = tail.getNext();
        }

        public void Test()
        {
            System.out.println("HEAD: " + head.getData());
            System.out.println("TAIL: " + tail.getData());
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            for(Node cur = head; cur != null; cur = cur.getNext()) {
                builder.append(cur.data);
                builder.append(", ");
                // TODO fix end
            }

            return builder.toString();
        }

        public void removeDups()
        {
            Node cur = null;

            for(cur = head; cur != null; cur = cur.getNext())
            {
                int currentData = cur.getData();

                // used to check for end of list, simply to fix tail
                if(cur.getNext() != null)
                {
                    // loop all nodes
                    for (Node runner = cur.getNext(); runner != null; runner = runner.getNext()) {
                        // this explains the following if statement below
                        // C = cur
                        // H = runner
                        // [1CR]->[1]->[5]->[4]->[5]->[6]->null: runner = cur.next, and both have same value
                        // [1]->[1H]->[5C]->[4]->[5]->[6]->null: Then we must set cur to skip over it
                        // [1]->[1]->[5HC]->[4]->[5]->[6]->null: now we make sure it resets and the runner can go
                        if (currentData == runner.getData()) {
                            cur.setNext(cur.getNext());
                            runner = cur;
                        }

                        if(runner.getNext() != null)
                        {
                            // set cur to next node after duplicate node
                            // [1]->[1]->[5C]->[4]->[5]->[6]->null
                            // [1]->[1]->[5]->[4H]->[5]->[6]->null
                            // [1]->[1]->[5]->[4]->->[6H]->null
                            if (currentData == runner.getNext().getData()) {
                                runner.setNext(runner.getNext().getNext());
                            }
                        }
                    }
                }
                else {
                    // fix the tail, this would not be needed ifn ot for the add function really
                    tail = cur;
                }
            }
        }

        private static class Node{

            private Node next;
            private int data;
            private Node tail;

            public Node()
            {
                this.data = -1;
                this.next = null;
//            this.tail = next;
            }

            public Node(int data)
            {
                this.data = data;
                this.next = null;
//            this.tail = next;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }
        }
    }
}
