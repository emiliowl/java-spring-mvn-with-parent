package fit.irpfrest.factories;

import org.springframework.beans.factory.FactoryBean;

import fit.irpfrest.models.CurrentDate;

public class CurrentDateFactory implements FactoryBean<CurrentDate> {
    private final CurrentDate instance = new CurrentDate();

    @Override
    public CurrentDate getObject() throws Exception {
        return instance;
    }

    @Override
    public Class<?> getObjectType() {
        return CurrentDate.class;
    }

    public void config(int year) {
        this.instance.setYear(year);
    }
    
}
