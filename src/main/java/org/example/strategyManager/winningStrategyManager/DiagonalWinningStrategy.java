package org.example.strategyManager.winningStrategyManager;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Player;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{

    private final Map<Character, Integer> leftDiagonalMap = new HashMap<>(); //starting from 0,0
    private final Map<Character, Integer> rightDiagonalMap = new HashMap<>(); //starting from 0,n-1

    @Override
    public boolean gameWinningStrategy(Board board, Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character aChar = move.getPlayer().getSymbol().getaChar();

        //Condition for left diagonal -> row == col
        if (row == col) {
            if (!leftDiagonalMap.containsKey(aChar)) {
                leftDiagonalMap.put(aChar, 0);
            }
            leftDiagonalMap.put(aChar, leftDiagonalMap.get(aChar) + 1);
        }

        //Condition for right diagonal -> row + col == N-1
        if (row + col == board.getBoardSize() - 1) {
            if (!rightDiagonalMap.containsKey(aChar)) {
                rightDiagonalMap.put(aChar, 0);
            }
            rightDiagonalMap.put(aChar, rightDiagonalMap.get(aChar) + 1);
        }

        if (row == col && leftDiagonalMap.get(aChar) == board.getBoardSize()) {
            return true;
        }

        if (row + col == board.getBoardSize() - 1 &&
                rightDiagonalMap.get(aChar) == board.getBoardSize()) {
            return true;
        }

        return false;

    }
}
