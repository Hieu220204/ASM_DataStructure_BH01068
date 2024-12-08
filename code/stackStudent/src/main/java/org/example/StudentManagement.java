package org.example;

public class StudentManagement {
    private StudentStack studentStack;

    public StudentManagement() {
        studentStack = new StudentStack();
    }

    public void addStudent(Student student) {
        studentStack.push(student);
    }

    public void updateStudent(int id, String newName, double newMark) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                student.setName(newName);
                student.setScore(newMark);
                found = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Not found student with id: " + id);
        }
    }

    public void deleteStudentByID(int id) {
        if (studentStack.isEmpty()) {
            System.out.println("Stack is empty. No students to delete.");
            return;
        }
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                found = true;
                System.out.println("Deleted student: " + student);
            } else {
                tempStack.push(student);
            }
        }
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
        if (!found) {
            System.out.println("Not found student with id: " + id);
        }
    }

    public void sortByMark() {
        if (studentStack.isEmpty()) {
            System.out.println("Stack is empty. No students to sort.");
            return;
        }

        // Temporary stack to store the sorted data
        StudentStack sortedStack = new StudentStack();

        while (!studentStack.isEmpty()) {
            // Get the student from the top of the stack
            Student currentStudent = studentStack.pop();

            // Move elements larger than the current student from sortedStack back to studentStack
            while (!sortedStack.isEmpty() && sortedStack.peek().getScore() < currentStudent.getScore()) {
                studentStack.push(sortedStack.pop());
            }

            // Push the current student into sortedStack
            sortedStack.push(currentStudent);
        }

        // Move the sorted data back from sortedStack to studentStack
        while (!sortedStack.isEmpty()) {
            studentStack.push(sortedStack.pop());
        }

        displayStudents();
        System.out.println("Students have been sorted by marks.");
    }

    public void searchStudentByName(String name) {
        Node current = studentStack.top;
        boolean found = false;

        while (current != null) {
            if (current.student.getName().equalsIgnoreCase(name)) {
                System.out.println("Found student: " + current.student);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }

    public void displayStudents() {
        if (studentStack.isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }
        studentStack.displayStudents();
    }

    public boolean isIdExists(int id) {
        Node current = studentStack.top;
        while (current != null) {
            if (current.student.getId() == id) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}