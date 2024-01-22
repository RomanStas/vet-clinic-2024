package magicvet.service;

import magicvet.Main;
import magicvet.model.Cat;
import magicvet.model.Dog;
import magicvet.model.Pet;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";
    private static final String SEX_MALE = "male";
    private static final String SEX_FEMALE = "female";
    private static final String UNKNOWN_SEX = "Unknown Sex";

    public Pet registerNewPet() {
        Pet pet = null;
        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        if (DOG_TYPE.equalsIgnoreCase(type)  || CAT_TYPE.equalsIgnoreCase(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }
        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equalsIgnoreCase(CAT_TYPE) ? new Cat() : new Dog();
        pet.setType(type);

        System.out.print("Sex (male / female): ");
        String sex = Main.SCANNER.nextLine();
        if (SEX_MALE.equalsIgnoreCase(sex) || SEX_FEMALE.equalsIgnoreCase(sex)) {
            pet.setSex(sex);
        } else {
            System.out.println("Unknown sex: " + sex);
            pet.setSex(UNKNOWN_SEX);
        }

        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextInt());
        Main.SCANNER.nextLine();

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        if (type.equalsIgnoreCase(DOG_TYPE)) {
            System.out.print("Size (XS / S / M / L / XL): ");
            String size = Main.SCANNER.nextLine();
            ((Dog) pet).setSize(Dog.Size.valueOf(size));
        }

        return pet;
    }
}