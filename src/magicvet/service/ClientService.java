package magicvet.service;

import magicvet.Main;
import magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static String EMAIL_PATTERN = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    private static String NAME_PATTERN = "([A-Za-z]+(`[A-Za-z])?)-?([A-Za-z]+(`[A-Za-z])?)?";
    public Client registerNewClient() {
        Client client = null;

        System.out.println("Please provide client details.");
        System.out.println("Email: ");
        String email = Main.SCANNER.nextLine();

        if (isEmailValid(email)) {
            System.out.println("First name: ");
            String firstName = Main.SCANNER.nextLine();

            if (isNameValid(firstName)) {
                System.out.println("Last name: ");
                String lastName = Main.SCANNER.nextLine();

                if (isNameValid(lastName)) {
                    client = buildClient(firstName, lastName, email);
                    System.out.println("New client: " + client.getFirstName() + " "
                            + client.getLastName()
                            + " (" + client.getEmail() + ")");
                } else {
                    System.out.println("Provided last name is invalid.");
                }
            } else {
                System.out.println("Provided first name is invalid.");
            }
        } else {
            System.out.println("Provided email is invalid.");
        }

        return client;
    }

    static Client buildClient(String firstName, String lastName, String email) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        return client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
