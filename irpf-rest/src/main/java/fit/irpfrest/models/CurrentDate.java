package fit.irpfrest.models;

public class CurrentDate {
    private int year;

    public CurrentDate() {
        super();
    }

    public CurrentDate(int year) {
        super();
        this.setYear(year);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
