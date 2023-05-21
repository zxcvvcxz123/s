package structures.doublylinkedlist;

public class DoublyLinkedList {
    Node head; // голова списка

    // Класс Node для каждого элемента списка
    class Node {
        int data;
        Node prev;
        Node next;

        // Конструктор Node
        Node(int d) {
            data = d;
        }
    }

    // Метод для добавления нового элемента в конец списка
    public void append(int newData) {
        Node newNode = new Node(newData);

        Node last = head;

        newNode.next = null;

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while (last.next != null)
            last = last.next;

        last.next = newNode;

        newNode.prev = last;
    }

    // Метод для вставки нового узла после заданного узла
    public void insertAfter(Node prevNode, int newData) {

        if (prevNode == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        Node newNode = new Node(newData);

        newNode.next = prevNode.next;

        prevNode.next = newNode;

        newNode.prev = prevNode;

        if (newNode.next != null)
            newNode.next.prev = newNode;
    }

    // Метод для удаления узла из списка по ключу
    public void deleteByKey(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                if (temp.next != null)
                    temp.next.prev = temp.prev;
                if (temp == head)
                    head = head.next;
            }
            temp = temp.next;
        }
    }

    // Метод для печати списка
    public void printList(Node node) {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(6);

        dll.append(7);

        dll.append(8);

        dll.append(9);

        dll.insertAfter(dll.head.next, 10);

        System.out.println("Doubly linked list after insertion: ");
        dll.printList(dll.head);

        dll.deleteByKey(8);

        System.out.println("\nDoubly linked list after deletion of key 8: ");
        dll.printList(dll.head);
    }

}