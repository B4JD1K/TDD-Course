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
            existingPosition.setQuantity(newQuantity);
        } else {
            positions.put(symbol, position);
        }
    }

    public Position getPosition(String symbol) {
        return positions.get(symbol);
    }
}
