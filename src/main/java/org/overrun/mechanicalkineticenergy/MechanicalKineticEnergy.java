package org.overrun.mechanicalkineticenergy;

import com.google.common.base.Supplier;
import com.google.common.collect.Multimap;
import jline.internal.Nullable;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.logging.Logger;

public final class MechanicalKineticEnergy extends JavaPlugin {
    private final Logger log = getLogger();
    NamespacedKey andesite_alloy_key = new NamespacedKey(this, "andesite_alloy");

    @Override
    public void onEnable() {
        // Plugin startup logic
        log.info("load plugin...");
        ItemStack stack = new ItemStack(Material.IRON_INGOT, 2);
        ItemMeta itemMeta = stack.getItemMeta();
        Objects.requireNonNull(itemMeta).setDisplayName("andesite_alloy");
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        if (persistentDataContainer.has(andesite_alloy_key, PersistentDataType.STRING)) {
            persistentDataContainer.remove(andesite_alloy_key);
        }
        persistentDataContainer.set(andesite_alloy_key, PersistentDataType.STRING, "andesite_alloy");
        for (var t : persistentDataContainer.getKeys()) {
            List<String> lore = itemMeta.getLore();
            if (lore != null) {
                lore.add(persistentDataContainer.get(t, PersistentDataType.STRING));
            } else {
                lore = new ArrayList<>();
                lore.add(persistentDataContainer.get(t, PersistentDataType.STRING));
            }
            itemMeta.setLore(lore);

        }
        stack.setItemMeta(itemMeta);
        ShapedRecipe andesite_alloy = new ShapedRecipe(andesite_alloy_key, stack);
        andesite_alloy.shape("xy", "yx");
        andesite_alloy.setIngredient('x', Material.IRON_NUGGET);
        andesite_alloy.setIngredient('y', Material.ANDESITE);
        Bukkit.addRecipe(andesite_alloy);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.warning("disable plugin");
    }
}
