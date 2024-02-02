package magicvet.component;

import magicvet.Main;
import magicvet.model.Client;
import magicvet.model.Pet;
import magicvet.service.ClientService;
import magicvet.service.PetService;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                registerPets(client);
                System.out.println(client);
            }
        }
    }

    private void registerPets(Client client) {
        boolean continueAddPets = true;
        while (continueAddPets) {
            addPet(client);

            System.out.print("Do you want to add more pets for the current client? (Y/N): ");
            String answer = Main.SCANNER.nextLine();

            if ("n".equalsIgnoreCase(answer)) {
                continueAddPets = false;
            }
        }
    }

    private void addPet(Client client) {
        System.out.println("Adding a new pet.");

        Pet pet = petService.registerNewPet();
        if (pet != null) {
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
            System.out.println(pet.getSex() + " " + pet.getType() + " " + pet.getName() + " has been added for " + pet.getOwnerName());
        }
    }
}