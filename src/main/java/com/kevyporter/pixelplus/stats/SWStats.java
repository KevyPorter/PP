package com.kevyporter.pixelplus.stats;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kevyporter.pixelplus.api.PlanckeAPI;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 3/12/2015.
 */
public class SWStats {
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

        int soloNormalKills = 0;
        int soloInsaneKills = 0;
        int teamNormalKills = 0;
        int teamInsaneKills = 0;
        int megaKills = 0;
        int soloNormalWins = 0;
        int soloInsaneWins = 0;
        int teamNormalWins = 0;
        int teamInsaneWins = 0;
        int megaWins = 0;
        int coins = 0;
        int souls = 0;

        try
        {
            coins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("coins").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            souls = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("souls").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            soloNormalKills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("kills_solo_normal").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            soloNormalWins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("wins_solo_normal").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            soloInsaneKills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("kills_solo_insane").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            soloInsaneWins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("wins_solo_insane").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            teamNormalKills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("kills_team_normal").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            teamNormalWins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("wins_team_normal").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            teamInsaneKills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("kills_team_insane").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            teamInsaneWins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("wins_team_insane").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            megaKills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("kills_mega").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            megaWins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("SkyWars").getAsJsonObject().get("wins_mega").getAsInt();
        }
        catch (Exception e) {}

        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
        new FormattedMessage(name + "'s stats in SkyWars", EnumChatFormatting.GREEN).send();
        new FormattedMessage("     Coins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + coins, EnumChatFormatting.GOLD).appendMessage(
                new FormattedMessage(" Souls: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + souls, EnumChatFormatting.GOLD)))).send(false);

        new FormattedMessage("     Solo Normal", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + soloNormalKills, EnumChatFormatting.GOLD).appendMessage(
                new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + soloNormalWins, EnumChatFormatting.GOLD)))).send(false);

        new FormattedMessage("     Solo Insane", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + soloInsaneKills, EnumChatFormatting.GOLD).appendMessage(
                new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + soloInsaneWins, EnumChatFormatting.GOLD)))).send(false);

        new FormattedMessage("     Team Normal", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + teamNormalKills, EnumChatFormatting.GOLD).appendMessage(
                new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + teamNormalWins, EnumChatFormatting.GOLD)))).send(false);

        new FormattedMessage("     Team Insane", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + teamInsaneKills, EnumChatFormatting.GOLD).appendMessage(
                new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + teamInsaneWins, EnumChatFormatting.GOLD)))).send(false);

        new FormattedMessage("     Mega", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + megaKills, EnumChatFormatting.GOLD).appendMessage(
                new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + megaWins, EnumChatFormatting.GOLD)))).send(false);
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
    }
}
