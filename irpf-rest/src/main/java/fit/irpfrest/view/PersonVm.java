package fit.irpfrest.view;

import fit.domain.Person;

public class PersonVm extends Person {
  public PersonVm() {
    super(0, 0);
  }

  public PersonVm(double salary, int dependents) {
    super(salary, dependents);
  }
}
