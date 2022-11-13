package labs.five;

public class Animal {
    private String name;
    private int age;

    public Animal(String insName, int insAge) {
        this.name = insName;
        this.age = insAge;
    }

    public void setName(String newName) {
        this.name = newName;
    }
    public void setAge(int newAge) {
        this.age = newAge;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    public boolean equals(Object other) {
        boolean isEquals = false;
        if(other == this) {
            isEquals = false;
        }
        else {
            isEquals = true;
        }
        if(other instanceof Animal) {
            Animal otherAnimal = (Animal) other;
            if(name.equals(otherAnimal.name) && otherAnimal.getAge() == this.age) {
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
        return "Name = " + this.name + ", Age = " + this.age;
        }


    public static void main(String[] args) {
    }
}
