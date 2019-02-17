public class LinkedListOperations {

    public static Node reverseLinkedList(Node head){

        Node head2 = null;

        while(head != null){
            Node temp = head2;
            head2 = head;

            head = head.next;
            head2.next = temp;
        }

        return head2;
    }

    public static void printList(Node head){

        System.out.println("Printing the list.");

        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args){

        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();

        n1.data = 1;
        n1.next = n2;

        n2.data = 2;
        n2.next = n3;

        n3.data = 3;
        n3.next = n4;

        n4.data = 4;
        n4.next = null;

        Node head = reverseLinkedList(n1);

        printList(head);

        printList(reverseLinkedList(null));

    }
}

class Node{

    Node next;
    int data;
}