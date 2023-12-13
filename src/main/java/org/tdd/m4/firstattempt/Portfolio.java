package org.tdd.m4.firstattempt;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    List<Stock> stocks = new ArrayList<>();

    public void pristPortfolio(){
        stocks.forEach(System.out::println);
    }

    public void add(Stock symbol) {
//        if (/* stock is in the list */){
            // merge qty and price
//        }

        stocks.add(symbol);
    }

    public double totalValue() {
        if (stocks.isEmpty()) return 0;
        return stocks.stream()
                .mapToDouble(Stock::totalValue)
                .sum();
    }
}
