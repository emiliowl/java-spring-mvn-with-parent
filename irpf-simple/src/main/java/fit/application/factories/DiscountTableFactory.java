package fit.application.factories;

import fit.application.DiscountTable2021;
import fit.application.abstractions.DiscountTable;

public abstract class DiscountTableFactory {
    public static DiscountTable build(int year) {
        if (year == 2021) return new DiscountTable2021();

        return null;
    }
}
