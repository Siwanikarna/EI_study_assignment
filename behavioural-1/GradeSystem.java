
import java.util.ArrayList;
import java.util.List;

public class GradeSystem implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String grade;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(grade);
        }
    }

    public void setGrade(String grade) {
        this.grade = grade;
        notifyObservers();
    }
}
