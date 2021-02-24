package fit.irpfrest;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.domain.Person;
import fit.irpfrest.services.abstracts.IrpfCalculatorService;
import fit.irpfrest.view.PersonVm;

@RestController
@RequestMapping("/irpf")
public class IrpfController {
  @Autowired
  private IrpfCalculatorService irpfCalculatorService;


  @PostMapping("/person")
  public Person createPerson(@RequestBody PersonVm p) {
    return new Person(p.getTotalSalary(), p.getDependentsNumber());
  }

  @PostMapping("/calculate")
  public double calculate(@RequestBody PersonVm person) {
    var decimal = BigDecimal.valueOf(irpfCalculatorService.calculate(person));
    decimal = decimal.setScale(2, RoundingMode.HALF_UP);
    
    return decimal.doubleValue();
  }

}
