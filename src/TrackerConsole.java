import java.util.Scanner;

public class TrackerConsole {
    public TrackerConsole(String username) {
        System.out.println("Welcome to " + username + "'s Lifestyle Tracker!");

        Scanner in = new Scanner(System.in);
        LifestyleTracker tracker = new LifestyleTracker();

        String command = in.next();
        // sample change
        while (!command.equalsIgnoreCase("Report")) {
            if (command.equalsIgnoreCase("Food")) {
                String name = in.next();
                double calories = in.nextDouble();
                System.out.println(tracker.addFood(name, calories));
            } else if (command.equalsIgnoreCase("Activity")) {
                String name = in.next();
                double calories = in.nextDouble();
                System.out.println(tracker.addActivity(name, calories));
            } else if (command.equalsIgnoreCase("Eat")) {
                String name = in.next();
                double calories = in.nextDouble();
                System.out.println(tracker.eat(name, calories));
            } else if (command.equalsIgnoreCase("Perform")) {
                String name = in.next();
                double hours = in.nextDouble();
                System.out.println(tracker.perform(name, hours));
            }
            command = in.next();
        }

        System.out.println("Report:");
        tracker.report();
        in.close();
    }

    public static void main(String args[]) {
        String name = args[0];
        new TrackerConsole(name);
    }
}
