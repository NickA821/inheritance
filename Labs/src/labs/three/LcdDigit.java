package three;

public class LcdDigit {
    private int displayVal;

    public LcdDigit() {
        this.displayVal = 0;
    }

    public LcdDigit(int value, int place) {
        this.displayVal = (value / place) % 10;

    }

    public int getDigitValue() {
        return this.displayVal;
    }

    public int setDigitValue(int value, int place) {
        this.displayVal = (value / place) % 10;
        return displayVal;
    }

    public String toString() {
        String strVal = String.valueOf(displayVal);
        return strVal;
    }
}
