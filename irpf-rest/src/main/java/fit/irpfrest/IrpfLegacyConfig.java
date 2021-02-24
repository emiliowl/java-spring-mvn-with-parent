package fit.irpfrest;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fit.irpfrest.factories.CurrentDateFactory;
import fit.irpfrest.models.CurrentDate;

@Configuration
public class IrpfLegacyConfig {
    @Bean(name="currentDateFactory")
    public CurrentDateFactory currentDateFactory() {
        var year = Calendar.getInstance().get(Calendar.YEAR);
        var factory = new CurrentDateFactory();
        factory.config(year);
        return factory;
    }

    @Bean(name="currentDate")
    public CurrentDate getCurrentDate() throws Exception {
        var fac = currentDateFactory();
        return fac.getObject();
    }
}
