package com.kevyporter.pixelplus.hud;

import com.kevyporter.pixelplus.PixelPlusMod;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 3/12/2015.
 */
public class DmgHud {

    private static List<String> armorReduct = new ArrayList<String>();

    private static void getReduction() {
        EntityPlayer me = Minecraft.getMinecraft().thePlayer;
        double armor = 0.0;
        int epf = 0;
        int resistance = 0;


        if(me.isPotionActive(Potion.resistance)) {
            resistance = me.getActivePotionEffect(Potion.resistance).getAmplifier() + 1;
        }

        for(ItemStack itemStack : me.inventory.armorInventory) {
            if(itemStack == null)
                continue;
            if(itemStack.getItem() instanceof ItemArmor) {
                ItemArmor armorItem = (ItemArmor)itemStack.getItem();
                armor += armorItem.damageReduceAmount * 0.04;
            }

            if(itemStack.isItemEnchanted()) {
                epf += getEffProtPoints(EnchantmentHelper.getEnchantmentLevel(0, itemStack), 0.75);
            }
        }

        epf = epf < 25 ? epf : 25;

        double avgdef = addArmorProtResistance(armor, calcProtection(epf), resistance);
        double mindef = addArmorProtResistance(armor, Math.ceil(epf / 2.0D), resistance);
        double maxdef = addArmorProtResistance(armor, Math.ceil(epf < 20.0D ? epf : 20.0D), resistance);
        double min = roundDouble(mindef * 100.0D);
        double max = roundDouble(maxdef * 100.0D);
        double avg = roundDouble(avgdef * 100.0D);
        armorReduct.add(0, min + "");
        armorReduct.add(1, max + "");
        armorReduct.add(2, avg + "");
    }

    private static int getEffProtPoints(int level, double typeModifier) {
        return level != 0 ? (int)Math.floor((6 + level*level) * typeModifier / 3) : 0;
    }

    private static double addArmorProtResistance(double armor, double prot, int resi) {
        double protTotal = armor + (1.0D - armor) * prot * 0.04D;
        protTotal += (1.0D - protTotal) * resi * 0.2D;
        return protTotal < 1.0D ? protTotal : 1.0D;
    }

    private static double calcProtection(double armorEpf) {
        double protection = 0.0D;
        for (int i = 50; i <= 100; i++) {
            protection += (Math.ceil(armorEpf * i / 100.0D) < 20.0D ? Math.ceil(armorEpf * i / 100.0D) : 20.0D);
        }
        return protection / 51.0D;
    }

    private static double roundDouble(double number) {
        double x = Math.round(number * 10000.0D);
        return x / 10000.0D;
    }

    public static void onRender() {
        try {
            if(PixelPlusMod.getInstance().CONFIG.dmghud_enabled) {
                getReduction();
                Minecraft.getMinecraft().fontRendererObj.drawString(PixelPlusMod.getInstance().CONFIG.dmghud_mcolor.substring(0, 2) + "Armor Value: " + PixelPlusMod.getInstance().CONFIG.dmghud_vcolor.substring(0, 2) + armorReduct.get(2) + "%", PixelPlusMod.getInstance().CONFIG.dmghud_x, PixelPlusMod.getInstance().CONFIG.dmghud_y, 0xFFFFFF);
            }
        } catch (Exception ex) {
            System.out.println("Error in onRender() in DmgHud.java");
            ex.printStackTrace();
        }
    }

}
