import java.util.Scanner;

public class TVSeriesManagement {
    public static void main(String[] args) {
        // Load previous data when the program starts
        Series.loadSeriesFromFile();  // ADD THIS LINE
        
        Scanner input = new Scanner(System.in);
        int option;
         System.out.println("LATEST SERIES 2025");
         System.out.println("///////////////////////////////////////");
         System.out.println("Enter (1) to launch menu or any other key to exit: ");
         String startChoice = input.nextLine();
                 
               if (!startChoice.equals("1")){
                   System.out.println("Application ended.");
                   return;
               }
                     
        // Infinite loop to keep showing the menu until the user chooses to exit
        while (true) {
            System.out.println("\n===== TV SERIES MANAGEMENT MENU =====");
            System.out.println("1. Capture new series");
            System.out.println("2. Search for a series");
            System.out.println("3. Update a series");
            System.out.println("4. Delete a series");
            System.out.println("5. View all series report");
            System.out.println("6. End");
            System.out.print("Choose an option 1 to 6: ");

            try {
                // Read user input and convert it to an integer
                option = Integer.parseInt(input.nextLine().trim());

                // Use switch-case to handle user selection
                switch (option) {
                    case 1:
                        Series.CaptureSeries(); // Call method to capture a new series
                        break;
                    case 2:
                        Series.SearchSeries(); // Call method to search for a series
                        break;
                    case 3:
                        Series.UpdateSeries(); // Call method to update a series
                        break;
                    case 4:
                        Series.DeleteSeries(); // Call method to delete a series
                        break;
                    case 5:
                        Series.SeriesReport(); // Call method to display all series
                        break;
                    case 6:
                        Series.ExitSeriesApplication(); // Confirm and exit the application
                        break;
                    default:
                        // Handle invalid option (not 1-6)
                        System.out.println("Invalid option. Please choose again.");
                }
            } catch (NumberFormatException e) {
                // Handle invalid input that can't be converted to an integer
                System.out.println("Please enter a valid number.");
            }
        }
    }
}