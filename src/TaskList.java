package ToDoListManager;

import java.io.Serializable;

public class TaskList implements Serializable {
    private static final long serialVersionUID = 1L;
    private Node head;

    private class Node implements Serializable {
        private static final long serialVersionUID = 1L;
        Task task;
        Node next;
        Node prev;

        Node(Task task) {
            this.task = task;
            this.next = null;
            this.prev = null;
        }
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void markTaskAsCompleted(int index) {
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        if (current != null) {
            current.task.markAsCompleted();
        }
    }

    public void deleteTask(int index) {
        if (head == null || index < 0) {
            return;
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    public void printTasks() {
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.task);
            current = current.next;
            index++;
        }
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }
}