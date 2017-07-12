package LinkedList;

/*
    2.2
 */
public class KthToEndLinkedList {
    public static void main(String[] args) {

        LinkedList list = new LinkedList(99);
        list.add(100);
        list.add(101);
        list.add(102);
        list.add(103);
        list.add(104);
        list.add(105);
        list.add(106);
        list.add(107);
        list.add(108);
        list.add(109);
        list.add(110);
        list.add(111);
        list.add(112);
        list.add(113);
        list.add(114);
        list.add(115);
        list.add(116);
        list.add(117); // 5
        list.add(118); // 6
        list.add(119); // 5
        list.add(120); // 4
        list.add(121); // 3
        list.add(122); // 2
        list.add(123); // 1

        System.out.println(findKthNode(list.getHead(),6 ));

    }


    public static int findKthNode(LinkedList.Node head, int k)
    {
        if(head == null)
        {
            return 0;
        }
        else
        {
            int currentValue = findKthNode(head.getNext(), 6) + 1; // since if it returns 0 then + 1, 1th to last = last

            if(currentValue == k)
                System.out.println("Result: " + head.getData());
            return currentValue;
        }
    }




    private static class LinkedList {
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

        public LinkedList() {
            head = new Node();
            tail = head;
        }

        public LinkedList(int data) {
            head = new Node(data);
            tail = head;
        }

        // [1H]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10T]->null

        // [1HT]->null
        // [1H]->[2T]->null
        public void add(int data) {
            // [1HT]->null
            Node newNode = new Node(data);
            // [1HT]->[2]->null
            tail.setNext(newNode);
            // [1H]->[2T]->null
            tail = tail.getNext();
        }

        public void Test() {
            System.out.println("HEAD: " + head.getData());
            System.out.println("TAIL: " + tail.getData());
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            for (Node cur = head; cur != null; cur = cur.getNext()) {
                builder.append(cur.getData());
                builder.append(", ");
                // TODO fix end
            }

            return builder.toString();
        }

        private static class Node {

            private Node next;
            private int data;
            private Node tail;

            public Node() {
                this.data = -1;
                this.next = null;
//            this.tail = next;
            }

            public Node(int data) {
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
