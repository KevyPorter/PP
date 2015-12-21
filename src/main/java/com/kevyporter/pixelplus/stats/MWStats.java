package com.kevyporter.pixelplus.stats;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kevyporter.pixelplus.api.PlanckeAPI;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 3/12/2015.
 */
public class MWStats {
    private static boolean hidden = false;
    public static void display(String name) {
        getStats(name);
        if(hidden) {
            new FormattedMessage("Player is hidden!", EnumChatFormatting.RED).send(true);
            return;
        }
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
        new FormattedMessage(name + "'s stats in Mega Walls", EnumChatFormatting.GREEN).send();
        new FormattedMessage("     Coins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + coins, EnumChatFormatting.GOLD)).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN)).appendMessage(new FormattedMessage("" + wins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + kills, EnumChatFormatting.GOLD)).appendMessage(new FormattedMessage(" Final Kills: ", EnumChatFormatting.GREEN)).appendMessage(new FormattedMessage("" + fkills, EnumChatFormatting.GOLD)).send(false);
        if (!spider.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Spider: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(spider, EnumChatFormatting.GOLD)).send(false);
        }
        if (!skeleton.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Skeleton: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(skeleton, EnumChatFormatting.GOLD)).send(false);
        }
        if (!zombie.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Zombie: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(zombie, EnumChatFormatting.GOLD)).send(false);
        }
        if (!creeper.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Creeper: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(creeper, EnumChatFormatting.GOLD)).send(false);
        }
        if (!enderman.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Enderman: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(enderman, EnumChatFormatting.GOLD)).send(false);
        }
        if (!herobrine.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Herobrine: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(herobrine, EnumChatFormatting.GOLD)).send(false);
        }
        if (!dreadlord.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Dreadlord: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(dreadlord, EnumChatFormatting.GOLD)).send(false);
        }
        if (!shaman.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Shaman: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(shaman, EnumChatFormatting.GOLD)).send(false);
        }
        if (!arcanist.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Arcanist: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(arcanist, EnumChatFormatting.GOLD)).send(false);
        }
        if (!golem.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Golem: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(golem, EnumChatFormatting.GOLD)).send(false);
        }
        if (!blaze.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Blaze: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(blaze, EnumChatFormatting.GOLD)).send(false);
        }
        if (!pigman.equalsIgnoreCase("1 1 1 1 1")) {
            new FormattedMessage("     Pigman: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(pigman, EnumChatFormatting.GOLD)).send(false);
        }
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
    }

    private static int wins = 0;
    private static int fkills = 0;
    private static int kills = 0;
    private static int coins = 0;

    private static String squid = "1 1 1 1 1";
    private static String spider = "1 1 1 1 1";
    private static String skeleton = "1 1 1 1 1";
    private static String zombie = "1 1 1 1 1";
    private static String creeper = "1 1 1 1 1";
    private static String enderman = "1 1 1 1 1";
    private static String herobrine = "1 1 1 1 1";

    private static String dreadlord = "1 1 1 1 1";
    private static String shaman = "1 1 1 1 1";
    private static String arcanist = "1 1 1 1 1";
    private static String golem = "1 1 1 1 1";
    private static String blaze = "1 1 1 1 1";
    private static String pigman = "1 1 1 1 1";
    private static String pirate = "1 1 1 1 1";
    private static String hunter = "1 1 1 1 1";

    private static boolean spiderPres = false;
    private static boolean skeletonPres = false;
    private static boolean zombiePres = false;
    private static boolean creeperPres = false;
    private static boolean endermanPres = false;
    private static boolean herobrinePres = false;
    private static boolean dreadlordPres = false;
    private static boolean shamanPres = false;
    private static boolean arcanistPres = false;
    private static boolean golemPres = false;
    private static boolean blazePres = false;
    private static boolean pigmanPres = false;
    private static boolean squidPres = false;
    private static boolean hunterPres = false;
    private static boolean piratePres = false;

    private static boolean spiderEChest = false;
    private static boolean skeletonEChest = false;
    private static boolean zombieEChest = false;
    private static boolean creeperEChest = false;
    private static boolean endermanEChest = false;
    private static boolean herobrineEChest = false;
    private static boolean dreadlordEChest = false;
    private static boolean shamanEChest = false;
    private static boolean arcanistEChest = false;
    private static boolean golemEChest = false;
    private static boolean blazeEChest = false;
    private static boolean pigmanEChest = false;
    private static boolean squidEChest = false;
    private static boolean hunterEChest = false;
    private static boolean pirateEChest = false;

    private static void getStats(String name) {

        JsonObject statistics = new JsonObject();
        String json = PlanckeAPI.getPlayer(name);
        if(json.contains("Player is hidden!")) {
            hidden = true;
            return;
        }
        JsonParser parser = new JsonParser();
        statistics = (JsonObject) parser.parse(json);

        try {
            coins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("coins").getAsInt();
        } catch (Exception e) {
        }
        try {
            kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("kills").getAsInt();
        } catch (Exception e) {
        }
        try {
            fkills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("finalKills").getAsInt();
        } catch (Exception e) {
        }
        try {
            wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("wins").getAsInt();
        } catch (Exception e) {
        }

        int a, b, c, d, g;

        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("spider_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("spider_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("spider_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("spider_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("spider_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("spider_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("spider_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("spider_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("spider_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("spider_g").getAsInt();
            }
            spider = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("skeleton_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("skeleton_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("skeleton_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("skeleton_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("skeleton_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("skeleton_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("skeleton_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("skeleton_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("skeleton_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("skeleton_g").getAsInt();
            }
            skeleton = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("zombie_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("zombie_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("zombie_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("zombie_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("zombie_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("zombie_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("zombie_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("zombie_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("zombie_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("zombie_g").getAsInt();
            }
            zombie = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("creeper_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("creeper_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("creeper_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("creeper_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("creeper_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("creeper_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("creeper_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("creeper_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("creeper_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("creeper_g").getAsInt();
            }
            creeper = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("enderman_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("enderman_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("enderman_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("enderman_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("enderman_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("enderman_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("enderman_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("enderman_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("enderman_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("enderman_g").getAsInt();
            }
            enderman = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("herobrine_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("herobrine_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("herobrine_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("herobrine_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("herobrine_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("herobrine_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("herobrine_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("herobrine_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("herobrine_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("herobrine_g").getAsInt();
            }
            herobrine = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }

        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("dreadlord_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("dreadlord_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("dreadlord_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("dreadlord_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("dreadlord_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("dreadlord_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("dreadlord_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("dreadlord_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("dreadlord_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("dreadlord_g").getAsInt();
            }
            dreadlord = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("shaman_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("shaman_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("shaman_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("shaman_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("shaman_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("shaman_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("shaman_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("shaman_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("shaman_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("shaman_g").getAsInt();
            }
            shaman = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("arcanist_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("arcanist_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("arcanist_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("arcanist_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("arcanist_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("arcanist_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("arcanist_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("arcanist_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("arcanist_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("arcanist_g").getAsInt();
            }
            arcanist = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("golem_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("golem_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("golem_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("golem_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("golem_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("golem_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("golem_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("golem_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("golem_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("golem_g").getAsInt();
            }
            golem = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("blaze_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("blaze_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("blaze_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("blaze_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("blaze_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("blaze_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("blaze_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("blaze_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("blaze_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("blaze_g").getAsInt();
            }
            blaze = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("pigman_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("pigman_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("pigman_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("pigman_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("pigman_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("pigman_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("pigman_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("pigman_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("pigman_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("pigman_g").getAsInt();
            }
            pigman = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("squid_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("squid_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("squid_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("squid_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("squid_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("squid_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("squid_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("squid_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("squid_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("squid_g").getAsInt();
            }
            squid = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("pirate_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("pirate_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("pirate_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("pirate_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("pirate_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("pirate_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("pirate_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("pirate_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("pirate_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("pirate_g").getAsInt();
            }
            pirate = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }
        try {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            g = 1;
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("hunter_a")) {
                a = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("hunter_a").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("hunter_b")) {
                b = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("hunter_b").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("hunter_c")) {
                c = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("hunter_c").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("hunter_d")) {
                d = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("hunter_d").getAsInt();
            }
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("hunter_g")) {
                g = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("hunter_g").getAsInt();
            }
            hunter = "" + a + " " + b + " " + c + " " + d + " " + g;
        } catch (Exception e) {
        }

        try {
            if (statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().has("packages")) {
                JsonArray array = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Walls3").getAsJsonObject().get("packages").getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i).getAsString().startsWith("spider")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            spiderPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            spiderEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("skeleton")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            skeletonPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            skeletonEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("zombie")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            zombiePres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            zombieEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("creeper")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            creeperPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            creeperEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("enderman")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            endermanPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            endermanEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("herobrine")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            herobrinePres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            herobrineEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("dreadlord")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            dreadlordPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            dreadlordEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("arcanist")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            arcanistPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            arcanistEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("shaman")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            shamanPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            shamanEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("golem")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            golemPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            golemEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("blaze")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            blazePres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            blazeEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("pigman")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            pigmanPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            pigmanEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("pirate")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            piratePres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            pirateEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("hunter")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            hunterPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            hunterEChest = true;
                        }
                    }
                    if (array.get(i).getAsString().startsWith("squid")) {
                        if (array.get(i).getAsString().contains("prestige")) {
                            squidPres = true;
                        }
                        if (array.get(i).getAsString().contains("enderchest")) {
                            squidEChest = true;
                        }
                    }
                }
                if(spiderEChest) {
                    spider = spider + " Enderchest";
                }
                if(spiderPres) {
                    spider = spider + " Prestige";
                }
                if(skeletonEChest) {
                    skeleton = skeleton + " Enderchest";
                }
                if(skeletonPres) {
                    skeleton = skeleton + " Prestige";
                }
                if(zombieEChest) {
                    zombie = zombie + " Enderchest";
                }
                if(zombiePres) {
                    zombie = zombie + " Prestige";
                }
                if(creeperEChest) {
                    creeper = creeper + " Enderchest";
                }
                if(creeperPres) {
                    creeper = creeper + " Prestige";
                }
                if(endermanEChest) {
                    enderman = enderman + " Enderchest";
                }
                if(endermanPres) {
                    enderman = enderman + " Prestige";
                }
                if(herobrineEChest) {
                    herobrine = herobrine + " Enderchest";
                }
                if(herobrinePres) {
                    herobrine = herobrine + " Prestige";
                }
                if(dreadlordEChest) {
                    dreadlord = dreadlord + " Enderchest";
                }
                if(dreadlordPres) {
                    dreadlord = dreadlord + " Prestige";
                }
                if(arcanistEChest) {
                    arcanist = arcanist + " Enderchest";
                }
                if(arcanistPres) {
                    arcanist = arcanist + " Prestige";
                }
                if(shamanEChest) {
                    shaman = shaman + " Enderchest";
                }
                if(shamanPres) {
                    shaman = shaman + " Prestige";
                }
                if(golemEChest) {
                    golem = golem + " Enderchest";
                }
                if(golemPres) {
                    golem = golem + " Prestige";
                }
                if(blazeEChest) {
                    blaze = blaze + " Enderchest";
                }
                if(blazePres) {
                    blaze = blaze + " Prestige";
                }
                if(pigmanEChest) {
                    pigman = pigman + " Enderchest";
                }
                if(pigmanPres) {
                    pigman = pigman + " Prestige";
                }
                if(pirateEChest) {
                    pirate = pirate + " Enderchest";
                }
                if(piratePres) {
                    pirate = pirate + " Prestige";
                }
                if(hunterEChest) {
                    hunter = hunter + " Enderchest";
                }
                if(hunterPres) {
                    hunter = hunter + " Prestige";
                }
                if(squidEChest) {
                    squid = squid + " Enderchest";
                }
                if(squidPres) {
                    squid = squid + " Prestige";
                }
            }
        } catch (Exception ex) {
        }
    }
}
