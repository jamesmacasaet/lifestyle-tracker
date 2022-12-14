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
import java.util.Scanner;

public class TrackerConsole {
    public TrackerConsole(String username) {
        Scanner in = new Scanner(System.in);
        LifestyleTracker tracker = new LifestyleTracker();
        ArrayList<String> commands = new ArrayList<>();
        String command = "";

        while (true) {
            command = in.nextLine().trim();
            if (command.equalsIgnoreCase("Report"))
                break;

            if (!command.equalsIgnoreCase(""))
                commands.add(command);
        }

        System.out.println();
        System.out.println("Welcome to " + username + "'s Lifestyle Tracker!");

        for (int i = 0; i < commands.size(); i++) {
            String[] parts = commands.get(i).split(" ");
            String action = parts[0];
            String name = parts[1];
            double amount = Double.parseDouble(parts[2]);

            if (action.equalsIgnoreCase("Food")) {
                System.out.println(tracker.addFood(name, amount));
            } else if (action.equalsIgnoreCase("Activity")) {
                System.out.println(tracker.addActivity(name, amount));
            } else if (action.equalsIgnoreCase("Eat")) {
                System.out.println(tracker.eat(name, amount));
            } else if (action.equalsIgnoreCase("Perform")) {
                System.out.println(tracker.perform(name, amount));
            }
        }

        tracker.report();
        in.close();
    }

    public static void main(String args[]) {
        try {
            String name = args[0];
            new TrackerConsole(name);
        } catch (Exception e) {
            new TrackerConsole("User");
        }
    }
}
