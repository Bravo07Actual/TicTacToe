package org.gc.sd.strategies.winningStrategies;

import org.gc.sd.models.Board;
import org.gc.sd.models.Move;
import org.gc.sd.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    private Map<Integer, Map<Symbol, Integer>> rowMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {

        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }

        Map<Symbol, Integer> currentRowMap = rowMaps.get(row);
        if(currentRowMap.containsKey(symbol)) {
            currentRowMap.put(symbol, currentRowMap.get(symbol)+1);
        }
        else {
            currentRowMap.put(symbol, 1);
        }
        return currentRowMap.get(symbol) == board.getDimension() ;
    }
}
