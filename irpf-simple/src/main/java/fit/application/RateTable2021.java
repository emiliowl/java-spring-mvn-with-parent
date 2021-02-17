package fit.application;

import fit.application.abstractions.RateTable;

public class RateTable2021 implements RateTable {
    public static final double INSS_VALUE = 0.11;

    @Override
    public double getInssValue(double salary) {
        return INSS_VALUE * salary;
    }

    @Override
    public double getRate(double netSalary) {
        if (netSalary <= 0.00) return 0.0;
        if (netSalary <= 922.67) return 0.075;
        if (netSalary <= 1847.07) return 0.15;
        if (netSalary <= 2760.70) return 0.225;
        return 0.275;
    }
}
