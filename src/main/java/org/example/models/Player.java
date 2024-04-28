package org.example.models;

import java.util.Scanner;

public class Player {
    private String name;
    private PlayerType playerType;
    private Symbol symbol;
    private static Scanner scanner=new Scanner(System.in);

    public Player(String name, PlayerType playerType , Symbol symbol )
    {
        this.name=name;
        this.playerType=playerType;
        this.symbol=symbol;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Move makeMove() {
        System.out.println("Enter the row number " );
        int row = scanner.nextInt();

        System.out.println("Enter the col number " );
        int col=scanner.nextInt();

        return new Move(new Cell(row,col),this);
    }
}

