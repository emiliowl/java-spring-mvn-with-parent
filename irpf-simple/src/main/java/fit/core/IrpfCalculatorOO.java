package fit.core;

import fit.application.abstractions.DiscountTable;
import fit.application.abstractions.RateTable;
import fit.application.factories.DiscountTableFactory;
import fit.application.factories.RateTableFactory;
import fit.domain.Person;

public class IrpfCalculatorOO {
    private final int year;
    private final RateTable rateTable;
    private final DiscountTable discountTable;
    private final Person person;

    public IrpfCalculatorOO(int year, Person person) {
        this.year = year;
        this.person = person;
        this.rateTable = RateTableFactory.build(year);
        this.discountTable = DiscountTableFactory.build(year);
    }

    public double getBaseSalary() {
        var totalSalary = this.person.getTotalSalary();
        var inssValue = this.rateTable.getInssValue(totalSalary);
        var dependentsDiscount = this.discountTable.getDependentsValue(this.person.getDependentsNumber());

        return totalSalary - inssValue - dependentsDiscount;
    }

    public double getTotalDiscount() {
        var totalSalary = this.person.getTotalSalary();
        var inssValue = this.rateTable.getInssValue(totalSalary);
        var dependentsDiscount = discountTable.getDependentsValue(this.person.getDependentsNumber());
        var exemptionValue = this.discountTable.getExemptionValue();

        return inssValue + dependentsDiscount + exemptionValue;
    }

    public double getValue()  {
        var netSalary = this.person.getTotalSalary() - this.getTotalDiscount();
        var taxValue = this.rateTable.getRate(netSalary);

        return netSalary * taxValue;
    }


}
