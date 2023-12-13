package m4;

public class Portfolio {

    Stock symbol;

    public void add(Stock symbol) {
        this.symbol=symbol;
    }

    public double totalValue() {
        if (symbol==null) return 0;
        return symbol.totalValue();
    }
}
