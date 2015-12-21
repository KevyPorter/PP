package com.kevyporter.pixelplus.goals;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

/**
 * Created by Kevy on 9/12/2015.
 */
public class BlitzGoals {

    public enum BlitzGoalType {
        KILL("Kills"),
        WIN("Wins");

        String what;

        private BlitzGoalType(String what) {
            this.what = what;
        }

        public String getWhat() {
            return what;
        }
    }

    private static HashMap<BlitzGoalType, Integer> goal = new HashMap<BlitzGoalType, Integer>();
    private static HashMap<BlitzGoalType, Integer> current = new HashMap<BlitzGoalType, Integer>();

    public static void setGoal(BlitzGoalType type, Integer amount) {
        goal.put(type, amount);
        current.put(type, 0);
        new FormattedMessage("Set a goal of ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(amount + " " + type.getWhat(), EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage(" in Blitz SG.", EnumChatFormatting.GREEN))).send(true);
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent e) {
        if (PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            String msg = e.message.getUnformattedText();
            if (goal.containsKey(BlitzGoalType.KILL)) {
                if (msg.startsWith("[B-SG]: ")) {
                    if (msg.trim().contains("was killed by " + Minecraft.getMinecraft().thePlayer.getName().trim())) {
                        current.put(BlitzGoalType.KILL, current.get(BlitzGoalType.KILL) + 1);
                        if (current.get(BlitzGoalType.KILL) == goal.get(BlitzGoalType.KILL)) {
                            new FormattedMessage("Congratulations you reached your goal of " + goal.get(BlitzGoalType.KILL) + " kills in Blitz SG.", EnumChatFormatting.GREEN).send(true);
                            goal.remove(BlitzGoalType.KILL);
                            current.remove(BlitzGoalType.KILL);
                        }
                    }
                }
            }
            if (goal.containsKey(BlitzGoalType.WIN)) {
                if (msg.startsWith("Winner - ") && msg.endsWith(")")) {
                    if (msg.contains(Minecraft.getMinecraft().thePlayer.getName().trim())) {
                        current.put(BlitzGoalType.WIN, current.get(BlitzGoalType.WIN) + 1);
                        if (current.get(BlitzGoalType.WIN) == goal.get(BlitzGoalType.WIN)) {
                            new FormattedMessage("Congratulations you reached your goal of " + goal.get(BlitzGoalType.WIN) + " wins in Blitz SG.", EnumChatFormatting.GREEN).send(true);
                            goal.remove(BlitzGoalType.WIN);
                            current.remove(BlitzGoalType.WIN);
                        }
                    }
                }
            }
        }
    }

    public static void listGoals() {
        if(goal.containsKey(BlitzGoalType.WIN) || goal.containsKey(BlitzGoalType.KILL)) {
            if (goal.containsKey(BlitzGoalType.KILL)) {
                new FormattedMessage("BSG: Kills - ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(current.get(BlitzGoalType.KILL) + "/" + goal.get(BlitzGoalType.KILL), EnumChatFormatting.YELLOW)).send(true);
            }
            if (goal.containsKey(BlitzGoalType.WIN)) {
                new FormattedMessage("BSG: Wins - ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(current.get(BlitzGoalType.WIN) + "/" + goal.get(BlitzGoalType.WIN), EnumChatFormatting.YELLOW)).send(true);
            }
        } else {
            new FormattedMessage("BSG: No goals set.", EnumChatFormatting.GREEN).send(true);
        }
    }

}
