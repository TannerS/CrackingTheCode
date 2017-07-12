package LinkedList;

/*
    TODO finish part b
    2.5
 */
public class SumListLinkedList {
    public static void main(String[] args) {

    LinkedList listOne = new LinkedList();
        listOne.addFont(7);
        listOne.addFont(1);
        listOne.addFont(6);
//
// LinkedList listOne = new LinkedList();
//        listOne.addFont(6);
//        listOne.addFont(1);
//        listOne.addFont(7);

        LinkedList listTwo = new LinkedList();
        listTwo.addFont(5);
        listTwo.addFont(9);
        listTwo.addFont(2);
//
//
// LinkedList listTwo = new LinkedList();
//        listTwo.addFont(2);
//        listTwo.addFont(9);
//        listTwo.addFont(5);


        System.out.println(listOne.toString());
        System.out.println(listTwo.toString());


       sumList(listOne.head, listTwo.head);





//        System.out.println(powersOfTenCalc(value));


    }


//    public static LinkedList.Node countInts(int value)
//    {
////        return powersOfTenCalc(value);
//        return null;
//    }

//    private static int powersOfTenCalc(int value)
//    {
//        return powersOfTenCalc(value, 1);
//    }
//
//    private static int powersOfTenCalc(int value, int powerOfTen)
//    {
//
//        if(value == 0)
//        {
//            return 0;
//        }
//        else
//        {
//            powersOfTenCalc(value / powerOfTen,powerOfTen * 10);
//
//            System.out.println(value / powerOfTen);
//            System.out.println(powerOfTen);
//            System.out.println(value);
//            System.out.println();
//            return value / powerOfTen;
//        }
//
//    }

    private static LinkedList.Node reverseCount(int value)
    {
        LinkedList.Node newNode = null;
        LinkedList.Node head = newNode;

        int temp = value;

        do {

            if(newNode == null)
            {
                newNode = new LinkedList.Node(temp % 10);
                head = newNode;
            }
            else
            {
                LinkedList.Node newerNode = new LinkedList.Node(temp % 10);
                newNode.next = newerNode;
                newNode = newNode.next;
            }

            temp /= 10;

        }while(temp > 0);

        return head;
    }

    public static int countList(LinkedList.Node node)
    {
        return count(node, 1);
    }

    private static int count(LinkedList.Node node, int count)
    {

        if(node == null) {

            return 0;
        }
        else {
            return (node.data * count) + count(node.next, (count * 10));
        }
    }

//
//    public static int countListReverse(LinkedList.Node node)
//    {
//
//
//
//        return countReverse(node, 0);
//    }

//    private static int countReverse(LinkedList.Node node1, LinkedList.Node node2, int count)
//    {
//        if(node == null) {
//            return 10;
//        }
//        else {
//
//
//
//
////            int temp2 = node.data *
////            return (node.data * count) + count(node.next, (count * 10));
////            int funcRESULT = countReverse(node.next, ++nextcount);
////
////            System.out.println("FUNC RETURN " + (funcRESULT * count));
////            System.out.println(" count " + count);
////            System.out.println();
////            System.out.println("DATA: " + node.data);
////            System.out.println("RESULT: " + node.data +funcRESULT);
//////            System.out.println("RESULT: " +node.data * countReverse(node.next,0));
////            System.out.println();
////            System.out.println();
////
////            int partial = count * node.data * funcRESULT;
////            int result = node.data * count;
////
////            System.out.println("!!!: " + ((node.data * count) + funcRESULT));
//
////            int temp = funcRESULT * node.data;
//
//            return 0;
////            return node.data * countReverse(node.next,0);
//        }
//    }


    private static LinkedList.Node sumList(LinkedList.Node listOne, LinkedList.Node listTwo)
    {
        int partialOne = countList(listOne);
        int partialTwo = countList(listTwo);

//        int partialOneV2 = countListReverse(listOne);

//        System.out.println(partialOneV2);

//        int partialTwoV2 = countListReverse(listTwo);
//
//                System.out.println(partialOneV2);
//                System.out.println(partialTwoV2);


        LinkedList.Node sumNode = reverseCount(partialOne + partialTwo);
//
        LinkedList sumLinkedList = new LinkedList();

        sumLinkedList.head = sumNode;

        System.out.println(sumLinkedList.toString());

        System.out.println();



        return null;
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

        public void addFont(int data) {
            Node newNode = new Node(data);

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
            public int data;

            public Node() {
                this.data = -1;
                this.next = null;
            }

            public Node(int data) {
                this.data = data;
                this.next = null;

            }
        }
    }
}
