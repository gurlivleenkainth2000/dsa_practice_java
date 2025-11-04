package org.example.linked_list_practice;

public class ReverseLinkedList {
    static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode current = head;
        ListNode newHeadNode = null;

        while (current != null) {
            ListNode newNode = new ListNode(current.val);
            newNode.next = newHeadNode;
            newHeadNode = newNode;

            current = current.next;
        }

        return newHeadNode;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(1){{
            insert(2);
            insert(3);
            insert(4);
            insert(5);
        }};

        System.out.println("Printing List Before Reverse List");
        list.displayList();

        ListNode reversedListNode = ReverseLinkedList.reverseList(list.head);
        list.tail = list.head;
        list.head = reversedListNode;

        System.out.println("Printing List After Reversing List");
        list.displayList();
    }
}
