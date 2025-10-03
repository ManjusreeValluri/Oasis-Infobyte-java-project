/*---------------------------------------------------/
 Project Title: Online Reservation System.

 Description : The Online Reservation System is a Java-based console application that allows users to reserve and cancel train tickets easily.
  It provides a secure login system, a reservation module to enter passenger and journey details, and a cancellation module to cancel tickets using a PNR number.
   The system uses simple data storage with HashMap and automatically generates unique PNR numbers for each booking. 
   This project demonstrates the working of a real-life reservation process in a simplified way.
    
   Name: Manjusree Valluri

 Concepts used :  Java Basics: Variables, Input/Output, and Data Types

                  Control Statements: if-else, switch-case, and loops

                  Object-Oriented Programming: Classes and Objects (Reservation class)

                  Collections: HashMap to store and manage reservations

                  User Authentication & Menu-Driven Console Interface
------------------------------------------------------*/



import java.util.*;

class Reservation {
    String name, trainNo, trainName, classType, from, to, date;
    int age, pnr;

    Reservation(String n, int a, String tNo, String tName, String c, String f, String to, String d, int p) {
        name = n; age = a; trainNo = tNo; trainName = tName; classType = c;
        from = f; this.to = to; date = d; pnr = p;
    }
}

public class OnlineReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Reservation> data = new HashMap<>();
    static int pnrCounter = 1000;

    // Login
    static boolean login() {
        System.out.print("User ID: ");
        String id = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        return id.equals("admin") && pass.equals("12345");
    }

    // Make Reservation
    static void reserve() {
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
        System.out.print("Train No: "); String tNo = sc.nextLine();
        System.out.print("Train Name: "); String tName = sc.nextLine();
        System.out.print("Class Type: "); String c = sc.nextLine();
        System.out.print("From: "); String f = sc.nextLine();
        System.out.print("To: "); String to = sc.nextLine();
        System.out.print("Date(dd-mm-yyyy): "); String d = sc.nextLine();

        int pnr = pnrCounter++;
        data.put(pnr, new Reservation(name, age, tNo, tName, c, f, to, d, pnr));
        System.out.println("✅ Reservation Done! PNR: " + pnr + "\n");
    }

    // Cancel Reservation
    static void cancel() {
        System.out.print("Enter PNR: ");
        int pnr = sc.nextInt(); sc.nextLine();
        Reservation r = data.get(pnr);
        if (r != null) {
            System.out.println("Reservation Found: " + r.name + " | Train: " + r.trainNo + " - " + r.trainName);
            System.out.print("Confirm Cancel (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) {
                data.remove(pnr);
                System.out.println("❌ Reservation Cancelled\n");
            }
        } else {
            System.out.println("PNR Not Found!\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Online Reservation System ===\n");
        if (!login()) { System.out.println("Login Failed ❌"); return; }

        while (true) {
            System.out.println("1. Reserve  2. Cancel  3. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1: reserve(); break;
                case 2: cancel(); break;
                case 3: System.out.println("Thanks for using!"); return;
                default: System.out.println("Invalid Choice!\n");
            }
        }
    }
}


/*   -----OUTPUT-----

=== Online Reservation System ===

User ID: admin
Password: 12345
1. Reserve  2. Cancel  3. Exit
Choice: 1
Name: manu
Age: 23
Train No: 2
Train Name: godavari express
Class Type: general
From: hyderabad
To: bengluru
Date(dd-mm-yyyy): 23-09-2025
? Reservation Done! PNR: 1000

1. Reserve  2. Cancel  3. Exit
Choice: 2
Enter PNR: 1000
Reservation Found: manu | Train: 2 - gidavari
Confirm Cancel (yes/no): yes
? Reservation Cancelled

1. Reserve  2. Cancel  3. Exit
Choice: 3
Thanks for using!

*/