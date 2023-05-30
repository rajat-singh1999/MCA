import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student_Results {
    private int regNo;
    private String name;
    private String branch;
    private double cgpa;

    public Student_Results(int regNo, String name, String branch, double cgpa) {
        this.regNo = regNo;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    public int getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public static List<Student_Results> getTopperStudents(List<Student_Results> students, String branch, int count) {
        List<Student_Results> topperStudents = new ArrayList<>();

        for (Student_Results student : students) {
            if (student.getBranch().equalsIgnoreCase(branch)) {
                topperStudents.add(student);
            }
        }

        Collections.sort(topperStudents, new Comparator<Student_Results>() {
            @Override
            public int compare(Student_Results s1, Student_Results s2) {
                return Double.compare(s2.getCgpa(), s1.getCgpa());
            }
        });

        topperStudents = topperStudents.subList(0, Math.min(count, topperStudents.size()));

        return topperStudents;
    }

    public String toString() {
        return "Reg.No: " + regNo + "\nName: " + name + "\nBranch: " + branch + "\nCGPA: " + cgpa + "\n";
    }
}

public class HR_Shortlisting {
    public static void main(String[] args) {
        List<Student_Results> students = new ArrayList<>();

        // Add sample student records
        students.add(new Student_Results(1, "Shankar", "CSE", 9.5));
        students.add(new Student_Results(2, "Bhola", "CSE", 9.8));
        students.add(new Student_Results(3, "Ravi", "ECE", 9.2));
        students.add(new Student_Results(4, "Kishan", "ECE", 9.7));
        students.add(new Student_Results(5, "Chandu", "CSE", 9.6));
        students.add(new Student_Results(6, "Chatur", "EEE", 9.3));

        String branch = "CSE"; // Specify the branch for shortlisting
        int count = 2; // Specify the number of top students to select

        List<Student_Results> shortlistedStudents = Student_Results.getTopperStudents(students, branch, count);

        System.out.println("Shortlisted Students' Details:");
        for (Student_Results student : shortlistedStudents) {
            System.out.println(student);
        }
    }
}
