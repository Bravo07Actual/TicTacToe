package org.gc.sd.strategies.winningStrategies;


import org.gc.sd.models.Board;
import org.gc.sd.models.Move;
import org.gc.sd.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{


    private Map<Integer, Map<Symbol, Integer>> columnMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int column = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!columnMaps.containsKey(column)) {
            columnMaps.put(column, new HashMap<>());
        }

        Map<Symbol, Integer> currentColumnMap = columnMaps.get(column);
        if(currentColumnMap.containsKey(symbol)) {
            currentColumnMap.put(symbol, currentColumnMap.get(symbol)+1);
        }
        else {
            currentColumnMap.put(symbol, 1);
        }
        return currentColumnMap.get(symbol) == board.getDimension() ;
    }
}
