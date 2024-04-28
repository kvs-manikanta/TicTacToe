package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Cell>> board;
    private int boardSize;

    //constructor for board initialization based on the client dimensions of board size
    public Board(int boardSize)
    {
        this.boardSize=boardSize;
        board=new ArrayList<>();

        for(int i=0;i<boardSize;i++)
        {
            board.add(new ArrayList<>());
            for(int j=0;j<boardSize;j++)
            {
                board.get(i).add(new Cell(i,j));
            }
        }
    }
    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void printBoard() {
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board.size();j++)
            {
                Cell cell=board.get(i).get(j);
                cell.display();
            }
            System.out.print("\n");
        }
    }
}
