package labs.five;

public class Vertebrate extends CaptiveAnimal {
    private String name;
    private int age;
    private String id;
    private String repType;
    private String skelType;

    public Vertebrate(String name, int age, String id, String repType, String skelType) {
        super(name, age, id);
        this.repType = repType;
        this.skelType = skelType;
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
    public void setSkelType(String newSkel) {
        this.skelType = newSkel;
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
    public String getSkelType() {
        return this.skelType;
    }

    public boolean equals(Object other) {
        boolean isEquals;
        if(other == this) {
            isEquals = false;
        }
        else {
            isEquals = true;
        }
        if(other instanceof Vertebrate) {
            Vertebrate otherVertebrate = (Vertebrate) other;
            if(super.equals(other) && this.skelType.equals(otherVertebrate.getSkelType())) {
                isEquals = true;
            }
            else
            {
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
        return super.toString() + " Reproduction type = " + this.repType + ", Skeleton type = " + this.skelType;
    }
}
