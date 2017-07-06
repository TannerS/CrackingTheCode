package io.tanners.LinkedList;

// TODO based on solution, had problems with question format
public class ParitionLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(99);

        list.addFont(5);
        list.addFont(8);
        list.addFont(6);
        list.addFont(8);
        list.addFont(3);
        list.addBack(9);
        list.addBack(10);
        list.addBack(11);
        list.addBack(12);
        list.addBack(13);
        list.addFont(1);
        list.addFont(0);
        list.addFont(0);

        System.out.println(list.toString());



        list.head = partition(list.head, 9);


        System.out.println(list.toString());

    }

    // TODO redo this problem but linkedlist that can do prev and next

    // this assumes linked list node with just "next"
    public static LinkedList.Node partition(LinkedList.Node node, int value)
    {
        LinkedList.Node head = node;
        LinkedList.Node tail = node;

        while(node != null)
        {
            LinkedList.Node next = node.next;

//            System.out.println("DEBUG: " + head.data);
            // if node value is less then value
            if(node.data < value)
            {
//                System.out.println("DEBUG 2: " + head.data);
                // set current node to start of start node
//                LinkedList.Node temp = cur.next;
                node.next = head;
                head = node;

//                System.out.println("DEBUG 3: " + head.data);
            }
            else
            {
//                System.out.println("DEBUG 4");
                tail.next = node;
                tail = node;
            }



            node = next;
        }

        tail.next = null;

        return head;
    }

    private static class LinkedList {
        public Node head;
        public Node tail;


        public LinkedList() {
            head = new Node();
            head = null;
            tail = null;
        }

        public LinkedList(int data) {
            head = new Node(data);
            head = null;
            tail = null;
        }

        // [1H]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10T]->null

        // [1HT]->null
        // [1H]->[2T]->null
        public void addFont(int data) {
            // [1HT]->null
            Node newNode = new Node(data);
            // [1HT]->[2]->null

            if(tail == null)
            {
                tail = newNode;
                head = newNode;
            }
            else
            {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public void addBack(int data) {
            Node newNode = new Node(data);

            newNode.next = head;

            head = newNode;

            if(tail == null)
            {
                tail = newNode;
                head = newNode;
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            for (Node cur = head; cur != null; cur = cur.next) {

                if(cur.next == null)
                    builder.append(cur.data);
                else {
                    builder.append(cur.data);
                    builder.append(", ");
                }
                // TODO fix end
            }

            return builder.toString();
        }

        private static class Node {

            public Node next;
//            public Node prev;
            public int data;
//            public Node tail;

            public Node() {
                this.data = -1;
                this.next = null;
//                this.prev = null;
            }

            public Node(int data) {
                this.data = data;
                this.next = null;
//                this.prev = null;
//            this.tail = next;
            }
        }
    }
}
