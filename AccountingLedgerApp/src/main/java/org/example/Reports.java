package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Reports {
    //month to date
    //previous month
    //year to date
    //previous year
Ledger l = new Ledger();
    public void monthToDate() {
        ArrayList<Transactions> monthreport = l.loadTransactions();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
            Scanner banner = new Scanner(fileInputStream);

            String input;

            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a comma-separated format)
                String[] transaction = input.split("\\|");
                if (transaction.length >= 2) {
                    String transactionDate = transaction[0]; // Assuming the date is in the first column

                    // Assuming the date format is "yyyy-MM-dd", e.g., "2023-10-26"
                    if (transactionDate.matches("\\d{4}-01-\\d{2}")) {
                        System.out.println(input);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");

    static Ledger l = new Ledger();
    public static void monthToDate() {
        //declaring the list-
        List<Transactions> transactions = l.loadTransactions();

        // Sort transactions by date using Collections.sort
        transactions.sort(Comparator.comparing(Transactions::getDate));
        // Display the sorted transactions
        for (Transactions transaction : transactions) {
            System.out.println(transaction);

        }
    }

    public void previousMonth() {
        ArrayList<Transactions> previousreport = l.loadTransactions();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
            Scanner banner = new Scanner(fileInputStream);

            String input;

            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a comma-separated format)
                String[] transaction = input.split("\\|");
                if (transaction.length >= 2) {
                    String transactionDate = transaction[0]; // Assuming the date is in the first column

                    // Assuming the date format is "yyyy-MM-dd", e.g., "2023-10-26"
                    if (transactionDate.matches("\\d{4}-12-\\d{2}")) {
                        System.out.println(input);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        }
    }

    public void yearToDate() {
        ArrayList<Transactions> yearreport = l.loadTransactions();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
            Scanner banner = new Scanner(fileInputStream);

            String input;

            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a comma-separated format)
                String[] transaction = input.split("\\|");
                if (transaction.length >= 2) {
                    String transactionDate = transaction[0]; // Assuming the date is in the first column

                    // Assuming the date format is "yyyy-MM-dd", e.g., "2023-10-26"
                    if (transactionDate.matches("2024-\\d{2}-\\d{2}")) {
                        System.out.println(input);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        }
    }


    public void previousYear() {
        ArrayList<Transactions> previousyear = l.loadTransactions();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
            Scanner banner = new Scanner(fileInputStream);

            String input;

            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a comma-separated format)
                String[] transaction = input.split("\\|");
                if (transaction.length >= 2) {
                    String transactionDate = transaction[0]; // Assuming the date is in the first column

                    // Assuming the date format is "yyyy-MM-dd", e.g., "2023-10-26"
                    if (transactionDate.matches("2023-\\d{2}-\\d{2}")) {
                        System.out.println(input);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        }
    }

    //search by vendor
    public void searchVendor(String vendor){
        ArrayList<Transactions> vendoreport = l.loadTransactions();
            //should iterate to search for vendor
        try{
            for(Transactions t : vendoreport){
                if(t.getVendor().equalsIgnoreCase(vendor)){
                    System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s \n",
                            t.getDate(), t.getTime(), t.getDesc(), t.getVendor(), t.getAmount());
                }
            }
        } catch (Exception s){
            System.out.println("Unable to generate report. Let's try again.");
        }

    }

    // Custom Search
    public void customSearch() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Start Date (YYYY-MM-DD): ");
        String startDateInput = scanner.nextLine();
        LocalDate startDate = startDateInput.isEmpty() ? null : LocalDate.parse(startDateInput);

        System.out.println("Enter End Date (YYYY-MM-DD): ");
        String endDateInput = scanner.nextLine();
        LocalDate endDate = endDateInput.isEmpty() ? null : LocalDate.parse(endDateInput);

        System.out.println("Enter Description: ");
        String description = scanner.nextLine();

        System.out.println("Enter Vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter Amount: ");
        double amount = 0.0;
        try {
            String amountInput = scanner.nextLine();
            if (!amountInput.isEmpty()) {
                amount = Double.parseDouble(amountInput);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format. Skipping amount filter.");
        }

        ArrayList<Transactions> customReport = l.loadTransactions();

        try {
            for (Transactions t : customReport) {
                LocalDate transactionDate = LocalDate.parse(t.getDate());

                boolean dateInRange = (startDate == null || transactionDate.isEqual(startDate) || transactionDate.isAfter(startDate))
                        && (endDate == null || transactionDate.isEqual(endDate) || transactionDate.isBefore(endDate));

                boolean matchesDescription = description == null || t.getDesc().equalsIgnoreCase(description);
                boolean matchesVendor = vendor == null || t.getVendor().equalsIgnoreCase(vendor);
                boolean matchesAmount = amount == 0 || t.getAmount() == amount;

                if (dateInRange && matchesDescription && matchesVendor && matchesAmount) {
                    System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %s \n",
                            t.getDate(), t.getTime(), t.getDesc(), t.getVendor(), t.getAmount());
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to generate report. Let's try again.");
        }
    }
}
