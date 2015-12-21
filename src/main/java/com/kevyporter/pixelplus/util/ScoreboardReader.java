package com.kevyporter.pixelplus.util;

import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.StringUtils;
import net.minecraftforge.fml.client.FMLClientHandler;

/**
 * Created by Kevy on 15/12/2015.
 */
public class ScoreboardReader {

    private String scoreboardTitle;

    public String getScoreboardTitle(boolean formatted) {
        if(formatted) {
            return scoreboardTitle;
        } else {
            return StringUtils.stripControlCodes(scoreboardTitle);
        }
    }

    private ScoreboardReader() {
        scoreboardTitle = "";

        try {
            Scoreboard scoreboard = FMLClientHandler.instance().getClient().theWorld.getScoreboard();
            ScoreObjective objective = scoreboard.getObjectiveInDisplaySlot(1);
            scoreboardTitle = objective.getDisplayName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ScoreboardReader instance = new ScoreboardReader();

    public static ScoreboardReader getInstance() {
        return instance;
    }

}
