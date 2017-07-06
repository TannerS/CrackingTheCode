package io.tanners.LinkedList;

/*
    2.3
 */
public class DeleteMiddleNodeLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(99); // 1 a
        list.add(100);// 2 b
        list.add(101);// 3 c
        list.add(102);// 4 d
        list.add(103);// 5 e
        list.add(104);// 6 f
        list.add(105);// 7
        list.add(106);// 8
        list.add(107);// 9
        list.add(108);// 10
        list.add(109);// 11
        list.add(110);// 12
        list.add(111);// 13 - mid?
        list.add(112);// 14
        list.add(113);// 15
        list.add(114);// 16
        list.add(115);// 17
        list.add(116);// 18
        list.add(117); // 19
        list.add(118); // 20
        list.add(119); // 21
        list.add(120); // 22
        list.add(121); // 23
        list.add(122); // 24
        list.add(123); // 25
        list.add(124); // 26


        deleteMiddle(list.getHead());
    }

    public static LinkedList.Node deleteMiddle(LinkedList.Node head)
    {
        if(head.getNext() != null) {

            /*
                      p1
                a1 -> a2 -> b1 -> b2
                p2

                                  p1
                a1 -> a2 -> b1 -> b2
                      p2



             */
            for (LinkedList.Node cur = head, runner = head.getNext(); cur != null; cur = cur.getNext()) {
                // when cur is null, runner is middle
                if (runner.getNext() == null) {
                    System.out.println("MID: " + cur.getData());
                    break;
                } else {
                    runner = runner.getNext().getNext();


                }
            }
        }

        return null;

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
