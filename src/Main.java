
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GradeManager manager = new GradeManager();
        Scanner scanner = new Scanner(System.in);

        String filePath = "src/data/sample_student_grades.csv";

        manager.loadStudentsFromCSV(filePath);

        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE MANAGEMENT SYSTEM =====");
            System.out.println("1. Display All Students");
            System.out.println("2. Display Class Statistics");
            System.out.println("3. Add New Student");
            System.out.println("4. Record Student Marks");
            System.out.println("5. Generate Individual Report Card");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    manager.displayStudents();
                    break;

                case 2:
                    manager.displayClassStatistics();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Math Marks: ");
                    int math = scanner.nextInt();

                    System.out.print("Enter Science Marks: ");
                    int science = scanner.nextInt();

                    System.out.print("Enter English Marks: ");
                    int english = scanner.nextInt();

                    System.out.print("Enter Computer Marks: ");
                    int computer = scanner.nextInt();

                    manager.addNewStudent(
                        id, name, math, science, english, computer
                    );

                    manager.saveStudentsToCSV(filePath);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();

                    System.out.print("Enter Math Marks: ");
                    int m = scanner.nextInt();

                    System.out.print("Enter Science Marks: ");
                    int s = scanner.nextInt();

                    System.out.print("Enter English Marks: ");
                    int e = scanner.nextInt();

                    System.out.print("Enter Computer Marks: ");
                    int c = scanner.nextInt();

                    manager.recordMarks(studentId, m, s, e, c);

                    manager.saveStudentsToCSV(filePath);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    int reportId = scanner.nextInt();

                    manager.generateReportCard(reportId);
                    break;

                case 6:
                    manager.saveStudentsToCSV(filePath);
                    System.out.println("Thank you for using the application!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
