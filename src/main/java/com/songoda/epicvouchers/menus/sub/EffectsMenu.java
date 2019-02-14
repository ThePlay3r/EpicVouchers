package com.songoda.epicvouchers.menus.sub;

import com.songoda.epicvouchers.EpicVouchers;
import com.songoda.epicvouchers.libraries.ItemBuilder;
import com.songoda.epicvouchers.libraries.inventory.IconInv;
import com.songoda.epicvouchers.libraries.inventory.icons.IntegerIcon;
import com.songoda.epicvouchers.libraries.inventory.icons.StringIcon;
import com.songoda.epicvouchers.menus.VoucherEditorMenu;
import com.songoda.epicvouchers.voucher.Voucher;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.ChatColor.GRAY;
import static org.bukkit.ChatColor.YELLOW;

public class EffectsMenu extends IconInv {
    public EffectsMenu(EpicVouchers instance, Voucher voucher) {
        super(9, "Titles");

        addIcon(1, new StringIcon(instance, "Effect", voucher.getEffect(), (player, editString) -> {
            voucher.setEffect(editString).saveSetting("effects.effect", editString);
            new EffectsMenu(instance, voucher).open(player);
        }));

        addIcon(2, new IntegerIcon(instance, "Effect Amplifier", voucher.getEffectAmplifier(), (player, number) -> {
            voucher.setEffectAmplifier(number).saveSetting("effects.amplifier", number);
            new EffectsMenu(instance, voucher).open(player);
        }));

        addIcon(3, new IntegerIcon(instance, "Duration", voucher.getEffectDuration(), (player, number) -> {
            voucher.setEffectDuration(number).saveSetting("effects.duration", number);
            new EffectsMenu(instance, voucher).open(player);
        }));

        addIcon(0, new ItemBuilder(Material.BARRIER)
                .name(YELLOW + "Return")
                .lore(GRAY + "Return to the editor")
                .build(), event -> new VoucherEditorMenu(instance, voucher).open(event.getPlayer()));

    }
}