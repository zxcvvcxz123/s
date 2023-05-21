package structures.linkedlist;

public class LinkedList {
    Node head; // голова списка

    // Класс Node для каждого элемента списка
    static class Node {
        int data;
        Node next;

        // Конструктор Node
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Метод для добавления нового элемента в конец списка
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = new Node(data);
            return;
        }

        newNode.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = newNode;
    }

    // Метод для вставки нового элемента в указанную позицию
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Метод для удаления элемента по ключу
    public void deleteByKey(int key) {
        Node temp = head, prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next; // Измененный головной элемент
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;
    }

    // Метод для удаления всех элементов по ключу
    public void deleteAllByKey(int key) {
        Node temp = head, prev = null;

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        while (temp != null) {
            if (temp.data == key) {
                if (prev == null) {
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                }
            } else {
                prev = temp;
            }

            temp = temp.next;
        }
    }

    // Метод для печати списка
    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.insertAfter(list.head.next, 4);
        System.out.println("Linked list after insertion: ");
        list.printList();

        list.deleteByKey(1);
        System.out.println("\nLinked list after deletion of key 1: ");
        list.printList();
    }
}