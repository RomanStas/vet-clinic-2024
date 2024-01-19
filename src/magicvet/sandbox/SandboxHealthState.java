package magicvet.sandbox;

import magicvet.model.Dog;
import magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandboxHealthState {

    public static void main(String[] args) {
        Pet[] pets = {
                new Dog(Pet.HealthState.GOOD),
                new Dog(Pet.HealthState.WELL),
                new Dog(Pet.HealthState.EMERGENCY),
                new Dog(Pet.HealthState.VERY_WELL),
                new Dog(Pet.HealthState.NORMAL),
                new Dog(Pet.HealthState.BAD),
                new Dog(Pet.HealthState.NORMAL),
                new Dog(Pet.HealthState.VERY_WELL),
                new Dog(Pet.HealthState.WELL),
        };

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet pet1, Pet pet2) {
                return pet1.getHealth().getValue() - pet2.getHealth().getValue();
            }
        });

        for (Pet pet : pets) {
            System.out.println(pet.getHealth());
        }
    }
}
