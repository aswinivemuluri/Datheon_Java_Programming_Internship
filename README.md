
# Student Grade Management System

## Project Overview
The Student Grade Management System is a Java console-based application developed as part of the Datheon Java Programming Internship.

It helps manage student academic records, store subject marks, calculate academic performance, and generate individual report cards.

## Features
- Display all student records.
- Add new students.
- Record and update student marks.
- Validate marks between 0 and 100.
- Calculate total marks and average percentage.
- Calculate student GPA using a project-defined grading scale.
- Calculate class average, median, and average GPA.
- Generate individual student report cards.
- Save and load student records using CSV files.

## Technologies Used
- Java 17
- Object-Oriented Programming (OOP)
- ArrayList Collection
- File Handling
- CSV Data Storage
- VS Code

## Project Structure
```text
StudentGradeManagementSystem/
│
├── src/
│   ├── Student.java
│   ├── GradeManager.java
│   ├── Main.java
│   └── data/
│       └── sample_student_grades.csv
│
├── out/
│
└── README.md
```

## How to Run

### 1. Compile the Java files
```bash
javac -d out src/Student.java src/GradeManager.java src/Main.java
```

### 2. Run the application
```bash
java -cp out Main
```

Run these commands from the main project folder.

## GPA Calculation
The application uses a simple project-defined GPA scale based on the student's average marks:

| Average Marks | GPA |
|---|---:|
| 90–100 | 10 |
| 80–89 | 9 |
| 70–79 | 8 |
| 60–69 | 7 |
| 50–59 | 6 |
| 40–49 | 5 |
| Below 40 | 0 |

This is an illustrative grading scale, not an official university GPA conversion.

## Data Storage
Student records are stored in a CSV file:

`src/data/sample_student_grades.csv`

The application loads existing records when it starts and saves changes when students are added or marks are updated.

## Learning Outcomes
- Understanding Java OOP concepts.
- Implementing encapsulation using private fields and getters/setters.
- Working with ArrayList.
- Performing input validation.
- Reading and writing CSV files.
- Calculating academic statistics.
- Building a menu-driven Java application.

## Internship
**Program:** Datheon Java Programming Internship  
**Project:** Student Grade Management System  
**Language:** Java
