public class Activity {
    private String name;
    private double calories;

    public Activity(String n, double c) {
        name = n;
        calories = c;
    }

    public String getActivityName() {
        return name;
    }

    public double getActivityCalories() {
        return calories;

    }

    public void updateCalories(double c) {
        calories = c;
    }
}