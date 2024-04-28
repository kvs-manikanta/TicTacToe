package org.example.strategyManager.winningStrategyManager;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Player;

public interface WinningStrategy {
    boolean gameWinningStrategy(Board board , Move move );
}
