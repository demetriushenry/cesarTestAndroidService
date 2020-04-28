package com.example.questionsix;

public class CustomLinkedList {
    Node head;

    class Node {
        CustomEmail data;
        Node next;

        Node(CustomEmail data) {
            this.data = data;
            next = null;
        }

        public void removeDuplicates() {
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
