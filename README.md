# To-Do List Manager

## Project Description
This To-Do List Manager is a Java-based console application developed as part of the Semester 4 Data Structures & Algorithms Midterm Sprint at Keyin College. It demonstrates the use of arrays and single linked lists in Java, allowing users to create and manage their to-do lists with persistent data storage.

## Project Information
- Course: Semester 4 Data Structures & Algorithms
- Assignment: Midterm Sprint
- Student: Brenda Armstrong
- Institution: SD10 Keyin College

## GitHub Repository
https://github.com/brendaleearmstrong/ToDoListManager

## Project Requirements

### Project Title: To-Do List Manager

### Description
The goal of this project is to create a simple to-do list manager where users can add tasks, mark tasks as completed, and view their list of tasks. Each user has their own to-do list, and each to-do list is represented as a single linked list of tasks. The users are stored in an array.

### Expectations and Functionalities

1. User Management:
   - Ability to create users and store them in an array.
   - Each user has a unique name.

2. Task Management:
   - Ability to add tasks to a user's to-do list.
   - Each task has a description and a completion status (completed or pending).
   - Tasks are stored in a single linked list for each user.

3. Mark Tasks as Completed:
   - Ability to mark a task as completed by updating its completion status.

4. View Tasks:
   - Ability to view all tasks in a user's to-do list, along with their completion status.

### Implementation Details

1. Task class:
   - Stores the description and completion status of a task.
   - Includes a method to mark a task as completed.

2. User class:
   - Stores the name of the user and their to-do list (a single linked list of tasks).
   - Includes methods to add a task, mark a task as completed, and print all tasks.

3. TaskList class (single linked list):
   - Represents the to-do list for a user.
   - Includes methods to add a task, mark a task as completed, and print all tasks.

4. Main class:
   - Creates users and adds them to an array.
   - Adds tasks to users' to-do lists.
   - Marks tasks as completed.
   - Prints all tasks for each user.

## Additional Features Implemented

In addition to meeting the basic requirements, this implementation includes:

1. Delete Tasks:
   - Ability to delete a task from a user's to-do list.

2. Data Persistence:
   - User data and tasks are saved between program executions.

3. User-friendly Interface:
   - Menu-driven console interface for easy navigation.

4. Error Handling and Input Validation:
   - Robust error handling to prevent crashes and improve user experience.

## How to Use

1. Compile all Java files in the `ToDoListManager` package.
2. Run the `Main` class to start the To-Do List Manager.
3. Follow the on-screen prompts to:
   - Create a new user
   - Select an existing user
   - Add tasks
   - Mark tasks as completed
   - View tasks
   - Delete tasks
   - Switch between users
   - Exit the program

## Implementation Details

- `Main.java`: The main class that runs the program and handles user interaction.
- `User.java`: Represents a user and their task list.
- `TaskList.java`: Implements the linked list structure to store tasks.
- `Task.java`: Represents an individual task.
- `Node.java`: Represents a node in the linked list.

## Development

This project was developed using Java and demonstrates the use of:
- Arrays for storing users
- Linked lists for storing tasks
- File I/O for data persistence
- Object-Oriented Programming principles
