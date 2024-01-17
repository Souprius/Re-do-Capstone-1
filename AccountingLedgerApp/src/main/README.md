                                                  
WELCOME
=======================================================================================================================

This is a Banking app made by Supriya Roberson. Some pages include a **_Home Screen_**, **_Ledger Screen_** and a **_Reporting Screen_**.
In our application, you can add deposits and make payments as well as generate a *plethora* of reports. 

![img_1.png](img_1.png)
![img_2.png](img_2.png)
![img_3.png](img_3.png)

**Requirements:**
[x] Include Transactions.csv
[x] Multiple Screens
[x] Reporting function
[x] System Exit
[x] Utilize code we've learned and new code
[x] Arrays or ArrayList need to be present


To go into detail, the home screen is where we start. You can make your payments and add deposits there.
Then we move on to our Ledger, where you can review you deposits and payments separately. 
From the Ledger screen, we access Reports.

On the Reporting screen, we can pull a few different options. There is month to date, previous month, previous year,
year to date and also a custom vendor search. 

In creating this code, I was able to learn about different kinds of parsing and a LocalDate method. 
This allowed me to adjust the time frames needed for the reporting. 

My favorite piece of code, would have to be in my Main class. I was able to create a User Interface class with most of the options
and call it from the main page. Very simple and concise which is always nice to look at. 

Code Below: 

public class Main {
public static void main(String[] args) {
System.out.println("Welcome to Supriya Federal Credit Union");

       UserInterface ui = new UserInterface();
       ui.homeOptions();

    }
}