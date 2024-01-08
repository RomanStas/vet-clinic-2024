package magicvet.sandbox;

import magicvet.comparator.DogAgeComparator;
import magicvet.model.Dog;

import java.util.Arrays;

public class SandboxAge {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(10),
                new Dog(5),
                new Dog(7),
                new Dog(8),
                new Dog(1),
                new Dog(3)
        };

        Arrays.sort(dogs, new DogAgeComparator());

        for (Dog dog : dogs) {
            System.out.println(dog.getAge());
        }
    }

}
