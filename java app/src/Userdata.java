import java.util.ArrayList;
import java.util.Scanner;

public class Userdata {

    static ArrayList<String[]> userDatabase = new ArrayList<String[]>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Welcome to the database manager, please Input the number of the desired process:");
            System.out.println("Enter 1 to add user to application");
            System.out.println("Enter 2 to view the users information");
            System.out.println("Enter 3 to change users information");
            System.out.println("Enter 4 to remove user information");
            System.out.println("Enter 5 to end process");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addUser(input);
                    break;
                case 2:
                    viewUserData();
                    break;
                case 3:
                    modifyUserData(input);
                    break;
                case 4:
                    deleteUserData(input);
                    break;
                case 5:
                    System.out.println("Ending process...please wait.");
                    running = false;
                    break;
                default:
                    System.out.println("choice does not appear on our database, please try again.");
            }
        }

        input.close();
    }

    public static void addUser(Scanner input) {
        String[] userData = new String[3];

        System.out.print("Please, enter your name: ");
        userData[0] = input.next();

        System.out.print("next, enter your email: ");
        userData[1] = input.next();

        System.out.print("and lastly, enter your phone number: ");
        userData[2] = input.next();

        userDatabase.add(userData);

        System.out.println("User information added to database sucessfully!");
    }

    public static void viewUserData() {
        if (userDatabase.isEmpty()) {
            System.out.println("Unfortunately, this doesn't appear on our database");
        } else {
            for (int i = 0; i < userDatabase.size(); i++) {
                String[] userData = userDatabase.get(i);
                System.out.println("User #" + (i + 1));
                System.out.println("Name: " + userData[0]);
                System.out.println("Email: " + userData[1]);
                System.out.println("Telephone: " + userData[2]);
                System.out.println();
            }
        }
    }

    public static void modifyUserData(Scanner input) {
        System.out.print("Enter the user number you want to change the information: ");
        int userNumber = input.nextInt();

        if (userNumber <= 0 || userNumber > userDatabase.size()) {
            System.out.println("Unfortunately, this doesn't appear on our database");
            return;
        }

        String[] userData = userDatabase.get(userNumber - 1);

        System.out.println("Enter new information for this user (leave blank for no change):");

        System.out.print("Name (" + userData[0] + "): ");
        String name = input.next();
        if (!name.equals("")) {
            userData[0] = name;
        }

        System.out.print("Email (" + userData[1] + "): ");
        String email = input.next();
        if (!email.equals("")) {
            userData[1] = email;
        }

        System.out.print("Telephone (" + userData[2] + "): ");
        String telephone = input.next();
        if (!telephone.equals("")) {
            userData[2] = telephone;
        }

        userDatabase.set(userNumber - 1, userData);

        System.out.println("User information modified successfully!");
    }

    public static void deleteUserData(Scanner input) {
        System.out.print("Enter the user number you want to remove: ");
        int userNumber = input.nextInt();

        if (userNumber <= 0 || userNumber > userDatabase.size()) {
            System.out.println("Unfortunately, this doesn't appear on our database");
            return;
        }

        userDatabase.remove(userNumber - 1);

        System.out.println("User information removed successfully.");
    }}

