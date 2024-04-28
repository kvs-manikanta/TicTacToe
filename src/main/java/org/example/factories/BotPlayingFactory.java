package org.example.factories;

import org.example.models.BotDifficultyLevel;
import org.example.strategyManager.botStrategyManager.BotPlayingStrategy;
import org.example.strategyManager.botStrategyManager.EasyBotPlayingStrategy;
import org.example.strategyManager.botStrategyManager.HardBotPlayingStrategy;
import org.example.strategyManager.botStrategyManager.MediumBotPlayingStrategy;

public class BotPlayingFactory {

    public static BotPlayingStrategy getBotDifficultyInstance(BotDifficultyLevel botDifficultyLevel)
    {
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY))
        {
            return new EasyBotPlayingStrategy();
        } else if (botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingStrategy();
        }
        else {
            return new HardBotPlayingStrategy();
        }
    }
}
