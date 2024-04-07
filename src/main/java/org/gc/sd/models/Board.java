package org.gc.sd.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    private int dimension;
    private List<List<Cell>> board;

    Board(int dimension) {
        // Board Size n*n
        this.dimension= dimension;
        board=new ArrayList<>(); // Rows

        for (int i = 0; i< dimension; i++) {
            board.add(new ArrayList<>()); // Columns

            for (int j = 0; j< dimension; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void displayBoard() {
        for (int i=0;i<dimension;i++) {
            for (int j=0;j<dimension;j++) {
                Cell cell = board.get(i).get(j);
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    System.out.print("|  |");
                }
                else{
                    System.out.print("|"+cell.getPlayer().getSymbol().getSymbol()+"|");
                }
            }
            System.out.println();
        }
    }
}
