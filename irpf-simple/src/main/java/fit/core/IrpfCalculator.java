package fit.core;

import fit.domain.Person;

public class IrpfCalculator {
  /**
   *
   */
  private Person person;
  private IrpfCalculatorOO calculator;

  public IrpfCalculator(int year, double totalSalary, int dependentsNumber) {
    this.person = new Person(totalSalary, dependentsNumber);
    this.calculator = new IrpfCalculatorOO(year, person);
  }

  public double calculateBaseSalary() {
    return this.calculator.getBaseSalary();
  }

  public double calculateDiscount() {
    return this.calculator.getTotalDiscount();
  }

  public double calculate() {
    return this.calculator.getValue();
  }
}
