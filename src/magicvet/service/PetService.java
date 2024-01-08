package magicvet.service;

import magicvet.Main;
import magicvet.model.Cat;
import magicvet.model.Dog;
import magicvet.model.Pet;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";

    public Pet registerNewPet() {
        Pet pet = null;

        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        if (DOG_TYPE.equals(type)  || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);;
        }
        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog();
        pet.setType(type);

        System.out.println("Sex (male / female): ");
        pet.setSex(Main.SCANNER.nextLine());

        System.out.println("Age: ");
        pet.setAge(Main.SCANNER.nextInt());

        System.out.println("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        if (type.equals(DOG_TYPE)) {
            System.out.println("Size (xS / S / M / L / XL): ");
            ((Dog) pet).setSize(Main.SCANNER.nextLine());
        }

        return pet;
    }
}
