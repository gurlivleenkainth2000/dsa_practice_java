package org.example.linked_list_practice;

public class LLMain {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(1);
        singlyLinkedList.insert(2);
        singlyLinkedList.insert(3);
        singlyLinkedList.insert(4);
        singlyLinkedList.insert(5);

        singlyLinkedList.displayList();

        singlyLinkedList.insertAtHead(6);
        singlyLinkedList.displayList();

        singlyLinkedList.insertAtPosition(3, 10);
        singlyLinkedList.displayList();

        singlyLinkedList.remove();
        singlyLinkedList.displayList();

        singlyLinkedList.removeHead();
        singlyLinkedList.displayList();

        singlyLinkedList.removeAtPosition(2);
        singlyLinkedList.displayList();

    }
}
