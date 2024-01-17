package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {

    public void showAllItems(){ // print transactions
        ArrayList<Transactions> money = loadTransactions();

        for (Transactions action : money) {
            System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %.2f %n",
                    action.getDate(), action.getTime(), action.getDesc(), action.getVendor(), action.getAmount());
        }
    }

    public ArrayList<Transactions> loadTransactions() { // it only loads the transactions - no printing or anything

        ArrayList<Transactions> transactions = new ArrayList<>();

        try {
            FileInputStream bank = new FileInputStream("src/main/resources/transactions.csv");
            Scanner scanner = new Scanner(bank);

            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] transaction = line.split("\\|");

                String date = transaction[0];
                String time = transaction[1];
                String desc = transaction[2];
                String vendor = transaction[3];
                double amount = Double.parseDouble(transaction[4]);

                Transactions newAction = new Transactions(date, time, desc, vendor, amount);
                transactions.add(newAction);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find transactions. Let's try again later.");
        } catch (ArrayIndexOutOfBoundsException e){
        }
        return transactions;
    }

    public void addDeposit(){
        System.out.println("What is the date of transaction? Format: yyyy-MM-dd");
        String date = scanner.nextLine();

        System.out.println("What is the time of the transaction? Format: HH:MM:ss");
        String time = scanner.nextLine();

        System.out.println("What is a short description of the transaction?");
        String desc = scanner.nextLine();

        System.out.println("Who is the vendor?");
        String vendor = scanner.nextLine();

        System.out.println("What is the amount?");
        double amount = scanner.nextDouble();

        scanner.nextLine();

        try{
            FileWriter added = new FileWriter("src/main/resources/transactions.csv",true);

            added.write(date + "|" + time + "|" + desc + "|" + vendor + "|" + amount + "\n");
            added.close();

            System.out.println("Your deposit has been made. Thank you.");

        } catch(IOException ee){
            System.out.println("Unable to add deposit. Let's try again later.");
        }
    }

    Scanner scanner = new Scanner(System.in);
    public void makeAPayment(){

        System.out.println("What is the date of transaction? Format: yyyy-MM-dd");
        String dDate = scanner.nextLine();

        System.out.println("What is the time of the transaction? Format: HH:MM:ss");
        String dTime = scanner.nextLine();

        System.out.println("What is a short description of the transaction?");
        String dDesc = scanner.nextLine();

        System.out.println("Who is the vendor?");
        String dVendor = scanner.nextLine();

        System.out.println("What was the amount?");
        double dAmount = scanner.nextDouble();

        scanner.nextLine();

        try{
            FileWriter payment = new FileWriter("src/main/resources/transactions.csv",true);

            payment.write(dDate + "|" + dTime + "|" + dDesc + "|" + dVendor + "|" + dAmount + "\n");
            payment.close();

            System.out.println("Your payment has been added. Thank you.");
        }
        catch (IOException ex){
            System.out.println("Unable to add payment. Let's try again later.");
        }
    }

    public void showDeposit(){ //only entries that are deposits into the account
        ArrayList<Transactions> deposit = loadTransactions();
        for(Transactions sd: deposit){
            if(sd.getAmount() > 1){
                System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s \n",
                        sd.getDate(), sd.getTime(), sd.getDesc(), sd.getVendor(), sd.getAmount());
            }
        }
    }

    public void showPayments(){ //only negative entries
        ArrayList<Transactions> pay = loadTransactions();
        for(Transactions sp: pay){
            if(sp.getAmount() < 0){
                System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s \n",
                        sp.getDate(), sp.getTime(), sp.getDesc(), sp.getVendor(), sp.getAmount());
            }
        }

    }
}