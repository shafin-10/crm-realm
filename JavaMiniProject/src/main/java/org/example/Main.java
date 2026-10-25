package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Stores all leads in memory while the application is running
    private static ArrayList<Lead> leads = new ArrayList<>();

    // Reads user input from the console
    private static  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Simple Lead Tracker =====");
            System.out.println("1. Add a lead");
            System.out.println("2. View all leads");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            // Execute the selected menu operation
            switch (choice) {
                case "1":
                    addLead();
                    break;
                case "2":
                    viewAllLeads();
                    break;
                case "3":
                    System.out.println("Exiting Lead Tracker. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println(
                            "Invalid choice. Please select 1, 2, or 3."
                    );
            }
        }

    }

    /**
     * Collects lead information, validates the input,
     * and adds a new lead to the collection.
     */
    public static void addLead(){
        // Get the lead's full name and reject blank input
        System.out.println("Enter full name: ");
        String name = scanner.nextLine().trim();

        if(name.isEmpty()){
            System.out.println("Name cannot be empty");
            return;
        }

        // Get the email address and check that it is not empty
        System.out.println("Enter Email: ");
        String email = scanner.nextLine().trim();

        if (email.isEmpty()) {
            System.out.println("Email cannot be empty.");
            return;
        }

        // Validate the basic email format before continuing
        if(!isValidEmail(email)){
            System.out.println("Please enter a valid email address");
            return;
        }

        // Read the score as text so invalid numeric input can be handled
        System.out.print("Enter score (0-100): ");
        String scoreInput = scanner.nextLine().trim();
        int score;

        // Convert the input to an integer and handle non-numeric values
        try {
            score = Integer.parseInt(scoreInput);
        } catch (NumberFormatException e) {
            System.out.println(
                    "Invalid input: Score must be an integer."
            );
            return;
        }

        // Ensure the score is within the allowed range
        if (score < 0 || score > 100) {
            System.out.println(
                    "Invalid input: Score must be between 0 and 100."
            );
            return;
        }

        // Create the lead only after all input has passed validation
        Lead lead = new Lead(name, email, score);
        leads.add(lead);

        System.out.println("Lead added successfully!");
    }

    /**
     * Displays all stored leads, including their calculated priorities.
     * Shows a message if no leads have been added.
     */
    public static void  viewAllLeads(){
        // Check whether the collection contains any leads
        if (leads.isEmpty()) {
            System.out.println(
                    "No leads found. Please add a lead first."
            );
            return;
        }
        System.out.println("\n========== All Leads ==========");

        for (int i = 0; i < leads.size(); i++) {
            Lead lead = leads.get(i);

            System.out.println("\nLead #" + (i + 1));
            System.out.println("Name: " + lead.getFullName());
            System.out.println("Email: " + lead.getEmail());
            System.out.println("Score: " + lead.getScore());

            // Calculate priority from the score
            System.out.println(
                    "Priority: " + lead.calculatePriority()
            );
        }
    }

    // Checks whether an email follows a basic email format.
    private static boolean isValidEmail(String email) {
        // Check for text before @, a domain, a dot, and a 2+ letter suffix.
        String emailRegex =
                "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(emailRegex);
    }
}