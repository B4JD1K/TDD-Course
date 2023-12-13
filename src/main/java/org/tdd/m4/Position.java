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

    public double getPx() {
        return px;
    }

    public double getValue() {
        return qty * px;
    }


    public void setQuantity(int newQty) {
        this.qty=newQty;
    }
}
