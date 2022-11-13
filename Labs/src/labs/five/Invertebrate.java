package labs.five;

public class Invertebrate extends CaptiveAnimal {
    private String name;
    private int age;
    private String id;
    private String repType;

    public Invertebrate(String name, int age, String id, String repType) {
        super(name, age, id);
        this.repType = repType;
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
    public void setRep(String newRep) {
        this.repType = newRep;
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
    public String getRep() {
        return this.repType;
    }

    public boolean equals(Object other) {
        boolean isEquals;
        if(other == this) {
            isEquals = false;
        }
        else {
            isEquals = true;
        }
        if(other instanceof Invertebrate) {
            Invertebrate otherInvertebrate = (Invertebrate) other;
            if(super.equals(other) && this.repType.equals(otherInvertebrate.getRep())) {
                isEquals = true;
            }
            else {
                isEquals = false;
            }
        }
        else
        {
            isEquals = false;
        }
        return isEquals;
    }

    public String toString() {
        return super.toString() + ", Reproduction type = " + this.repType;
    }

}
