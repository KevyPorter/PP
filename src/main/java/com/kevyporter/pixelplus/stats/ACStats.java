package com.kevyporter.pixelplus.stats;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kevyporter.pixelplus.api.PlanckeAPI;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 3/12/2015.
 */
public class ACStats {
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
        int shit = 0;
        int cmaxwave = 0;
        int towins = 0;
        int pg2wins = 0;
        int pg1wins = 0;
        int bhwins = 0;
        int fhwins = 0;
        int eswins = 0;
        int dwwins = 0;
        int bdwins = 0;
        int tokills = 0;
        int bhkills = 0;
        int dwkills = 0;
        int bdkills = 0;
        int coins = 0;
        try
        {
            coins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("coins").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            bdkills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("kills_dayone").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            bdwins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("wins_dayone").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            bhkills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("kills_oneinthequiver").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            bhwins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("wins_oneinthequiver").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            cmaxwave = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("max_wave").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            dwkills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("kills_dragonwars2").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            dwwins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("wins_dragonwars2").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            eswins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("wins_ender").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            fhwins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("wins_farm_hunt").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            pg1wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("wins_party").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            pg2wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("wins_party_2").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            tokills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("kills_throw_out").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            towins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("wins_throw_out").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            shit = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arcade").getAsJsonObject().get("poop_collected").getAsInt();
        }
        catch (Exception e) {}
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
        new FormattedMessage(name + "'s stats in Arcade", EnumChatFormatting.GREEN).send();
        new FormattedMessage("     Coins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + coins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Blocking Dead", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + bdkills, EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + bdwins, EnumChatFormatting.GOLD)))).send(false);
        new FormattedMessage("     Dragon Wars", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + dwkills, EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + dwwins, EnumChatFormatting.GOLD)))).send(false);
        new FormattedMessage("     Bounty Hunters", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + bhkills, EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + bhwins, EnumChatFormatting.GOLD)))).send(false);
        new FormattedMessage("     Throw Out", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + tokills, EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + towins, EnumChatFormatting.GOLD)))).send(false);
        new FormattedMessage("     Partygames1 Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + pg1wins, EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" Partygames2 Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + pg2wins, EnumChatFormatting.GOLD)))).send(false);
        new FormattedMessage("     Enderspleef", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + eswins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Farmhunt", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + fhwins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Poop Collected: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + shit, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Creeper Attack", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + fhwins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Max Wave: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + cmaxwave, EnumChatFormatting.GOLD)).send(false);
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
    }
}
