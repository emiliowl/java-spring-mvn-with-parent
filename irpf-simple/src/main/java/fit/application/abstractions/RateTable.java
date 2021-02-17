package fit.application.abstractions;

public interface RateTable {
    double getInssValue(double baseSalary);
    double getRate(double baseSalary);
}
