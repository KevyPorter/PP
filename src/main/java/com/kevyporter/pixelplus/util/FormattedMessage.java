package com.kevyporter.pixelplus.util;

import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.client.FMLClientHandler;

import java.util.ArrayList;

/**
 * Created by Kevy on 12/08/2015.
 */
    public class FormattedMessage {
    private static IChatComponent CHAT_PREFIX;
    public static String SEPARATION_MESSAGE = "\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC\u25AC";
    private IChatComponent chatComponent;
    private ArrayList<FormattedMessage> appendedMessages;

    /**
     * Creates a new FormattedMessage.
     *
     * @param text Text of the chat message.
     */
    public FormattedMessage(String text) {
        this.chatComponent = new ChatComponentText(text);
    }

    /**
     * Creates a new FormattedMessage.
     *
     * @param text  Text of the chat message.
     * @param color Color of the chat message.
     */
    public FormattedMessage(String text, EnumChatFormatting color) {
        this(text);
        this.addFormatting(color);
    }

    /**
     * Adds a formatting to the text message. The FormattedMessage used is modified.
     *
     * @return The FormattedMessage instance in order to make code more compact.
     */
    public FormattedMessage addFormatting(EnumChatFormatting formatting) {
        ChatStyle style = this.chatComponent.getChatStyle();
        switch (formatting) {
            case ITALIC:
                style.setItalic(true);
                break;
            case BOLD:
                style.setBold(true);
                break;
            case UNDERLINE:
                style.setUnderlined(true);
                break;
            case OBFUSCATED:
                style.setObfuscated(true);
                break;
            case STRIKETHROUGH:
                style.setStrikethrough(true);
                break;
            default:
                style.setColor(formatting);
                break;
        }
        this.chatComponent.setChatStyle(style);

        return this;
    }

    /**
     * Append a message to the an existing message. This is used to achieve multiple colors in one line.
     *
     * @param message message to append
     * @return The FormattedMessage instance in order to make code more compact.
     */
    public FormattedMessage appendMessage(FormattedMessage message) {
        // Make sure appendedMessages gets created
        if (this.appendedMessages == null) {
            this.appendedMessages = new ArrayList<FormattedMessage>();
        }
        // Add the message
        this.appendedMessages.add(message);
        // And add messages which were added to the message
        if (message.appendedMessages != null) {
            this.appendedMessages.addAll(message.appendedMessages);
        }

        return this;
    }

    /**
     * Makes the chat message clickable.
     *
     * @param action      Action performed by clicking
     * @param execute     URL or command to execute
     * @param description Shown message when hovering over the clickable chat.
     * @return The FormattedMessage instance in order to make code more compact.
     */
    public FormattedMessage makeClickable(ClickEvent.Action action, String execute, FormattedMessage description) {
        ChatStyle style = this.chatComponent.getChatStyle();

        style.setChatClickEvent(new ClickEvent(action, execute));
        style.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, description.assembleMessage(false)));

        this.chatComponent.setChatStyle(style);

        return this;
    }

    /**
     * Makes the chat message link to a given url.
     *
     * @param url The linked URL. MAKE SURE IT STARTS WITH HTTP:// or HTTPS://!
     * @return The FormattedMessage instance in order to make code more compact.
     */
    public FormattedMessage makeLink(String url) {
        // Compose a generic description
        FormattedMessage description = new FormattedMessage("Click to visit ", EnumChatFormatting.GRAY);
        description.appendMessage(new FormattedMessage(url, EnumChatFormatting.AQUA).addFormatting(EnumChatFormatting.UNDERLINE));
        // and make it clickable
        this.makeClickable(ClickEvent.Action.OPEN_URL, url, description);

        return this;
    }

    /**
     * Creates a tooltip like hover text.
     *
     * @param text the message shown then hovering
     * @return The FormattedMessage instance in order to make code more compact.
     */
    public FormattedMessage makeHover(FormattedMessage text) {
        ChatStyle style = this.chatComponent.getChatStyle();

        style.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, text.assembleMessage(false)));

        this.chatComponent.setChatStyle(style);

        return this;
    }

    /**
     * Send this message to the player. (with [Pixel+] prefix)
     */
    public void send() {
        this.send(true);
    }

    /**
     * Send this message to the player.
     *
     * @param prefix Send the [Pixel+] prefix?
     */
    public void send(boolean prefix) {
        try {
            // send the assebled message to the player
            FMLClientHandler.instance().getClientPlayerEntity().addChatMessage(this.assembleMessage(prefix));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Builds an IChatComponent including all appended messages.
     *
     * @param prefix should [Pixel+] be added as chat prefix?
     * @return the IChatComponent containing all appended messages
     */
    protected IChatComponent assembleMessage(boolean prefix) {
        IChatComponent result;
        if (prefix) {
            // Copy the prefix
            result = CHAT_PREFIX.createCopy();
        } else if (this.appendedMessages == null) {
            // Nothing to append
            return this.chatComponent;
        } else {
            // this step is important so that the appended messages don't inherit the style
            result = new ChatComponentText("");
        }

        // add the main message
        result.appendSibling(this.chatComponent);
        // and add all appended messages
        if (this.appendedMessages != null) {
            for (FormattedMessage m : this.appendedMessages) {
                result.appendSibling(m.chatComponent);
            }
        }

        return result;
    }

    // Builds the chat prefix
    static {
        IChatComponent name1 = new ChatComponentText("Pixel");
        IChatComponent name2 = new ChatComponentText("+");
        name1.getChatStyle().setColor(EnumChatFormatting.AQUA);
        name2.getChatStyle().setColor(EnumChatFormatting.DARK_AQUA);

        CHAT_PREFIX = new ChatComponentText("[").appendSibling(name1).appendSibling(name2).appendSibling(new ChatComponentText("] "));
    }

    /**
     * Prints a Hypixel style separaton message using the provided color.
     */
    public static void printSeparationMessage(EnumChatFormatting color) {
        new FormattedMessage(SEPARATION_MESSAGE, color).addFormatting(EnumChatFormatting.BOLD).send(false);
    }
}
