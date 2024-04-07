package org.gc.sd.strategies.winningStrategies;

import org.gc.sd.models.Board;
import org.gc.sd.models.Move;
import org.gc.sd.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagnolWinningStrategy implements WinningStrategy {

    private Map<Symbol, Integer> leftDiagnolMap = new HashMap<>();
    private Map<Symbol, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        Symbol symbol = move.getPlayer().getSymbol();
        if(row == col) {
            if(leftDiagnolMap.containsKey(symbol)) {
                leftDiagnolMap.put(symbol, leftDiagnolMap.get(symbol)+1);
            }
            else {
                leftDiagnolMap.put(symbol, 1);
            }
        }
        if(row + col == board.getDimension() - 1) {
            if(rightDiagonalMap.containsKey(symbol)) {
                rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol)+1);
            }
            else {
                rightDiagonalMap.put(symbol, 1);
            }
        }
        return (row == col && leftDiagnolMap.get(symbol) == board.getDimension()) && (row + col == board.getDimension() - 1 && rightDiagonalMap.get(symbol) == board.getDimension());
    }
}
