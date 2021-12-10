package fit.application.factories;

import fit.application.RateTable2021;
import fit.application.abstractions.RateTable;

public abstract class RateTableFactory {
    public static RateTable build(int year) {
        if (year == 2021) return new RateTable2021();

        return null;
    }
}
