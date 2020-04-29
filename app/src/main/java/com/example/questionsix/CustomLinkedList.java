package com.example.questionsix;

public class CustomLinkedList {
    Node head1, head2;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

        private int getCount(Node node) {
            Node curr = node;
            int c = 0;
            while (curr != null) {
                c++;
                curr = curr.next;
            }
            return c;
        }

        private int getIntersectionNode(int diff, Node nd1, Node nd2) {
            int i;
            Node curr1 = nd1;
            Node curr2 = nd2;
            for (i = 0; i < diff; i++) {
                if (curr1 == null) {
                    return -1;
                }
                curr1 = curr1.next;
            }
            while (curr1 != null && curr2 != null) {
                if (curr1.data == curr2.data) {
                    return curr1.data;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }

            return -1;
        }

        private int getNode() {
            int cOne = getCount(head1);
            int cTwo = getCount(head2);
            int diff;
            if (cOne > cTwo) {
                diff = cOne - cTwo;
                return getIntersectionNode(diff, head1, head2);
            } else {
                diff = cTwo - cOne;
                return getIntersectionNode(diff, head2, head1);
            }
        }

        private void removeDuplicates() {
            Node ptr1 = null;
            Node ptr2 = null;
            Node dup = null;

            while (ptr1 != null && ptr1.next != null) {
                ptr2 = ptr1;

                while (ptr2.next != null) {
                    if (ptr1.data == ptr2.next.data) {
                        dup = ptr2.next;
                        ptr2.next = ptr2.next.next;
                    } else {
                        ptr2 = ptr2.next;
                    }
                }
                ptr1 = ptr1.next;
            }
        }
    }
}
