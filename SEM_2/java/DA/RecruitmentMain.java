import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Recruitment {
    private String name;
    private String qualification;
    private int experience;
    private String dob;
    private String gender;

    public Recruitment(String name, String qualification, int experience, String dob, String gender) {
        this.name = name;
        this.qualification = qualification;
        this.experience = experience;
        this.dob = dob;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public int getExperience() {
        return experience;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String toString() {
        return "Name: " + name + "\nQualification: " + qualification + "\nExperience: " + experience +
                "\nDOB: " + dob + "\nGender: " + gender + "\n";
    }
}

public class RecruitmentMain {
    public static void main(String[] args) {
        List<Recruitment> candidates = new ArrayList<>();

        // Add sample candidate records
        candidates.add(new Recruitment("John", "Ph.D.", 5, "1990-01-01", "Male"));
        candidates.add(new Recruitment("Alice", "M.Tech.", 3, "1992-05-15", "Female"));
        candidates.add(new Recruitment("Bob", "B.Tech.", 5, "1991-08-20", "Male"));
        candidates.add(new Recruitment("Emma", "Ph.D.", 2, "1993-04-10", "Female"));
        candidates.add(new Recruitment("Sam", "M.Tech.", 3, "1990-11-30", "Male"));

        Collections.sort(candidates, new Comparator<Recruitment>() {
            @Override
            public int compare(Recruitment r1, Recruitment r2) {
                if (r1.getExperience() == r2.getExperience()) {
                    return r1.getName().compareTo(r2.getName());
                }
                return Integer.compare(r2.getExperience(), r1.getExperience());
            }
        });

        System.out.println("Sorted Candidates' Details:");
        for (Recruitment candidate : candidates) {
            System.out.println(candidate);
        }
    }
}

