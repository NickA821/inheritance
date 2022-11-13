package labs.seven;

public class Clock {
    private ClockModel model;

    public Clock() {
        this.model = new ClockModel(12, 0, 0, "AM");
    }
    public Clock(int hour, int minute, int second) {
        this.model = new ClockModel(hour, minute, second, "AM");
    }
    public Clock(int hour, int minute, int second, String type) {
        this.model = new ClockModel(hour, minute, second, type);
    }

    public void setHour(int hour) {
        this.model.setHour(hour);
    }
    public void setMinute(int minute) {
        model.setMinute(minute);
    }
    public void setSecond(int second) {
        model.setSecond(second);
    }
    public void toggleAmPm() {
        if (model.getMeridies() == "PM") {
            model.setMeridies("AM");
        }
        else if (model.getMeridies() == "AM") {
            model.setMeridies("PM");
        }
    }

    public boolean equals(Clock other) {
        boolean isEqual = false;
        if (model.equals(other.model)) {
            isEqual = true;
        }
        return isEqual;
    }

    public int compareTo(Clock other) {
        return model.compareTo(other.model);
    }

    public void tick() {
        model.tock();
    }

    public String toString() {
        return model.getHourAsString() + ":" + model.getMinuteAsString() + ":" +
                model.getSecondAsString() + " " + model.getMeridies();
    }

}
