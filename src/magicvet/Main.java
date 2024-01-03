
package magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "[A-Z][a-z]*-?([A-Z][a-z]*)?";

    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }
    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password");
            }
        }
        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Applicaion has been blocked.");
        return accepted;
    }
    static void registerNewClient() {
        System.out.println("Please provide client details.");
        System.out.println("Email: ");
        String email = SCANNER.nextLine();

        if (isEmailValid(email)) {
            System.out.println("First name (with first uppercase letter in each word): ");
            String firstName = SCANNER.nextLine();

            if (isNameValid(firstName)) {
                System.out.println("Last name (with first uppercase letter in each word): ");
                String lastName = SCANNER.nextLine();

                if (isNameValid(lastName)) {
                    Client client = buildClient(firstName, lastName, email);
                    System.out.println("New client: " + client.firstName
                            + " " + client.lastName
                            + " (" + client.email + ")");
                } else {
                    System.out.println("Provided last name is invalid.");
                }
            } else {
                System.out.println("Provided first name is invalid.");
            }
        } else {
            System.out.println("Provided email is invalid.");
        }
    }

    static Client buildClient(String firstName, String lastName, String email) {
        Client client = new Client();
        client.email = email;
        client.firstName = firstName;
        client.lastName = lastName;

        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}