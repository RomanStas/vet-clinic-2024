package magicvet.sandbox;

import magicvet.model.Dog;

import java.util.Arrays;
import java.util.Comparator;

public class SandboxDogSize {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.Size.M),
                new Dog(Dog.Size.S),
                new Dog(Dog.Size.UNKNOWN),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.L),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XS),
                new Dog(Dog.Size.S)
        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog dog1, Dog dog2) {
                return dog1.getSize().getValue() - dog2.getSize().getValue();
            }
        });

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

    }
}