package m4.firstattempt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tdd.m4.firstattempt.Portfolio;
import org.tdd.m4.firstattempt.Stock;

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

    @Test
    public void portfolioWithMultipleStock_calculatesTotalValue() {

        // Stock 1
        int microsoftQty = 10;
        double microsoftPx = 260;
        double microsoftValue = microsoftQty * microsoftPx;

        // Stock 2
        int appleQty = 1;
        double applePx = 150;
        double appleValue = appleQty * applePx;

        var portfolio = new Portfolio();
        portfolio.add(new Stock("MSFT", microsoftQty, microsoftPx));
        portfolio.add(new Stock("AAPL", appleQty, applePx));
        Assertions.assertEquals(microsoftValue + appleValue, portfolio.totalValue());
    }

    @Test
    public void portfolioWithAddedStockAtDifferentPrice_calculatesTotalValue() {


        // Stock 2
        int appleQty_1 = 1;
        double applePx_1 = 150;
        double appleValue_1 = appleQty_1 * applePx_1;

        // Stock 2
        int appleQty_2 = 2;
        double applePx_2 = 100;
        double appleValue_2 = appleQty_2 * applePx_2;

        var portfolio = new Portfolio();
        portfolio.add(new Stock("AAPL", appleQty_1, applePx_1));
        portfolio.add(new Stock("AAPL", appleQty_2, applePx_2));
        Assertions.assertEquals(appleValue_1 + appleValue_2, portfolio.totalValue());
    }
}
