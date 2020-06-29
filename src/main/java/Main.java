import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void PrintMenu(String title, String[] list, String exitmessage)
    {
        System.out.println(title + ": \n");
        int counter = 0;

        for (String option: list
        ) {
            counter++;
            System.out.println(" (" + counter + ") " + option);
        }
        System.out.println(" (0) " + exitmessage);
    }

    public static void HandleMenu()
    {
        String[] options = new String[]
                {
                        "CD options",
                        "Player options",
                        "Menu options",
                };
        PrintMenu("Main menu", options, "Exit program");
    }

    public static void Choose()
    {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\nPlease enter a number: ");
        String option = input.nextLine();

        if (option.equals("1"))
        {

        }
        else if (option.equals("2"))
        {

        }
        else if (option.equals("3"))
        {

        }
        else if (option.equals("0"))
        {
            System.out.println("Closing the program, please wait...");
            // Terminate JVM
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        else
        {
            System.out.println("Wrong input! Try again.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        while (true)
        {
            HandleMenu();
            Choose();
        }
    }
}
