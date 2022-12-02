/**
@author James Emmanuelle D.G Macasaet (216712)
@version December 2, 2022
**/
/*
I have not discussed the Java language code in my program 
with anyone other than my instructor or the teaching assistants 
assigned to this course.
I have not used Java language code obtained from another student, 
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program 
was obtained from another source, such as a textbook or website, 
that has been clearly noted with a proper citation in the comments 
of my program.
*/


import java.util.ArrayList;
import java.lang.Math;
public class LifestyleTracker {
    private ArrayList<Food> foodList = new ArrayList<>();
    private ArrayList<Activity> activityList = new ArrayList<>();

    private ArrayList<FoodComsumed> foodConsumed = new ArrayList<>();
    private ArrayList<ActivitiesPerformed> activitiesPerformed = new ArrayList<>();

    public class FoodComsumed {
        public Food food;
        public double servings;

        public FoodComsumed(Food food, double servings) {
            this.food = food;
            this.servings = servings;
        }

        public void report() {
            System.out.println(this.servings + " serving(s) of " + this.food.getFoodName() + ", "
                    + (this.food.getFoodCalories() * this.servings) + " kcal");
        }
    }

    public class ActivitiesPerformed {
        public Activity activity;
        public double hours;

        public ActivitiesPerformed(Activity activity, double hours) {
            this.activity = activity;
            this.hours = hours;
        }

        public void report() {
            System.out.println(this.hours + " hour(s) of " + this.activity.getActivityName() + ", "
                    + (this.activity.getActivityCalories() * this.hours) + " kcal");
        }
    }

    public double totalCalories() {
        double totalCalories = 0;
        for (int i = 0; i < foodConsumed.size(); i++) {
            totalCalories += foodConsumed.get(i).food.getFoodCalories() * foodConsumed.get(i).servings;
        }
        return totalCalories;
    }

    public double totalBurned() {
        double totalBurned = 0;
        for (int i = 0; i < activitiesPerformed.size(); i++) {
            totalBurned += activitiesPerformed.get(i).activity.getActivityCalories() * activitiesPerformed.get(i).hours;
        }
        return totalBurned;
    }

    public String addFood(String n, double c) {
        boolean found = false;

        for (int i = 0; i < foodList.size(); i++) {
            Food current = foodList.get(i);
            if (current.getFoodName().equals(n)) {
                current.updateCalories(c);
                foodList.set(i, current);
                found = true;
                return "Updated Food " + n + " with " + String.format("%.2f", c) + " kcal";
            }
        }

        if (found == false) {
            foodList.add(new Food(n, c));
        }

        return "Added Food " + n + " with " + String.format("%.2f", c) + " kcal";
    }

    public String addActivity(String n, double c) {
        boolean found = false;

        for (int i = 0; i < activityList.size(); i++) {
            Activity current = activityList.get(i);
            if (current.getActivityName().equals(n)) {
                current.updateCalories(c);
                activityList.set(i, current);
                found = true;
                return "Updated Activity " + n + " with " + String.format("%.2f", c) + " kcal";
            }
        }

        if (found == false) {
            activityList.add(new Activity(n, c));
        }

        return "Added Activity " + n + " with " + String.format("%.2f", c) + " kcal";
    }

    public String eat(String foodName, double serving) {
        if (serving <= 0) {
            return "Number of servings cannot be negative.";
        }

        for (int i = 0; i < foodList.size(); i++) {
            Food current = foodList.get(i);
            if (current.getFoodName().equals(foodName)) {
                foodConsumed.add(new FoodComsumed(current, serving));
                return "Ate " + String.format("%.2f", serving) + " serving(s) of " + foodName + ", "
                        + String.format("%.2f", current.getFoodCalories() * serving) + " kcal";
            }
        }

        return "The specified food does not exist";
    }

    public String perform(String actName, double hours) {
        if (hours <= 0) {
            return "Number of hours cannot be negative.";
        }

        for (int i = 0; i < activityList.size(); i++) {
            Activity current = activityList.get(i);
            if (current.getActivityName().equals(actName)) {
                activitiesPerformed.add(new ActivitiesPerformed(current, hours));
                return "Performed " + String.format("%.2f", hours) + " hour(s) of " + actName + ", "
                        + String.format("%.2f", current.getActivityCalories() * hours) + " kcal";
            }
        }

        return "The specified activity does not exist.";
    }

    public String report() {
        System.out.println("----------------");
        System.out.println("LIFESTYLE REPORT");
        System.out.println("----------------");
        System.out.println("Food Consumed:");

        for (int i = 0; i < foodConsumed.size(); i++) {
            foodConsumed.get(i).report();
        }

        double totalCalories = this.totalCalories();

        System.out.println("----------------");
        System.out.println("Total Calories Consumed: " + totalCalories + " kcal");
        System.out.println("----------------");
        System.out.println("Activities Performed:");

        for (int i = 0; i < activitiesPerformed.size(); i++) {
            activitiesPerformed.get(i).report();
        }

        double totalBurned = this.totalBurned();

        System.out.println("----------------");
        System.out.println("Total Calories Burned: " + totalBurned + " kcal");
        System.out.println("----------------");

        double netCalories = totalCalories - totalBurned;
        String text = "gain";
        if (netCalories < 0 ) text = "lose";
        double kilos = netCalories * 0.00012959782;

        System.out.println("Net Calories for the Day: " + netCalories + " kcal");
        System.out.println("If you keep up this lifestyle...");

        System.out.printf("In a week, you will %s %.2f kilograms \n", text, Math.abs(kilos * 7)); 
        System.out.printf("In a month, you will %s %.2f kilograms \n", text, Math.abs(kilos * 30)); 
        System.out.printf("In 3 months, you will %s %.2f kilograms \n", text, Math.abs(kilos * 90)); 
        System.out.printf("In 6 months, you will %s %.2f kilograms \n", text, Math.abs(kilos *  180)); 
    
        return "";
    }
}
