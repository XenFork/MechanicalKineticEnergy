package org.overrun.mechanicalkineticenergy;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class MechanicalKineticEnergy extends JavaPlugin {
    private final Logger log = getLogger();
    private final Server server = getServer();
    @Override
    public void onEnable() {
        // Plugin startup logic
        log.info("load plugin...");
        ItemStack stack = new ItemStack(Material.IRON_INGOT);
        NamespacedKey ashjKey = new NamespacedKey(this, "andesite_alloy");
        ShapedRecipe ashj = new ShapedRecipe(ashjKey,stack);
        ashj.shape(
                "xy",
                "yx"
        )
                .setIngredient('x', Material.ANDESITE)
                .setIngredient('y', Material.IRON_NUGGET);
        server.addRecipe(ashj);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.warning("disable plugin");
    }
}
