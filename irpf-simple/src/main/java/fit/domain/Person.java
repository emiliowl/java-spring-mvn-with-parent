package fit.domain;

public class Person {
    private final double totalSalary;
    private final int dependentsNumber;

    public Person(double totalSalary, int dependentsNumber) {
        this.totalSalary = totalSalary;
        this.dependentsNumber = dependentsNumber;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public int getDependentsNumber() {
        return dependentsNumber;
    }
}
