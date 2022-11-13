package labs.five;

public class CaptiveAnimal extends Animal {
    private String name;
    private int age;
    private String id;

    public CaptiveAnimal(String insName, int insAge, String insId) {
        super(insName, insAge);
        this.id = insId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        boolean isEquals;
        if (other == this) {
            isEquals = false;
        } else {
            isEquals = true;
        }
        if (other instanceof CaptiveAnimal) {
            CaptiveAnimal otherCaptive = (CaptiveAnimal) other;
            if (super.equals(other) && this.id.equals(otherCaptive.getId())) {
                isEquals = true;
            } else {
                isEquals = false;
            }
        } else {
            isEquals = false;
        }
        return isEquals;
    }

    public String toString() {
        return super.toString() + ", idNumber = " + this.id;
    }
}
