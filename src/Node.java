package ToDoListManager;

public class Node {
    // Node class to represent a node in the linked list
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}