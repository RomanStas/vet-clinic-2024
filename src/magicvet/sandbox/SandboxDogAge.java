package magicvet.sandbox;

import magicvet.model.Dog;
import java.util.Arrays;
import java.util.Comparator;

public class SandboxDogAge {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(10),
                new Dog(5),
                new Dog(7),
                new Dog(8),
                new Dog(1),
                new Dog(2),
                new Dog(4),
                new Dog(6),
                new Dog(9),
                new Dog(3)
        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog dog1, Dog dog2) {
                return dog1.getAge() - dog2.getAge();
            }
        });

        for (Dog dog : dogs) {
            System.out.println(dog.getAge());
        }
    }

}