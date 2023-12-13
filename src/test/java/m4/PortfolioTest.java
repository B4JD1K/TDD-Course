package m4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PortfolioTest {

    @Test
    public void emptyPortfolio_hasZeroValue() {
        var portfolio = new Portfolio();
        Assertions.assertEquals(0, portfolio.totalValue());
    }

    @Test
    public void portfolioWithOneStock_calculatesTotalValue() {
        int qty = 10;
        double px = 260;
        double value = qty * px;

        var portfolio = new Portfolio();
        portfolio.add(new Stock("MSFT", qty, px));
        Assertions.assertEquals(value, portfolio.totalValue());
    }
}
