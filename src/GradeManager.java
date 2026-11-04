
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class GradeManager {

    private ArrayList<Student> students = new ArrayList<>();

    private static final String CSV_HEADER =
        "student_id,name,math_score,science_score,english_score,computer_score";

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Find student by ID
    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    // Load students from CSV
    public void loadStudentsFromCSV(String filePath) {

        students.clear();

        try (BufferedReader br =
                new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length != 6) {
                    System.out.println("Skipping invalid CSV row.");
                    continue;
                }

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();

                int math = Integer.parseInt(data[2].trim());
                int science = Integer.parseInt(data[3].trim());
                int english = Integer.parseInt(data[4].trim());
                int computer = Integer.parseInt(data[5].trim());

                if (findStudent(id) != null) {
                    continue;
                }

                if (!validMarks(math) || !validMarks(science)
                        || !validMarks(english) || !validMarks(computer)) {
                    System.out.println("Invalid marks for student: " + id);
                    continue;
                }

                Student student = new Student(id, name);

                student.setMathScore(math);
                student.setScienceScore(science);
                student.setEnglishScore(english);
                student.setComputerScore(computer);

                students.add(student);
            }

            System.out.println("CSV loaded successfully!");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number in CSV file.");
        }
    }

    // Save students to CSV
    public void saveStudentsToCSV(String filePath) {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(filePath))) {

            writer.write(CSV_HEADER);
            writer.newLine();

            for (Student student : students) {

                writer.write(
                    student.getStudentId() + "," +
                    student.getName() + "," +
                    student.getMathScore() + "," +
                    student.getScienceScore() + "," +
                    student.getEnglishScore() + "," +
                    student.getComputerScore()
                );

                writer.newLine();
            }

            System.out.println("Student records saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving CSV: " + e.getMessage());
        }
    }

    // Display all students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        for (Student student : students) {
            student.displayResult();
        }
    }

    // Generate individual report card
    public void generateReportCard(int id) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\n================================");
        System.out.println("       STUDENT REPORT CARD");
        System.out.println("================================");

        student.displayResult();

        System.out.println("================================");
        System.out.println("       END OF REPORT");
        System.out.println("================================");
    }

    // Class average
    public double calculateClassAverage() {

        if (students.isEmpty()) return 0;

        double total = 0;

        for (Student student : students) {
            total += student.calculateAverage();
        }

        return total / students.size();
    }

    // Class median
    public double calculateClassMedian() {

        if (students.isEmpty()) return 0;

        ArrayList<Double> averages = new ArrayList<>();

        for (Student student : students) {
            averages.add(student.calculateAverage());
        }

        Collections.sort(averages);

        int size = averages.size();

        if (size % 2 == 1) {
            return averages.get(size / 2);
        }

        return (averages.get(size / 2 - 1)
                + averages.get(size / 2)) / 2.0;
    }

    // Class GPA
    public double calculateClassGPA() {

        if (students.isEmpty()) return 0;

        double totalGPA = 0;

        for (Student student : students) {
            totalGPA += student.calculateGPA();
        }

        return totalGPA / students.size();
    }

    // Display statistics
    public void displayClassStatistics() {

        System.out.println("\n========== CLASS STATISTICS ==========");

        System.out.println("Total Students: " + students.size());

        System.out.printf("Class Average: %.2f%%%n",
                calculateClassAverage());

        System.out.printf("Class Median: %.2f%%%n",
                calculateClassMedian());

        System.out.printf("Class GPA: %.2f / 10%n",
                calculateClassGPA());
    }

    // Validate marks
    private boolean validMarks(int marks) {
        return marks >= 0 && marks <= 100;
    }

    // Add new student
    public void addNewStudent(int id, String name,
            int math, int science, int english, int computer) {

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        if (!validMarks(math) || !validMarks(science)
                || !validMarks(english) || !validMarks(computer)) {
            System.out.println("Marks must be between 0 and 100!");
            return;
        }

        Student student = new Student(id, name);

        student.setMathScore(math);
        student.setScienceScore(science);
        student.setEnglishScore(english);
        student.setComputerScore(computer);

        addStudent(student);
    }

    // Update existing student marks
    public void recordMarks(int id, int math,
            int science, int english, int computer) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        if (!validMarks(math) || !validMarks(science)
                || !validMarks(english) || !validMarks(computer)) {
            System.out.println("Marks must be between 0 and 100!");
            return;
        }

        student.setMathScore(math);
        student.setScienceScore(science);
        student.setEnglishScore(english);
        student.setComputerScore(computer);

        System.out.println("Student marks updated successfully!");
    }
}
