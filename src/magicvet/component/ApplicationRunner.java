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
            Client client= clientService.registerNewClient();
            if (client != null) {
                System.out.println("Do you want to add your pet now? (Y / N)");
                String answer = Main.SCANNER.nextLine();

                if (answer.equalsIgnoreCase("Y")) {
                    System.out.println("Adding a new pet.");

                    Pet pet = petService.registerNewPet();
                    if (pet != null) {
                        client.setPet(pet);
                        pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                        System.out.println(pet.getSex() + " " + pet.getType() + " " + pet.getName() + " has been added for " + pet.getOwnerName());
                    }

                    System.out.println(client);
                }
            }
        }
    }
}