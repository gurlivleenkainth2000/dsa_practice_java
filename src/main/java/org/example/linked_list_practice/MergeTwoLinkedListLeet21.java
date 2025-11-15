package org.example.linked_list_practice;

public class MergeTwoLinkedListLeet21 {
    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode headNode = list1;
        if (list1 == null) {
            headNode = list2;
        }
        if (list1.val < list2.val) {
            headNode = list1;
            list1 = list1.next;
        } else {
            headNode = list2;
            list2 = list2.next;
        }

        ListNode currentNode = headNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }

        if (list1 != null) {
            currentNode.next = list1;
        } else {
            currentNode.next = list2;
        }

        return headNode;
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList(1){{
            insert(2);
            insert(4);
        }};
        SinglyLinkedList list2 = new SinglyLinkedList(0);
//        {{
//            insert(3);
//            insert(4);
//        }};

        list1.displayList();
        list2.displayList();

        MergeTwoLinkedListLeet21 leet21 = new MergeTwoLinkedListLeet21();
        ListNode newListHead = leet21.mergeTwoLists(null, list2.head);

        list1.displayList(newListHead);
    }
}
