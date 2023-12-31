package org.tdd.m4;

import org.tdd.m4.firstattempt.Stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {

    private final Map<String, Position> positions;

    public Portfolio() {
        positions = new HashMap<>();
    }

    public Map<String, Position> getAllPositions() {
        return positions;
    }

    public void add(Position position) {
        String symbol = position.getStock().symbol();

        if (positions.containsKey(symbol)) {
            Position existingPosition = positions.get(symbol);
            int newQuantity = existingPosition.getQty() + position.getQty();
            double newAveragePrice = (existingPosition.getQty() * existingPosition.getAveragePx()
                    + position.getQty() * position.getAveragePx()) / newQuantity;

            existingPosition.setQuantity(newQuantity);
            existingPosition.setAveragePrice(newAveragePrice);
        } else {
            positions.put(symbol, position);
        }
    }

    public Position getPosition(String symbol) {
        return positions.get(symbol);
    }

    public double getTotalValue() {
        return positions.values().stream()
                .mapToDouble(Position::getValue)
                .sum();
    }

    public void print() {
        positions.values().forEach(System.out::println);

        System.out.println("=========================");
        System.out.println(getTotalValue());
    }
}
