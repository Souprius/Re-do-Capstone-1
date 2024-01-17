package org.example;

import java.time.LocalDate;
import java.util.ArrayList;


public class Reports {
    //month to date
    //previous month
    //year to date
    //previous year
Ledger l = new Ledger();
    public void monthToDate(){
        ArrayList<Transactions> monthreport = l.loadTransactions();
        try{
            LocalDate mTD = LocalDate.now();
            for(Transactions t : monthreport){
                if(mTD.isBefore(LocalDate.parse(t.getDate()))){
                    System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s \n",
                            t.getDate(), t.getTime(), t.getDesc(), t.getVendor(), t.getAmount());
                }
            }
        } catch(Exception x){
            System.out.println("Unable to generate report. Let's Try again.");
        }

    }

    public void previousMonth(){
        ArrayList<Transactions> previousreport = l.loadTransactions();

        try{
            LocalDate previous = LocalDate.now().minusDays(30);
            for(Transactions t : previousreport){
                if(previous.isBefore(LocalDate.parse(t.getDate())) && !previous.isAfter(LocalDate.now())){
                    System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s \n",
                            t.getDate(), t.getTime(), t.getDesc(), t.getVendor(), t.getAmount());
                }
            }

        } catch (Exception i){
            System.out.println("Unable to generate report. Let's Try again.");
        }

    }

    public void yearToDate(){
        ArrayList<Transactions> yearreport = l.loadTransactions();

        try {
            LocalDate ytd = LocalDate.now().minusYears(1);
            for(Transactions t : yearreport){
                if(ytd.isBefore(LocalDate.parse(t.getDate())) && !ytd.isAfter(LocalDate.now())){
                    System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s \n",
                            t.getDate(), t.getTime(), t.getDesc(), t.getVendor(), t.getAmount());
                }
            }

        } catch (Exception ex){
            System.out.println("Unable to generate report. Let's Try again.");
        }
    }

    public void previousYear(){
        ArrayList<Transactions> previousyear = l.loadTransactions();

        try{
            LocalDate py = LocalDate.now().minusYears(1);
            for(Transactions t: previousyear){
                LocalDate getDate = LocalDate.parse(t.getDate());
                if(py.isBefore(LocalDate.now()) && getDate.isBefore(LocalDate.now())){
                    System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s \n",
                            t.getDate(), t.getTime(), t.getDesc(), t.getVendor(), t.getAmount());
                }
            }

        }catch(Exception y){
            System.out.println("Unable to generate report. Let's Try again.");
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
}
