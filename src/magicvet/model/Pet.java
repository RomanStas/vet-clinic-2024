package magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {

    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm MM/dd/yyyy");

    private String type;
    private String sex;
    private int age;
    private String name;
    private String ownerName;
    private HealthState health;

    private final LocalDateTime petRegistrationDate = LocalDateTime.now();

    public Pet() {
    }

    public Pet(HealthState health) {
        this.health = health;
    }

    public HealthState getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "{"
                + "type = " + type
                + ", sex = " + sex
                + ", age = " + age
                + ", name = " + name
                + ", ownerName = " + ownerName
                + ", petRegistrationDate - " + petRegistrationDate.format(formatter)
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDateTime getPetRegistrationDate() {
        return petRegistrationDate;
    }


    public enum HealthState {
        EMERGENCY(1),
        BAD(2),
        NORMAL(3),
        GOOD(4),
        WELL(5),
        VERY_WELL(6);
        private final int value;

        HealthState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}