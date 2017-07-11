package io.tanners.LinkedList;

import java.util.LinkedList;

/*
    this assumes a string that does not have spaces at start, end or anything above a single space between chars

    2.6
 */

public class PalindromeLinkedList
{
    public static void main(String[] args)
    {
//        java.util.LinkedList<Integer> test = new java.util.LinkedList<Integer>();
//
//        test.add(1);
//        test.add(2);
//        test.add(3);
//
//        System.out.println(test.toString());

        // should work with stuff like
        //         A Santa at Nasa
        // but main focus is stuff like
        // bob (odd) , boob (even), dod (odd), Aeratepetarea (13 char, odd), alula (odd),
        // cat, dog, doog, hello, this should not work, hello a olleh

        LinkedList list1 = new LinkedList("bob");
        LinkedList list2 = new LinkedList("boob");
        LinkedList list3 = new LinkedList("dod");
        LinkedList list4 = new LinkedList("Aeratepetarea");
        LinkedList list5 = new LinkedList("alula");
        LinkedList list6 = new LinkedList("Amen icy cinema");
        LinkedList list7 = new LinkedList("cat");
        LinkedList list8 = new LinkedList("dog");
        LinkedList list9 = new LinkedList("doog");
        LinkedList list10 = new LinkedList("hello");
        LinkedList list11 = new LinkedList("this should not work");
        LinkedList list12 = new LinkedList("hello a olleh");

        System.out.println("LIST 1: " + palindromeV2(list1));
        System.out.println("LIST 2: " + palindromeV2(list2));
        System.out.println("LIST 3: " + palindromeV2(list3));
        System.out.println("LIST 4: " + palindromeV2(list4));
        System.out.println("LIST 5: " + palindromeV2(list5));
        System.out.println("LIST 6: " + palindromeV2(list6));
        System.out.println("LIST 7: " + palindromeV2(list7));
        System.out.println("LIST 8: " + palindromeV2(list8));
        System.out.println("LIST 9: " + palindromeV2(list9));
        System.out.println("LIST 10: " + palindromeV2(list10));
        System.out.println("LIST 11: " + palindromeV2(list11));
        System.out.println("LIST 12: " + palindromeV2(list12));


        System.out.println();
        System.out.println();


        System.out.println("LIST 1: " + palindromeV1(list1.head));
        System.out.println("LIST 2: " + palindromeV1(list2.head));
        System.out.println("LIST 3: " + palindromeV1(list3.head));
        System.out.println("LIST 4: " + palindromeV1(list4.head));
        System.out.println("LIST 5: " + palindromeV1(list5.head));
        System.out.println("LIST 6: " + palindromeV1(list6.head));
        System.out.println("LIST 7: " + palindromeV1(list7.head));
        System.out.println("LIST 8: " + palindromeV1(list8.head));
        System.out.println("LIST 9: " + palindromeV1(list9.head));
        System.out.println("LIST 10: " + palindromeV1(list10.head));
        System.out.println("LIST 11: " + palindromeV1(list11.head));
        System.out.println("LIST 12: " + palindromeV1(list12.head));


    }


    public static boolean palindromeV1(Node next)
    {
        Node head = next;

        // if null (if anything goes wrong, nul is returned)
        if(palindromeV1(next, head) == null)
            return false;
        else
            return true;

    }

    /*
        think of this, we have head of list and at end of recursive call, we have end of list
        as the list backtracks in recursive calls, it checks with head, head.next, head.next.next and so on
        we use null as a our boolean value since we want a way to pas back head.next.... to the previous call, so we use
        it as the return value
     */
    public static Node palindromeV1(Node next, Node head)
    {
        // end case
        if(next == null)
        {
            return head;
        }
        else
        {
            Node result = palindromeV1(next.next, head);

            // if result is null, basically, a way to do boolean but since we only return one value
            // at a time this is my little trick
            if(result == null) {
//                System.out.println("Debug 3");
                // this should pass down to end to show null as final return value which means not a palindrome
                return null;
            }
            // not null, so check between values can continue
            else
            {
                // check if white space for the next node
                if(Character.isWhitespace(next.data))
                {
                    // little trick to handle white space, bascially, jsut return a none null node
                    // and the recursion will continue
                    return result;
                }
                else if (Character.isWhitespace(result.data))
                {
                    // fix to find next none whitespace node
                    while(Character.isWhitespace(result.data)) {
                        // set it so the recursion can continue like if the white space node never existed
                        result = result.next;
                    }
                }
                // if the nodes have same char
                if(Character.toLowerCase(result.data) == Character.toLowerCase(next.data))
                {
                    // this is only bad part, at end of palindrome
                    // the .next will be null so we check for this
                    if(result.next == null)
                        return result;
                    // else return next value
                    else
                        return result.next;
                }
                // not a palindrome so return null
                else
                {
                    return null;
                }
            }
        }

    }

    public static boolean palindromeV2(LinkedList list)
    {
        // get tail and head of nodes
        Node head = list.head;
        Node tail = list.tail;
        // make sure head or tail is not null
        // only time either is null is if node was never added
        while(head != null && tail != null)
        {
            // this check takes into account white space
            // head is pointing to white space
            if(Character.isWhitespace(head.data))
            {
                // this program assumes at most, one whitespace
                // so we simple skip the white space
                head = head.next;
            }
            // this check takes into account white space
            // tail is pointing to white space
            else if (Character.isWhitespace(tail.data))
            {
                // this program assumes at most, one whitespace
                // so we simple skip the white space (tail skips in reverse)
                tail = tail.prev;
            }
            else
            {
                // if data on both tail and head do not match, it is not a palindrome
                if(Character.toLowerCase(head.data) != Character.toLowerCase(tail.data))
                {
                    return false;
                }
                // data matches in current iteration
                else
                {
                    // if head and tail point to same spot
                    // it should be the mid point so values should be equal
                    // this would stop after going over all data once vs going over it a second time
                    // when head and tail pass
                    if(head == tail)
                        return true;
                    // head and tail are not on same position
                    else
                    {
                        // iterate through both memory references (forward and back)
                        head = head.next;
                        tail = tail.next;
                    }
                }
            }
        }
        // get to end of linkedlist without any problems
        // it is a palindrome
        return true;
    }

    private static class Node
    {
        char data;
        Node next;
        Node prev;

        public Node(char data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private static class LinkedList
    {
        public Node head;
        public Node tail;

        public LinkedList() {
            head = null;
            tail = head;
        }

        public LinkedList(char data) {
            head = new Node(data);
            head = null;
            tail = head;
        }

        public LinkedList(String data)
        {
            for(char input : data.toCharArray())
            {
                this.addFont(input);
            }

        }

        public void addFont(char data) {

            Node newNode = new Node(data);

            if(tail == null)
            {
                tail = newNode;
                head = newNode;
            }
            else
            {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        public void addBack(char data) {
            Node newNode = new Node(data);

            if(head == null)
            {
                tail = newNode;
                head = newNode;
            }
            else
            {
                newNode.next = head;
                head = newNode;
                newNode.prev = null;
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
            }

            return builder.toString();
        }

        public String toStringReverse() {
            StringBuilder builder = new StringBuilder();

            for (Node cur = tail; cur != null; cur = cur.prev) {

                if(cur.prev == null)
                    builder.append(cur.data);
                else {
                    builder.append(cur.data);
                    builder.append(", ");
                }
            }

            return builder.toString();
        }
    }
}
