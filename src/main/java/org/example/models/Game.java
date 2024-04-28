package org.example.models;

import org.example.strategyManager.winningStrategyManager.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private Player winner;
    private List<WinningStrategy> winningStrategy;

    private Game(int boardSize, List<Player> players, List<WinningStrategy> winningStrategy) {
        this.board = new Board(boardSize);
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.nextPlayerIndex = 0;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(List<WinningStrategy> winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public void printBoard() {
        board.printBoard();
    }

    //implement the UNDO Move
    public void undoMove() {
        System.out.println("Will implement");
    }

    public void makeMove() {
        Player currPlayer=players.get(nextPlayerIndex);
        System.out.println("This is " + currPlayer.getName() + "'s move.");

        //this is not the final move as this need to be validated and proceed

        Move move=currPlayer.makeMove();

        if(!validateMove(move))
        {
            throw new RuntimeException("Invalid move please try again");
        }


        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        //now this cell has set player and state too
        Cell cell=board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currPlayer);

        Move finalMove = new Move(cell,currPlayer);
        moves.add(finalMove);

        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

        if (checkWinner(finalMove)) {
            winner = currPlayer;
            gameStatus = GameStatus.WON;
        } else if (moves.size() == board.getBoardSize() * board.getBoardSize()) {
            gameStatus = GameStatus.DRAW;
        }

    }
    private boolean checkWinner(Move move) {
        for (WinningStrategy winningStrategy : winningStrategy) {
            if (winningStrategy.gameWinningStrategy(board, move)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getBoardSize() || col < 0 || col >= board.getBoardSize()) {
            return false;
        }

        //Whether the cell at which player is trying to make a move is empty or not.
        if (!board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            return false;
        }

        return true;
    }

    public static class Builder{
        private int boardSize;
        private List<Player> players;
        private List<WinningStrategy> winningStrategy;
//        private List<Move>  moves;
//        private GameStatus gameStatus;
//        private int nextPlayerIndex;
//        private Player winner;

        private Builder()
        {
            this.players = new ArrayList<>();
            this.boardSize = 0;
            this.winningStrategy = new ArrayList<>();
        }

        private void validateBotCount() {
            int count = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    count += 1;
                    if (count > 1) {
                        throw new RuntimeException("Only one BOT is allowed per game");
                    }
                }
            }
        }

        private void validateUniqueSymbols() {
            Set<Character> symbolSet = new HashSet<>();
            for (Player player : players) {
                symbolSet.add(player.getSymbol().getaChar());
            }

            if (symbolSet.size() != boardSize - 1) {
                throw new RuntimeException("Every player should have a unique symbol");
            }
        }

        private void validations() {
            validateBotCount();
            validateUniqueSymbols();
        }

        public Game build() {
            //validations
            validations();

            return new Game(boardSize, players, winningStrategy);
        }


        public int getBoardSize() {
            return boardSize;
        }

        public Builder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {

            this.players = players;
            return this;
        }


        public List<WinningStrategy> getWinningStrategy() {
            return winningStrategy;

        }

        public Builder setWinningStrategy(List<WinningStrategy> winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }
    }
}
