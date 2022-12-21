package org.overrun.mechanicalkineticenergy;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MechanicalKineticEnergy extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("load plugin...");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("disable plugin...");
    }
}
