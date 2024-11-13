//Shivambu Dev Pandey
//23bcs123
//L10 CS207 Grading
// will read data from file , so change the name and path as per your requirements 

import java.io.*;
import java.util.*;

class Student {
    private String registerNumber;
    private double totalMarks;
    private String grade;

    public Student(String registerNumber, double totalMarks) {
        this.registerNumber = registerNumber;
        this.totalMarks = totalMarks;
    }

    public double getTotalMarks() { return totalMarks; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getGrade() { return grade; }
    public String getRegisterNumber() { return registerNumber; }
}

class Department {
    private String name;
    private List<Student> students = new ArrayList<>();
    private double mean, SD;
    private int expectedStudentCount;

    public Department(String name, int expectedStudentCount) {
        this.name = name;
        this.expectedStudentCount = expectedStudentCount;
    }

    public void addStudent(Student student) { students.add(student); }
    public void calculateMean() { mean = students.stream().mapToDouble(Student::getTotalMarks).average().orElse(0); }
    public void calculateSD() {
        double sum = students.stream().mapToDouble(s -> Math.pow(s.getTotalMarks() - mean, 2)).sum();
        SD = Math.sqrt(sum / students.size());
    }

    public void assignGrades() {
        for (Student student : students) {
            double diff = student.getTotalMarks() - mean;
            student.setGrade(
                diff >= 1.5 * SD ? "A" : diff >= SD ? "A-" : diff >= 0.5 * SD ? "B" :
                diff >= 0 ? "B-" : diff >= -0.5 * SD ? "C" : diff >= -1 * SD ? "C-" :
                diff >= -1.5 * SD ? "D" : "F"
            );
        }
    }

    public void printGrades() {
        System.out.println("Department: " + name);
        students.forEach(s -> System.out.println("Register Number: " + s.getRegisterNumber() + 
            " Marks: " + s.getTotalMarks() + " Grade: " + s.getGrade()));
    }

    public boolean hasAllMarks() { return students.size() == expectedStudentCount; }
}

public class Grading_23bcs123 {
    public static void main(String[] args) {
        try {
            Department CSE_A = new Department("CSE Section A", 70);
            Department CSE_B = new Department("CSE Section B", 70);
            Department DSAI = new Department("DSAI", 70); 
            Department ECE = new Department("ECE", 70); 

            Scanner scanner = new Scanner(new File("students_data.txt"));

            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split("\t");
                String regNo = data[0];
                double marks = Double.parseDouble(data[1]);
                Student student = new Student(regNo, marks);

                String branch = regNo.substring(2, 5);
                int rollNo = Integer.parseInt(regNo.substring(5,8));

                switch (branch) {
                    case "BCS": 
                        (rollNo <= 70 ? CSE_A : CSE_B).addStudent(student); 
                        break;
                    case "BDS": DSAI.addStudent(student); break;
                    case "BEC": ECE.addStudent(student); break;
                    default: System.out.println("Unknown branch: " + branch);
                }
            }
            scanner.close();

            List<Department> departments = Arrays.asList(CSE_A, CSE_B, DSAI, ECE);
            for (Department dept : departments) {
                if (dept.hasAllMarks()) {
                    dept.calculateMean();
                    dept.calculateSD();
                    dept.assignGrades();
                    dept.printGrades();
                } else {
                    System.out.println("Not enough data for department: " + dept);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}