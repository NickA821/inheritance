package labs.seven;

public class Counter {
    private boolean hasRolled;
    private int min;
    private int max;
    private int value;

    public Counter(int value, int min, int max) {
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public boolean hasRolledOver() {
        return this.hasRolled;
    }
    public int getMinValue() {
        return this.min;
    }
    public int getMaxValue() {
        return this.max;
    }
    public int getValue() {
        return this.value;
    }
    public void setValue(int newValue) {
        hasRolled = false;
        this.value = newValue;
    }

    public int compareTo(Counter other) {
        int finalTotal = 0;
        int firstDistance = this.max - this.min;
        int secondDistance = other.max - other.min;

        if (firstDistance > secondDistance) {
            finalTotal = 1;
        } else if (firstDistance < secondDistance) {
            finalTotal = -1;
        } else if (firstDistance == secondDistance) {
            if (this.value > other.value) {
                finalTotal = 1;
            }
            else if (this.value < other.value) {
                finalTotal = -1;
            }
        }
        return finalTotal;
    }

    public boolean equals(Counter other) {
        if (this.value == other.value && this.min == other.min && this.max == other.max) {
            return true;
        }
        else {
            return false;
        }

    }
    public void decrement() {
        hasRolled = false;
        this.value -= 1;
        if (this.value < this.min) {
            this.value = this.max;
            hasRolled = true;
        }


    }

    public void increment() {
        hasRolled = false;
        this.value += 1;
        if (this.value > this.max) {
            this.value = this.min;
            hasRolled = true;
        }
    }

}
