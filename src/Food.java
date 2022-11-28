public class Food {
    private String name;
    private double calories;

    public Food(String f, double c) {
        name = f;
        calories = c;
    }

    public String getFoodName() {
        return name;
    }

    public double getFoodCalories() {
        return calories;
    }

    public void updateCalories(double c) {
        calories = c;
    }
}
