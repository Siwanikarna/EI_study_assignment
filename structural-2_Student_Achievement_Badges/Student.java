// Filename: Student.java
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Badge> badges;

    public Student(String name) {
        this.name = name;
        this.badges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void awardBadge(Badge badge) {
        badges.add(badge);
    }

    public List<Badge> getBadges() {
        return badges;
    }
}
