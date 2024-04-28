package org.example.strategyManager.winningStrategyManager;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Player;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    private final HashMap<Integer,HashMap<Character,Integer>>  rowMaps=new HashMap<>();

    @Override
    public boolean gameWinningStrategy(Board board, Move move) {
        int row = move.getCell().getRow();
        Character aChar = move.getPlayer().getSymbol().getaChar();

        if (!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }

        Map<Character, Integer> currRowMap = rowMaps.get(row);

        if (!currRowMap.containsKey(aChar)) {
            currRowMap.put(aChar, 0);
        }

        currRowMap.put(aChar, currRowMap.get(aChar) + 1);

        return currRowMap.get(aChar).equals(board.getBoardSize());
    }
}
