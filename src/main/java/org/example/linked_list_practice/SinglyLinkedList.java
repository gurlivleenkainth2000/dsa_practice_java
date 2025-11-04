package org.example.linked_list_practice;

/*
 * A simple implementation of a singly linked list that supports
 * insertion at the head, tail, and any given position.
 *
 * Each node contains an integer value and a pointer to the next node.
 * The list also maintains both head and tail references for efficiency.
 */
public class SinglyLinkedList {
    ListNode head = null;
    ListNode tail = null;

    /*
     * Default constructor.
     * Creates a linked list initialized with one node containing value -1.
     */
    SinglyLinkedList() {
        this(-1);
    }

    /*
     * Parameterized constructor.
     * Creates a linked list initialized with a single node containing the given value.
     */
    SinglyLinkedList(int value) {
        // Create the first node
        ListNode newNode = new ListNode(value);
        // Assign both head and tail to this node
        this.head = newNode;
        this.tail = newNode;
    }

    /*
     * Displays the linked list starting from the head node.
     * Calls the helper function to handle the printing logic.
     */
    public void displayList() {
        this.displayList(this.head);
    }

    /*
     * Displays the linked list starting from a given node reference.
     */
    public void displayList(ListNode head) {
        // Start traversing from the given head
        ListNode current = head;
        // Loop until the end of the list
        while (current != null) {
            // Print the current node’s value
            System.out.print(current.val);
            // Print an arrow if there is a next node
            if (current.next != null) System.out.print(" -> ");
            // Move to the next node
            current = current.next;
        }
        System.out.println();
    }

    /*
     * Inserts a new node with the specified value at the tail of the list.
     */
    public void insert(int val) {
        // Create a new node
        ListNode newNode = new ListNode(val);
        // Link the current tail to the new node
        this.tail.next = newNode;
        // Update the tail reference
        this.tail = newNode;
    }

    /*
     * Inserts a new node with the specified value at the head of the list.
     */
    public void insertAtHead(int val) {
        // Create a new node
        ListNode newNode = new ListNode(val);
        // Point new node’s next to the current head
        newNode.next = this.head;
        // Update head to the new node
        this.head = newNode;
    }

    /*
     * Inserts a new node at a specific position in the list.
     *
     * If position == 0, inserts at the head.
     * If position == -1, inserts at the tail.
     * Otherwise, inserts before the node currently at the given index.
     */
    public void insertAtPosition(int position, int value) {
        // Special case: insert at the head
        if (position == 0) {
            this.insertAtHead(value);
            return;
        }

        // Special case: insert at the tail
        if (position == -1) {
            this.insert(value);
            return;
        }

        // Track current index and node
        int currentPos = 0;
        ListNode current = this.head;
        ListNode nextNode = null;
        ListNode prevNode = null;

        // Traverse until we reach the position before insertion point
        while (current != null) {
            if ((currentPos + 1) == position) {
                // Found the previous node and the next node
                nextNode = current.next;
                prevNode = current;
                break;
            }
            currentPos++;
            current = current.next;
        }

        // Create the new node to insert
        ListNode newNode = new ListNode(value);
        // Point new node’s next to the nextNode
        newNode.next = nextNode;
        // Link the previous node to the new node
        prevNode.next = newNode;
    }

    /*
     * Removes the first (head) node from the linked list.
     * If the list is empty, it does nothing.
     */
    public void removeHead() {
        // Check if the list is empty
        if (this.head == null) {
            System.out.println("List is already empty.");
            return;
        }

        // Store current head temporarily (optional, for clarity)
        ListNode temp = this.head;

        // Move head pointer to the next node
        this.head = temp.next;

        // If list becomes empty after removal, update tail to null
        if (this.head == null) {
            this.tail = null;
        }
    }

    /*
     * Removes the last (tail) node from the linked list.
     * If the list is empty, does nothing.
     */
    public void remove() {
        // Case 1: Empty list
        if (this.head == null) {
            System.out.println("List is already empty.");
            return;
        }

        // Case 2: Only one element in the list
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
            return;
        }

        ListNode current = this.head;
        while (current.next != null && current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        this.tail = current;
    }

    /*
     * Removes a node at a specific position in the linked list.
     *
     * If position == 0, removes the head.
     * If position == -1, removes the tail.
     * Otherwise, removes the node before the given index (0-based).
     */
    public void removeAtPosition(int position) {
        // Check if the list is empty
        if (this.head == null) {
            System.out.println("List is already empty.");
            return;
        }

        if (position == 0) {
            this.removeHead();
            return;
        }

        if (position == -1) {
            this.remove();
            return;
        }

        int currentPos = 0;
        ListNode currentNode = this.head;

        while (currentNode != null) {
            if ((currentPos + 1) == position && currentNode.next != null) {
                ListNode nodeToRemove = currentNode.next;
                currentNode.next = nodeToRemove.next;
                if (currentNode.next == null) {
                    this.tail = currentNode;
                }

                nodeToRemove.next = null;
                break;
            }

            currentPos++;
            currentNode = currentNode.next;
        }
    }
}
