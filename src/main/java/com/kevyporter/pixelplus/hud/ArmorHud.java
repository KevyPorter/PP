package com.kevyporter.pixelplus.hud;

import com.kevyporter.pixelplus.PixelPlusMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 3/12/2015.
 */
public class ArmorHud {

    private static List<ItemStack> inv = new ArrayList<ItemStack>();

    public static void render() {
        if (PixelPlusMod.getInstance().CONFIG.armorhud_enabled) {
            getInventory();
            RenderItem itemRenderer = Minecraft.getMinecraft().getRenderItem();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            RenderHelper.enableGUIStandardItemLighting();
            itemRenderer.zLevel = 200.0F;
            int h = PixelPlusMod.getInstance().CONFIG.armorhud_y;
            for(int i = 0; i < inv.size(); i++) {
                itemRenderer.renderItemAndEffectIntoGUI(inv.get(i), PixelPlusMod.getInstance().CONFIG.armorhud_x, h);
                h += 16;
            }
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public static void getInventory() {
        inv.clear();
        if(Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem() != null) {
            inv.add(0, Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem());
        }
        if(Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(3) != null) {
            inv.add(Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(3));
        }
        if(Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(2) != null) {
            inv.add(Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(2));
        }
        if(Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(1) != null) {
            inv.add(Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(1));
        }
        if(Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(0) != null) {
            inv.add(Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(0));
        }
    }

}
