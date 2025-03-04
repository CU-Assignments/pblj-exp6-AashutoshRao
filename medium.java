import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 72),
            new Student("John", 90),
            new Student("David", 65),
            new Student("Emma", 78)
        );

        // Filter students with marks > 75%, sort by marks, and display names
        List<String> topStudents = students.stream()
            .filter(student -> student.getMarks() > 75) // filter by marks
            .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks())) // sort descending
            .map(Student::getName) // extract names
            .collect(Collectors.toList()); // collect to list

        System.out.println("Students scoring above 75% (sorted by marks): " + topStudents);
    }
}
