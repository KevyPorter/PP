package com.kevyporter.pixelplus.stats;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kevyporter.pixelplus.api.PlanckeAPI;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 3/12/2015.
 */
public class VZStats {
    public static void display(String name) {
        JsonObject statistics = new JsonObject();
        JsonParser parser = new JsonParser();
        String json = PlanckeAPI.getPlayer(name);
        boolean hidden = false;
        if(json.contains("Player is hidden!")) {
            hidden = true;
        }
        if(hidden) {
            new FormattedMessage("Player is hidden!", EnumChatFormatting.RED).send(true);
            return;
        }
        statistics = (JsonObject)parser.parse(json);

        int zkills = 0;
        int vkills = 0;
        int wins = 0;
        int hkills = 0;
        int coins = 0;
        try
        {
            coins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("VampireZ").getAsJsonObject().get("coins").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            hkills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("VampireZ").getAsJsonObject().get("human_kills").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            vkills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("VampireZ").getAsJsonObject().get("vampire_kills").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            zkills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("VampireZ").getAsJsonObject().get("zombie_kills").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("VampireZ").getAsJsonObject().get("human_wins").getAsInt();
        }
        catch (Exception e) {}

        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
        new FormattedMessage(name + "'s stats in VampireZ", EnumChatFormatting.GREEN).send();
        new FormattedMessage("     Coins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + coins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Human Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + wins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Human Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + hkills, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Vampire Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + vkills, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Zombie Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + zkills, EnumChatFormatting.GOLD)).send(false);
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
    }
}
