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

public class Food {
    private String name;
    private double calories;

    public Food(String f, double c) {
        name = f;
        calories = c;
    }

    public void update(String f, double c) {
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
