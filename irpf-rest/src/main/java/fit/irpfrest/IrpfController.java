package fit.irpfrest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.core.IrpfCalculator;
import fit.domain.Person;
import fit.irpfrest.view.PersonVm;

@RestController
@RequestMapping("/irpf")
public class IrpfController {

  @PostMapping("/person")
  public Person createPerson(@RequestBody PersonVm p) {
    return new Person(p.getTotalSalary(), p.getDependentsNumber());
  }

  @PostMapping("/calculate")
  public double calculate(@RequestBody PersonVm person) {
    var year = Calendar.getInstance().get(Calendar.YEAR);
    var irpfCalculator = new IrpfCalculator(year, person.getTotalSalary(), person.getDependentsNumber());

    var decimal = BigDecimal.valueOf(irpfCalculator.calculate());
    decimal = decimal.setScale(2, RoundingMode.HALF_UP);
    return decimal.doubleValue();
  }

}
