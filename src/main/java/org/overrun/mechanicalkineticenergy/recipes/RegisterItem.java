package org.overrun.mechanicalkineticenergy.recipes;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class RegisterItem {
    private final Plugin mke;
    public static final Map<String, ItemStack> nameStack = new HashMap<>();
    public RegisterItem(Plugin mke) {
        this.mke = mke;
    }

}
