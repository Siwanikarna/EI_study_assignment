// Filename: Badge.java
public class Badge {
    private String name;
    private String description;

    public Badge(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Badge: " + name + " - " + description;
    }
}
