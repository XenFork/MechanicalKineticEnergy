package org.overrun.mechanicalkineticenergy;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.overrun.mechanicalkineticenergy.recipe.Utils;
import org.overrun.mechanicalkineticenergy.recipe.Utils.Ing;

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
        var andesite_alloy = Utils.shapedRecipe(
                ashjKey, stack,
                new Ing[]{
                        new Ing('x', Material.ANDESITE),
                        new Ing('y', Material.IRON_NUGGET)
                },
                "xy", "yx"
        );
        server.addRecipe(andesite_alloy);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.warning("disable plugin");
    }
}
