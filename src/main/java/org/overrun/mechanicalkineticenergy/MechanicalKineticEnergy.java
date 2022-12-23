package org.overrun.mechanicalkineticenergy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class MechanicalKineticEnergy extends JavaPlugin {
    private final Logger log = getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        log.info("load plugin...");
        ShapedRecipe andesite_alloy = new ShapedRecipe(new NamespacedKey(this, "andesite_alloy"), new ItemStack(Material.IRON_INGOT, 2));
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
