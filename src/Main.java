package ToDoListManager;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();
    private static User currentUser = null;
    private static final String DATA_FILE = "users_data.ser";

    public static void main(String[] args) {
        loadUsers();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (currentUser == null) {
                displayUserMenu(scanner);
            } else {
                displayTaskMenu(scanner);
            }
        }
    }

    private static void displayUserMenu(Scanner scanner) {
        System.out.println("\n--- To-Do List Manager ---");
        System.out.println("1. Select User");
        System.out.println("2. Create New User");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");

        int option = getValidIntInput(scanner, 1, 3);
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                selectUser(scanner);
                break;
            case 2:
                createUser(scanner);
                break;
            case 3:
                saveUsers();
                System.out.println("Exiting...");
                System.exit(0);
        }
    }

    private static void displayTaskMenu(Scanner scanner) {
        System.out.println("\n--- " + currentUser.getName() + "'s To-Do List ---");
        System.out.println("1. Add Task");
        System.out.println("2. Mark Task as Completed");
        System.out.println("3. View Tasks");
        System.out.println("4. Delete Task");
        System.out.println("5. Switch User");
        System.out.print("Choose an option: ");

        int option = getValidIntInput(scanner, 1, 5);
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                addTask(scanner);
                break;
            case 2:
                markTaskAsCompleted(scanner);
                break;
            case 3:
                viewTasks();
                break;
            case 4:
                deleteTask(scanner);
                break;
            case 5:
                currentUser = null;
                saveUsers();
                break;
        }
    }

    private static void selectUser(Scanner scanner) {
        if (users.isEmpty()) {
            System.out.println("No users found. Please create a new user.");
            return;
        }

        System.out.println("Available users:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getName());
        }
        System.out.print("Enter the number of the user you want to select: ");
        int userIndex = getValidIntInput(scanner, 1, users.size()) - 1;
        currentUser = users.get(userIndex);
        System.out.println("User selected: " + currentUser.getName());
    }

    private static void createUser(Scanner scanner) {
        System.out.print("Enter new user name: ");
        String name = scanner.nextLine().trim();
        User newUser = new User(name);
        users.add(newUser);
        currentUser = newUser;
        System.out.println("User created: " + name);
        saveUsers();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();
        currentUser.addTask(description);
        System.out.println("Task added: " + description);
        saveUsers();
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        viewTasks();
        System.out.print("Enter the number of the task to mark as completed: ");
        int taskIndex = getValidIntInput(scanner, 1, Integer.MAX_VALUE) - 1;
        currentUser.markTaskAsCompleted(taskIndex);
        saveUsers();
    }

    private static void viewTasks() {
        currentUser.printTasks();
    }

    private static void deleteTask(Scanner scanner) {
        viewTasks();
        System.out.print("Enter the number of the task to delete: ");
        int taskIndex = getValidIntInput(scanner, 1, Integer.MAX_VALUE) - 1;
        currentUser.deleteTask(taskIndex);
        saveUsers();
    }

    private static int getValidIntInput(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= min && (input <= max || max == Integer.MAX_VALUE)) {
                    return input;
                }
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(users);
            System.out.println("User data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadUsers() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                users = (ArrayList<User>) ois.readObject();
                System.out.println("User data loaded successfully.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading user data: " + e.getMessage());
            }
        }
    }
}