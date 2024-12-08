package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            int choice = 0;
            // Nhập lựa chọn menu với kiểm tra lỗi
            while (true) {
                try {
                    System.out.println("\nMenu:");
                    System.out.println("1. Add Student");
                    System.out.println("2. Update Student");
                    System.out.println("3. Delete Student");
                    System.out.println("4. Sort Students by Marks");
                    System.out.println("5. Search Student by Name");
                    System.out.println("6. Display All Students");
                    System.out.println("7. Exit");
                    System.out.print("Choose an option (1-7): ");
                    choice = sc.nextInt();
                    sc.nextLine();

                    if (choice >= 1 && choice <= 7) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 7.");
                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                }
            }

            // Xử lý lựa chọn
            switch (choice) {
                case 1:
                    // Thêm sinh viên với kiểm tra ID
                    int id;
                    while (true) {
                        System.out.print("Enter id: ");
                        try {
                            id = sc.nextInt();
                            sc.nextLine(); // Xóa dòng thừa
                            if (id < 0) {
                                System.out.println("ID must be non-negative. Please try again.");
                            } else if (studentManagement.isIdExists(id)) {
                                System.out.println("ID already exists. Please enter a unique ID.");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid numeric ID.");
                            sc.nextLine(); // Xóa dữ liệu không hợp lệ
                        }
                    }

                    // Nhập tên sinh viên
                    String name;
                    while (true) {
                        System.out.print("Enter name: ");
                        name = sc.nextLine();
                        if (name.trim().isEmpty()) {
                            System.out.println("Name cannot be empty. Please try again.");
                        } else {
                            break;
                        }
                    }

                    // Nhập điểm sinh viên
                    double score;
                    while (true) {
                        System.out.print("Enter mark: ");
                        try {
                            score = sc.nextDouble();
                            sc.nextLine(); // Xóa dòng thừa
                            if (score < 0 || score > 10) {
                                System.out.println("Mark must be between 0 and 10. Please try again.");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid mark (0-10).");
                            sc.nextLine(); // Xóa dữ liệu không hợp lệ
                        }
                    }

                    studentManagement.addStudent(new Student(id, name, score));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter the ID of the student to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new mark: ");
                    double newMark = sc.nextDouble();
                    sc.nextLine();

                    studentManagement.updateStudent(updateId, newName, newMark);
                    break;

                case 3:
                    System.out.print("Enter the ID of the student to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    studentManagement.deleteStudentByID(deleteId);
                    break;

                case 4:
                    studentManagement.sortByMark();
                    break;

                case 5:
                    System.out.print("Enter the name of the student to search: ");
                    String searchName = sc.nextLine();
                    studentManagement.searchStudentByName(searchName);
                    break;

                case 6:
                    studentManagement.displayStudents();
                    break;

                case 7:
                    System.out.println("Exiting program.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}