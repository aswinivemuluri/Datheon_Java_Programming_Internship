
public class Student {
    private int studentId;
    private String name;

    private int mathScore;
    private int scienceScore;
    private int englishScore;
    private int computerScore;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getScienceScore() {
        return scienceScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setMathScore(int score) {
        if (score >= 0 && score <= 100) {
            mathScore = score;
        } else {
            System.out.println("Invalid Math Score! Marks must be 0 to 100.");
        }
    }

    public void setScienceScore(int score) {
        if (score >= 0 && score <= 100) {
            scienceScore = score;
        } else {
            System.out.println("Invalid Science Score! Marks must be 0 to 100.");
        }
    }

    public void setEnglishScore(int score) {
        if (score >= 0 && score <= 100) {
            englishScore = score;
        } else {
            System.out.println("Invalid English Score! Marks must be 0 to 100.");
        }
    }

    public void setComputerScore(int score) {
        if (score >= 0 && score <= 100) {
            computerScore = score;
        } else {
            System.out.println("Invalid Computer Score! Marks must be 0 to 100.");
        }
    }

    public int calculateTotal() {
        return mathScore + scienceScore + englishScore + computerScore;
    }

    public double calculateAverage() {
        return calculateTotal() / 4.0;
    }

    public double calculateGPA() {
        double average = calculateAverage();

        if (average >= 90) return 10.0;
        if (average >= 80) return 9.0;
        if (average >= 70) return 8.0;
        if (average >= 60) return 7.0;
        if (average >= 50) return 6.0;
        if (average >= 40) return 5.0;

        return 0.0;
    }

    public void displayResult() {
        System.out.println("\n==============================================");
        System.out.println("             STUDENT REPORT CARD");
        System.out.println("==============================================");
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + name);
        System.out.println("----------------------------------------------");
        System.out.printf("%-20s %10s%n", "SUBJECT", "MARKS");
        System.out.println("----------------------------------------------");
        System.out.printf("%-20s %10d%n", "Mathematics", mathScore);
        System.out.printf("%-20s %10d%n", "Science", scienceScore);
        System.out.printf("%-20s %10d%n", "English", englishScore);
        System.out.printf("%-20s %10d%n", "Computer Science", computerScore);
        System.out.println("----------------------------------------------");
        System.out.printf("%-20s %10d / 400%n", "TOTAL", calculateTotal());
        System.out.printf("%-20s %10.2f%%%n", "AVERAGE", calculateAverage());
        System.out.printf("%-20s %10.2f / 10%n", "GPA", calculateGPA());
        System.out.println("==============================================");
    }
}
