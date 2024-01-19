package magicvet.model;

public class Dog extends Pet {

    private Size size;

    public Dog() {}

    public Dog(Size size) {
        this.size = size;
    }

    public Dog(int age) {
        this.setAge(age);
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public Dog(HealthState health) {
        super(health);
    }

    public enum Size {
        XS (1),
        S (2),
        M (3),
        L (4),
        XL (5),
        UNKNOWN (0);
        private final int value;
        Size(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
}