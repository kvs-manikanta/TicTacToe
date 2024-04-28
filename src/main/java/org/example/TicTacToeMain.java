package org.example;

import org.example.controllers.GameController;
import org.example.models.*;
import org.example.strategyManager.winningStrategyManager.ColWinningStrategy;
import org.example.strategyManager.winningStrategyManager.DiagonalWinningStrategy;
import org.example.strategyManager.winningStrategyManager.RowWinningStrategy;
import org.example.strategyManager.winningStrategyManager.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class TicTacToeMain {
    public static void main(String[] args) {

        System.out.println("Enter the size of board : ");
        Scanner scanner=new Scanner(System.in);

        int boardSize= scanner.nextInt();
        List<Player> players=new ArrayList<>();
        players.add(new Player("kvs",PlayerType.HUMAN,new Symbol('X')));
        players.add(new Bot("Machine",PlayerType.BOT,new Symbol('O'),BotDifficultyLevel.EASY));


        List<WinningStrategy> winningStrategies=List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        GameController gameController=new GameController();

        //Giving the complete task to the
        Game game=gameController.startGame(boardSize,players,winningStrategies);


        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS))
        {
            gameController.printBoard(game);
            System.out.println("Do you want undo the move :" +"Y/N");
            String undo=scanner.next();
            if(undo.equalsIgnoreCase("y"))
            {
                gameController.undoMove(game);
                continue;
            }
            gameController.makeMove(game);
        }


        if (gameController.getGameStatus(game).equals(GameStatus.WON)) {
            System.out.println(gameController.getWinner(game).getName() + " has won the game.");
        } else {
            System.out.println("GAME DRAW");
        }

    }
}

