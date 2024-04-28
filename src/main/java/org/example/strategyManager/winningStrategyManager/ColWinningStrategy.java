package org.example.strategyManager.winningStrategyManager;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Player;

import java.util.HashMap;

public class ColWinningStrategy implements  WinningStrategy{

    private final HashMap<Integer,HashMap<Character,Integer>> colMaps=new HashMap<Integer, HashMap<Character, Integer>>();
    @Override
    public boolean gameWinningStrategy(Board board, Move move) {

        int col=move.getCell().getCol();
        Character aChar=move.getPlayer().getSymbol().getaChar();

        if(!colMaps.containsKey(col))
        {
            colMaps.put(col,new HashMap<>());
        }

        HashMap<Character,Integer> colMap=colMaps.get(col);

        if(!colMap.containsKey(aChar))
        {
            colMap.put(aChar, 0);
        }

        colMap.put(aChar, colMap.get(aChar) + 1);

        return colMap.get(aChar).equals(board.getBoardSize());
    }
}
