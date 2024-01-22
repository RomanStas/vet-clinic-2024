package magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Client {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM u, HH:mm");
    private String firstName;
    private String lastName;
    private String email;
    private Pet pet;
    private final LocalDateTime clientRegistrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "Client {firstName = " + firstName
                + ", lastName = " + lastName
                + ", email = " + email
                + ", clientRegistrationDate - " + clientRegistrationDate.format(formatter) + "}"
                + ",\nPet " + pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pet, client.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, pet);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getClientRegistrationDate() {
        return clientRegistrationDate.format(formatter);
    }
}