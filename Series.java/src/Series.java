import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

public class Series {
    //  List to store all series entries in memory
    private static ArrayList<SeriesModel> seriesList = new ArrayList<>();

    //  Scanner to read user input
    private static Scanner scanner = new Scanner(System.in);
    
    // File name to save the series data
    private static final String DATA_FILE = "series_data.ser";

    // Method to save series data to file
    public static void saveSeriesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(seriesList);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Method to load series data from file
    @SuppressWarnings("unchecked")
    public static void loadSeriesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            seriesList = (ArrayList<SeriesModel>) ois.readObject();
            System.out.println("Previous data loaded successfully! Found " + seriesList.size() + " series.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting with empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            System.out.println("Starting with empty list.");
        }
    }

    // Method to capture new series information
    public static void CaptureSeries() {
        System.out.println("Enter Series ID:");
        String id = scanner.nextLine().trim();

        // Prevent duplicate series IDs
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(id)) {
                System.out.println("A series with this ID already exists. Please use a unique ID.\n");
                return;
            }
        }

        System.out.println("Enter Series Name:");
        String name = scanner.nextLine().trim();

        // Validate age restriction between 2 and 18
        int age;
        while (true) {
            System.out.println("Enter Age Restriction (2–18):");
            try {
                age = Integer.parseInt(scanner.nextLine().trim());
                if (age >= 2 && age <= 18) break;
                else System.out.println("Age must be between 2 and 18.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        // Ensure number of episodes is greater than 0
        int episodes;
        while (true) {
            System.out.println("Enter Number of Episodes:");
            try {
                episodes = Integer.parseInt(scanner.nextLine().trim());
                if (episodes > 0) break;
                else System.out.println("Please enter a number greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // Create and add new series to the list
        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesList.add(newSeries);

        // Auto-save after adding new series
        saveSeriesToFile();

        System.out.println("Series captured and saved successfully!\n");
        System.out.println("Press Enter to return to the menu...");
        scanner.nextLine();
    }

    // Method to search for a series using ID or name
    public static void SearchSeries() {
        System.out.println("Enter Series ID or Name to search:");
        String searchTerm = scanner.nextLine().trim();
        boolean found = false;

        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(searchTerm) || s.getSeriesName().equalsIgnoreCase(searchTerm)) {
                System.out.println("Series Found:");
                System.out.println(s);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No series data could be found.\n");
        }
        System.out.println("Press Enter to return to the menu...");
        scanner.nextLine();
    }

    // Method to update an existing series
    public static void UpdateSeries() {
        System.out.println("Enter Series ID to update:");
        String updateId = scanner.nextLine().trim();
        boolean found = false;

        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(updateId)) {
                System.out.println("Current Series: " + s);

                System.out.println("Enter new name:");
                s.setSeriesName(scanner.nextLine().trim());

                int age;
                while (true) {
                    System.out.println("Enter new age restriction (2–18):");
                    try {
                        age = Integer.parseInt(scanner.nextLine().trim());
                        if (age >= 2 && age <= 18) break;
                        else System.out.println("Age must be between 2 and 18.");
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a valid number.");
                    }
                }
                s.setSeriesAge(age);

                int episodes;
                while (true) {
                    System.out.println("Enter new number of episodes:");
                    try {
                        episodes = Integer.parseInt(scanner.nextLine().trim());
                        if (episodes > 0) break;
                        else System.out.println("Please enter a number greater than 0.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                }
                s.setNumberOfEpisodes(episodes);

                // Auto-save after updating
                saveSeriesToFile();

                System.out.println("Series updated and saved successfully.\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Series not found.\n");
        }
        System.out.println("Press Enter to return to the menu...");
        scanner.nextLine();
    }

    // Method to delete a series with confirmation
    public static void DeleteSeries() {
        System.out.println("Enter Series ID to delete:");
        String deleteId = scanner.nextLine().trim();
        boolean found = false;

        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesId().equalsIgnoreCase(deleteId)) {
                System.out.println("Are you sure you want to delete this series? (yes/no)");
                String confirm = scanner.nextLine().trim();
                if (confirm.equalsIgnoreCase("y")) {
                    seriesList.remove(i);
                    
                    // Auto-save after deleting
                    saveSeriesToFile();
                    
                    System.out.println("Series deleted and saved successfully.\n");
                } else {
                    System.out.println("Delete cancelled.\n");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Series not found.\n");
        }
        System.out.println("Press Enter to return to the menu...");
        scanner.nextLine();
    }

    // Method to view a report of all series
    public static void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series captured yet.\n");
        } else {
            System.out.println("1. View All");
            System.out.println("2. Sort by Name");
            System.out.println("3. Filter by Age Restriction");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "2":
                    Collections.sort(seriesList, Comparator.comparing(SeriesModel::getSeriesName));
                    break;
                case "3":
                    try {
                        System.out.print("Enter age restriction to filter by: ");
                        int ageFilter = Integer.parseInt(scanner.nextLine().trim());
                        boolean foundAny = false;
                        System.out.println("===== FILTERED SERIES REPORT =====");
                        for (SeriesModel s : seriesList) {
                            if (s.getSeriesAge() == ageFilter) {
                                System.out.println(s);
                                foundAny = true;
                            }
                        }
                        if (!foundAny) {
                            System.out.println("No series found with age restriction " + ageFilter);
                        }
                        System.out.println("==================================\n");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age entered.\n");
                    }
                    System.out.println("Press Enter to return to the menu...");
                    scanner.nextLine();
                    return;
                default:
                    break;
            }

            System.out.println("===== SERIES REPORT =====");
            for (SeriesModel s : seriesList) {
                System.out.println(s);
            }
            System.out.println("=========================\n");
        }
        System.out.println("Press Enter to return to the menu...");
        scanner.nextLine();
    }

    // Exit confirmation
    public static void ExitSeriesApplication() {
        System.out.println("Are you sure you want to exit? (y/n)");
        String confirm = scanner.nextLine().trim();
        if (confirm.equalsIgnoreCase("y")) {
            // Final save before exiting
            saveSeriesToFile();
            System.out.println("Data saved. Exiting application...");
            System.exit(0);
        } else {
            System.out.println("Exit cancelled.\n");
        }
    }
}