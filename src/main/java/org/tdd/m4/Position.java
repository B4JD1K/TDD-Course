package org.tdd.m4;


public class Position {
    Stock stock;
    int qty;
    double px;

    public Position(Stock stock, int qty, double px) {
        this.stock = stock;
        this.qty = qty;
        this.px = px;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQty() {
        return qty;
    }

    public double getAveragePx() {
        return px;
    }

    public double getValue() {
        return qty * px;
    }

    public void setQuantity(int newQty) {
        this.qty = newQty;
    }

    public void setAveragePrice(double newAveragePx) {
        this.px = newAveragePx;
    }

    @Override
    public String toString() {
        return String.format("{ %s | Qty: %s | Px: %s | Value: %s}", stock, qty, px, getValue());
    }
}
