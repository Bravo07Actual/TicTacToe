package org.gc.sd;

import org.gc.sd.controllers.GameController;
import org.gc.sd.models.*;
import org.gc.sd.strategies.playingStrategies.EasyBotPlayingStrategy;
import org.gc.sd.strategies.winningStrategies.ColumnWinningStrategy;
import org.gc.sd.strategies.winningStrategies.DiagnolWinningStrategy;
import org.gc.sd.strategies.winningStrategies.RowWinningStrategy;
import org.gc.sd.strategies.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) throws Exception {

        System.out.println("Tic Tac Toe Game!");

        GameController gameController = new GameController();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Board's Dimension");
        // Minimum 3 dimension is needed
        //int dimension = scanner.nextInt();
        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add(
                new Player("Janaki", new Symbol('X'), PlayerType.HUMAN, 125L)
        );
        players.add(
                new Bot("Bot", new Symbol('O'), PlayerType.BOT, 111L, BotDifficultyLevel.EASY, new EasyBotPlayingStrategy())
        );
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagnolWinningStrategy());

        Game game = gameController.startGame(dimension, players, winningStrategies);

        while(gameController.getGameStatus(game).equals(GameState.IN_PROGRESS)) {
            // Display the board
            System.out.println("This is the current state of Board");
            gameController.displayBoard(game);

            // Do you want to UNDO? If tes, call the UNDO functionality else call the makemove

            gameController.makeMove(game);
        }

        if(gameController.getGameStatus(game).equals(GameState.ENDED)) {
            // One player has won the game
            System.out.println("Winner is "+gameController.getWinner(game).getName());
        }
        else {
            System.out.println("Game is DRAWN!!!");
        }
    }
}