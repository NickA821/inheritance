package three;

public class LcdDisplay {
    private LcdDigit one;
    private LcdDigit ten;
    private LcdDigit hundred;

    public LcdDisplay() {
        this(0);
        //this.one = new three.LcdDigit();
        //this.ten = new three.LcdDigit();
        //this.hundred = new three.LcdDigit();
    }

    public LcdDisplay(int priorStrVal) {
        this.one = new LcdDigit(priorStrVal, 1);
        this.ten = new LcdDigit(priorStrVal, 10);
        this.hundred = new LcdDigit(priorStrVal, 100);
    }

    public int getDisplayValue() {
        int fullIntDisplay = ((hundred.getDigitValue() * 100) + (ten.getDigitValue() * 10) + one.getDigitValue());
        return fullIntDisplay;
    }

    public void setDisplayValue(int newValue) {
        this.hundred.setDigitValue(newValue, 100);
        this.ten.setDigitValue(newValue, 10);
        this.one.setDigitValue(newValue, 1);

    }

    public String toString() {
        String fullDisplay = String.valueOf(hundred.getDigitValue()) + String.valueOf(ten.getDigitValue()) +
                String.valueOf(one.getDigitValue());
        //System.out.println(fullDisplay);
        return fullDisplay;
    }

}


