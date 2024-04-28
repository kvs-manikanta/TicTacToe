package org.example.models;

import org.example.factories.BotPlayingFactory;
import org.example.strategyManager.botStrategyManager.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, PlayerType playerType , Symbol symbol , BotDifficultyLevel botDifficultyLevel)
    {
        super(name , playerType ,symbol);
        this.botDifficultyLevel=botDifficultyLevel;
        this.botPlayingStrategy= BotPlayingFactory.getBotDifficultyInstance(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
