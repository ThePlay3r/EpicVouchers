package com.songoda.epicvouchers.menus;

import com.songoda.core.compatibility.CompatibleMaterial;
import com.songoda.core.compatibility.ServerVersion;
import com.songoda.core.utils.TextUtils;
import com.songoda.epicvouchers.EpicVouchers;
import com.songoda.epicvouchers.libraries.ItemBuilder;
import com.songoda.epicvouchers.libraries.inventory.FastInv;
import com.songoda.epicvouchers.menus.sub.editor.SetItemMenu;
import com.songoda.epicvouchers.voucher.Voucher;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.ChatColor.GRAY;
import static org.bukkit.ChatColor.YELLOW;
import static org.bukkit.Material.*;

public class OptionMenu extends FastInv {

    public OptionMenu(EpicVouchers instance, Voucher voucher) {
        super(27, "Options: " + voucher.getKey());

        addItem(13, new ItemBuilder(voucher.toItemStack()).name(TextUtils.formatText(voucher.getName(true))).build());

        addItem(18, new ItemBuilder(BARRIER)
                .name(YELLOW + "Return")
                .lore(GRAY + "Return to the editor")
                .addGlow().build(), event -> new VoucherMenu(instance).open(event.getPlayer()));

        addItem(0, new ItemBuilder(FEATHER)
                .name(TextUtils.formatText("&6Voucher actions"))
                .lore(TextUtils.formatText("&eGive or redeem your voucher"))
                .addGlow()
                .build(), event -> new ActionMenu(instance, voucher).open(event.getPlayer()));

        addItem(26, new ItemBuilder(STONE)
                .name(TextUtils.formatText("&6Set item"))
                .lore(TextUtils.formatText("&eSet the item of your voucher."))
                .addGlow().build(), event -> new SetItemMenu(instance, voucher).open(event.getPlayer()));

        addItem(8, new ItemBuilder(BOOK)
                .name(TextUtils.formatText("&6Change all options"))
                .lore(TextUtils.formatText("&eSet the options of your voucher."))
                .build(), event -> new VoucherEditorMenu(instance, voucher).open(event.getPlayer()));

        fill(new ItemBuilder(CompatibleMaterial.GRAY_STAINED_GLASS_PANE.getItem()).name(ChatColor.RESET.toString()).build());
    }

}
