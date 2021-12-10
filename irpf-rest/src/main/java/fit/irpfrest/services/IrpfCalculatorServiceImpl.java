package fit.irpfrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.core.IrpfCalculator;
import fit.domain.Person;
import fit.irpfrest.models.CurrentDate;
import fit.irpfrest.services.abstracts.IrpfCalculatorService;

@Service
public class IrpfCalculatorServiceImpl implements IrpfCalculatorService {
    @Autowired
    private CurrentDate currentDate;
    
    public IrpfCalculatorServiceImpl() {
        super();
    }

    @Override
    public double calculate(Person person) {
        var calculator = new IrpfCalculator(currentDate.getYear(), 
            person.getTotalSalary(),
            person.getDependentsNumber());

        return calculator.calculate();
    }
}
