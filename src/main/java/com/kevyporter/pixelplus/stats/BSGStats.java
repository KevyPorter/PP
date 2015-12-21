package com.kevyporter.pixelplus.stats;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kevyporter.pixelplus.api.PlanckeAPI;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 3/12/2015.
 */
public class BSGStats {
    public static void display(String name) {
        JsonObject statistics = new JsonObject();
        String json = PlanckeAPI.getPlayer(name);
        boolean hidden = false;
        if(json.contains("Player is hidden!")) {
            hidden = true;
        }
        if(hidden) {
            new FormattedMessage("Player is hidden!", EnumChatFormatting.RED).send(true);
            return;
        }
        JsonParser parser = new JsonParser();
        statistics = (JsonObject) parser.parse(json);

        int wolf = 1;
        int troll = 1;
        int toxic = 1;
        int tim = 1;
        int spel = 1;
        int slimey = 1;
        int snow = 1;
        int shadowk = 1;
        int scout = 1;
        int rogue = 1;
        int red = 1;
        int pigman = 1;
        int paladin = 1;
        int necro = 1;
        int meat = 1;
        int knight = 1;
        int hunter = 1;
        int horse = 1;
        int fish = 1;
        int creeper = 1;
        int blaze = 1;
        int baker = 1;
        int astro = 1;
        int armor = 1;
        int archer = 1;
        int arach = 1;
        int hypetrain = 1;
        int jockey = 1;
        int rambo = 0;
        int solo = 0;
        int team = 0;
        int kills = 0;
        int coins = 0;

        try {
            coins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("coins").getAsInt();
            System.out.println("getting coins");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            solo = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("wins").getAsInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            team = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("wins_teams").getAsInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rambo = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("rambo_wins").getAsInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("kills").getAsInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            arach = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("arachnologist").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            archer = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("archer").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            armor = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("armorer").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            astro = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("astronaut").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            baker = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("baker").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            blaze = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("blaze").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            creeper = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("creepertamer").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fish = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("fisherman").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            horse = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("horsetamer").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            hunter = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("hunter").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            knight = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("knight").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            meat = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("meatmaster").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            necro = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("necromancer").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            paladin = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("paladin").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            pigman = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("pigman").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            red = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("reddragon").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rogue = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("rogue").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            scout = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("scout").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            shadowk = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("shadow knight").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            slimey = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("slimeyslime").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            snow = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("snowman").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            spel = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("speleologist").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            tim = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("tim").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            toxic = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("toxicologist").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            troll = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("troll").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            wolf = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("wolftamer").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            hypetrain = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("hype train").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jockey = (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("HungerGames").getAsJsonObject().get("jockey").getAsInt() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
        new FormattedMessage(name + "'s stats in Blitz Survival Games", EnumChatFormatting.GREEN).send();

        new FormattedMessage("     Coins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(coins + "", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" Kills: ", EnumChatFormatting.GREEN)
                .appendMessage(new FormattedMessage(kills + "", EnumChatFormatting.GOLD)))).send(false);

        new FormattedMessage("     Solo Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(solo + "", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" Team Wins: ", EnumChatFormatting.GREEN)
                .appendMessage(new FormattedMessage(team + "", EnumChatFormatting.GOLD)))).send(false);

        new FormattedMessage("     Rambo Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + rambo, EnumChatFormatting.GOLD)).send(false);

        if (arach != 1) {
            new FormattedMessage("     Arachnologist: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + arach, EnumChatFormatting.GOLD)).send(false);
        }
        if (archer != 1) {
            new FormattedMessage("     Archer: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + archer, EnumChatFormatting.GOLD)).send(false);
        }
        if (armor != 1) {
            new FormattedMessage("     Armorer: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + armor, EnumChatFormatting.GOLD)).send(false);
        }
        if (astro != 1) {
            new FormattedMessage("     Astronaut: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + astro, EnumChatFormatting.GOLD)).send(false);
        }
        if (baker != 1) {
            new FormattedMessage("     Baker: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + baker, EnumChatFormatting.GOLD)).send(false);
        }
        if (blaze != 1) {
            new FormattedMessage("     Blaze: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + blaze, EnumChatFormatting.GOLD)).send(false);
        }
        if (creeper != 1) {
            new FormattedMessage("     Creepertamer: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + creeper, EnumChatFormatting.GOLD)).send(false);
        }
        if (fish != 1) {
            new FormattedMessage("     Fisherman: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + fish, EnumChatFormatting.GOLD)).send(false);
        }
        if (horse != 1) {
            new FormattedMessage("     Horsetamer: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + horse, EnumChatFormatting.GOLD)).send(false);
        }
        if (hunter != 1) {
            new FormattedMessage("     Hunter: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + hunter, EnumChatFormatting.GOLD)).send(false);
        }
        if (hypetrain != 1) {
            new FormattedMessage("     Hype Train: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + hypetrain, EnumChatFormatting.GOLD)).send(false);
        }
        if(jockey != 1) {
            new FormattedMessage("     Jockey: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + jockey, EnumChatFormatting.GOLD)).send(false);
        }
        if (knight != 1) {
            new FormattedMessage("     Knight: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + knight, EnumChatFormatting.GOLD)).send(false);
        }
        if (meat != 1) {
            new FormattedMessage("     Meatmaster: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + meat, EnumChatFormatting.GOLD)).send(false);
        }
        if (necro != 1) {
            new FormattedMessage("     Necromancer: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + necro, EnumChatFormatting.GOLD)).send(false);
        }
        if (paladin != 1) {
            new FormattedMessage("     Paladin: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + paladin, EnumChatFormatting.GOLD)).send(false);
        }
        if (pigman != 1) {
            new FormattedMessage("     Pigman: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + pigman, EnumChatFormatting.GOLD)).send(false);
        }
        if (red != 1) {
            new FormattedMessage("     Reddragon: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + red, EnumChatFormatting.GOLD)).send(false);
        }
        if (rogue != 1) {
            new FormattedMessage("     Rogue: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + rogue, EnumChatFormatting.GOLD)).send(false);
        }
        if (scout != 1) {
            new FormattedMessage("     Scout: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + scout, EnumChatFormatting.GOLD)).send(false);
        }
        if (shadowk != 1) {
            new FormattedMessage("     Shadow Knight: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + shadowk, EnumChatFormatting.GOLD)).send(false);
        }
        if (slimey != 1) {
            new FormattedMessage("     SlimeySlime: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + slimey, EnumChatFormatting.GOLD)).send(false);
        }
        if (snow != 1) {
            new FormattedMessage("     Snowman: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + snow, EnumChatFormatting.GOLD)).send(false);
        }
        if (spel != 1) {
            new FormattedMessage("     Speleologist: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + spel, EnumChatFormatting.GOLD)).send(false);
        }
        if (tim != 1) {
            new FormattedMessage("     Tim: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + tim, EnumChatFormatting.GOLD)).send(false);
        }
        if (toxic != 1) {
            new FormattedMessage("     Toxicologist: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + toxic, EnumChatFormatting.GOLD)).send(false);
        }
        if (troll != 1) {
            new FormattedMessage("     Troll: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + troll, EnumChatFormatting.GOLD)).send(false);
        }
        if (wolf != 1) {
            new FormattedMessage("     Wolftamer: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + wolf, EnumChatFormatting.GOLD)).send(false);
        }
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
    }
}
