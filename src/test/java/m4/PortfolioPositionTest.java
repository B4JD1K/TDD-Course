package m4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tdd.m4.Portfolio;
import org.tdd.m4.Position;
import org.tdd.m4.Stock;

public class PortfolioPositionTest {
    private final String MICROSOFT = "MSFT";
    private final String APPLE = "AAPL";
    private final String ORACLE = "ORCL";

    @Test
    public void emptyPortfolio_zeroPositions() {
        var portfolio = new Portfolio();
        Assertions.assertEquals(0, portfolio.getAllPositions().size());
    }

    @Test
    public void portfolioWithOnePosition_ReturnsThatPosition() {
        var portfolio = new Portfolio();

        String symbol = "MSFT";

        portfolio.add(new Position(new Stock(symbol), 10, 260));
        Assertions.assertEquals(1, portfolio.getAllPositions().size());

        Assertions.assertEquals(10, portfolio.getPosition(symbol).getQty());
        Assertions.assertEquals(260, portfolio.getPosition(symbol).getAveragePx());
        Assertions.assertEquals(2600, portfolio.getPosition(symbol).getValue());
    }

    @Test
    public void portfolioWithTwoDifferentPositions_ReturnsThosePositions() {
        var portfolio = new Portfolio();

        String apple = "AAPL";

        portfolio.add(position(MICROSOFT, 10, 260));
        portfolio.add(position(apple, 2, 150));

        Assertions.assertEquals(2, portfolio.getAllPositions().size());

        //msft
        var microsoftPosition = portfolio.getPosition(MICROSOFT);
        Assertions.assertEquals(10, microsoftPosition.getQty());
        Assertions.assertEquals(260, microsoftPosition.getAveragePx());
        Assertions.assertEquals(2600, microsoftPosition.getValue());

        //aapl
        var applePosition = portfolio.getPosition(apple);
        Assertions.assertEquals(2, applePosition.getQty());
        Assertions.assertEquals(150, applePosition.getAveragePx());
        Assertions.assertEquals(300, applePosition.getValue());
    }

    @Test
    public void portfolioWithSameStock_ReturnsOnePosition() {
        var portfolio = new Portfolio();

        portfolio.add(position(MICROSOFT, 10, 260));
        portfolio.add(position(MICROSOFT, 5, 200));

        Assertions.assertEquals(1, portfolio.getAllPositions().size());
    }

    @Test
    public void portfolioWithSameStock_ReturnsCorrectQty() {
        var portfolio = new Portfolio();

        portfolio.add(position(MICROSOFT, 10, 260));
        portfolio.add(position(MICROSOFT, 1, 200));

        Assertions.assertEquals(11, portfolio.getPosition(MICROSOFT).getQty());
    }

    @Test
    public void portfolioWithSameStock_ReturnsCorrectAveragePrice() {
        var portfolio = new Portfolio();

        portfolio.add(position(MICROSOFT, 1, 240));
        portfolio.add(position(MICROSOFT, 1, 220));

        Assertions.assertEquals(230, portfolio.getPosition(MICROSOFT).getAveragePx());
    }

    @Test
    public void portfolioWithSameStock_ReturnsCorrectPositionValue() {
        var portfolio = new Portfolio();

        portfolio.add(position(MICROSOFT, 2, 240));
        portfolio.add(position(MICROSOFT, 1, 220));

        double expected = 2 * 240 + 220;
        Assertions.assertEquals(expected, portfolio.getPosition(MICROSOFT).getValue());
    }

    @Test
    public void complexPortfolio_ReturnsCorrectTotalValue() {
        var portfolio = new Portfolio();

        portfolio.add(position(MICROSOFT, 1, 260));
        portfolio.add(position(MICROSOFT, 2, 250));

        portfolio.add(position(APPLE, 5, 90));
        portfolio.add(position(APPLE, 10, 80));

        portfolio.add(position(ORACLE, 100, 80));

        Assertions.assertEquals(3, portfolio.getAllPositions().size());
        Assertions.assertEquals(10010, portfolio.getTotalValue());
    }

    private static Position position(String symbol, int qty, double px) {
        return new Position(new Stock(symbol), qty, px);
    }
}
