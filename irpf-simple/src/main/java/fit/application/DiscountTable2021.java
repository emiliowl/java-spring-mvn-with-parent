package fit.application;

import fit.application.abstractions.DiscountTable;

public class DiscountTable2021 implements DiscountTable {
    private static final double DEPENDENTS_DISCOUNT = 189.59;
    private static final double EXEMPTION_VALUE = 1903.98;

    @Override
    public double getExemptionValue() {
        return EXEMPTION_VALUE;
    }

    @Override
    public double getDependentsValue(int number) {
        return number * DEPENDENTS_DISCOUNT;
    }
}
