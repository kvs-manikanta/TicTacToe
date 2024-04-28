package org.example.controllers;

import org.example.models.Game;
import org.example.models.GameStatus;
import org.example.models.Player;
import org.example.strategyManager.winningStrategyManager.WinningStrategy;

import java.util.List;

public class GameController {

    /*
    need to define few methods to behave like game
    one creating a gae=me object
    -makeMove - Start making moves depends on the player 
    -check winner method
    -UNDO Feature
    -Game State
     */
    public Game startGame(int boardSize , List<Player> players,List<WinningStrategy> winningStrategies)
    {
        return Game.getBuilder()
                .setBoardSize(boardSize)
                .setPlayers(players)
                .setWinningStrategy(winningStrategies)
                .build();
    }


    public void printBoard(Game game) {
        game.printBoard();
    }

    public Player getWinner(Game game)
    {
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game)
    {
        return game.getGameStatus();
    }

    public void undoMove(Game game)
    {
        game.undoMove();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }
}
