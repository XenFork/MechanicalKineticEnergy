package org.overrun.mechanicalkineticenergy.recipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.overrun.mechanicalkineticenergy.MechanicalKineticEnergy;
import org.overrun.mechanicalkineticenergy.MechanicalKineticEnergy.Nbt;
import org.overrun.mechanicalkineticenergy.MechanicalKineticEnergy.Rec;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.overrun.mechanicalkineticenergy.MechanicalKineticEnergy.items;

public class RegisterItem {
    private Plugin mke;
    public static final Map<String, ItemStack> nameStack = new HashMap<>();
    public RegisterItem(Plugin mke) {
        this.mke = mke;
    }
    public void registerItem(String spaceName, String itemName, int count, Nbt nbt) {
        NamespacedKey key = new NamespacedKey(mke, spaceName);
        if (items.containsKey(itemName)) {
            ItemStack stack = new ItemStack(items.get(itemName), count);
            ItemMeta meta = stack.getItemMeta();
            PersistentDataContainer persistentDataContainer = Objects.requireNonNull(meta).getPersistentDataContainer();
            if (!nbt.stringNbt.isEmpty()) {
                for (var n : nbt.stringNbt.keySet()) {
                    NamespacedKey nbtNameKey = new NamespacedKey(mke, n);
                    if (persistentDataContainer.has(nbtNameKey, PersistentDataType.STRING)) {
                        persistentDataContainer.remove(nbtNameKey);
                    }
                    persistentDataContainer.set(nbtNameKey, PersistentDataType.STRING, nbt.stringNbt.get(n));
                }
            }

            if (!nbt.intNbt.isEmpty()) {
                for (var n : nbt.intNbt.keySet()) {
                    NamespacedKey nbtNameKey = new NamespacedKey(mke, n);
                    if (persistentDataContainer.has(nbtNameKey, PersistentDataType.INTEGER)) {
                        persistentDataContainer.remove(nbtNameKey);
                    }
                    persistentDataContainer.set(nbtNameKey, PersistentDataType.INTEGER, nbt.intNbt.get(n));
                }
            }

            if (!nbt.floatNbt.isEmpty()) {
                for (var n : nbt.floatNbt.keySet()) {
                    NamespacedKey nbtNameKey = new NamespacedKey(mke, n);
                    if (persistentDataContainer.has(nbtNameKey, PersistentDataType.FLOAT)) {
                        persistentDataContainer.remove(nbtNameKey);
                    }
                    persistentDataContainer.set(nbtNameKey, PersistentDataType.FLOAT, nbt.floatNbt.get(n));
                }
            }

            if (!nbt.doubleNbt.isEmpty()) {
                for (var n : nbt.doubleNbt.keySet()) {
                    NamespacedKey nbtNameKey = new NamespacedKey(mke, n);
                    if (persistentDataContainer.has(nbtNameKey, PersistentDataType.DOUBLE)) {
                        persistentDataContainer.remove(nbtNameKey);
                    }
                    persistentDataContainer.set(nbtNameKey, PersistentDataType.DOUBLE, nbt.doubleNbt.get(n));
                }
            }

            if (!nbt.longNbt.isEmpty()) {
                for (var n : nbt.longNbt.keySet()) {
                    NamespacedKey nbtNameKey = new NamespacedKey(mke, n);
                    if (persistentDataContainer.has(nbtNameKey, PersistentDataType.LONG)) {
                        persistentDataContainer.remove(nbtNameKey);
                    }
                    persistentDataContainer.set(nbtNameKey, PersistentDataType.LONG, nbt.longNbt.get(n));
                }
            }

            if (!nbt.shortNbt.isEmpty()) {
                for (var n : nbt.shortNbt.keySet()) {
                    NamespacedKey nbtNameKey = new NamespacedKey(mke, n);
                    if (persistentDataContainer.has(nbtNameKey, PersistentDataType.SHORT)) {
                        persistentDataContainer.remove(nbtNameKey);
                    }
                    persistentDataContainer.set(nbtNameKey, PersistentDataType.SHORT, nbt.shortNbt.get(n));
                }
            }

            if (!nbt.byteNbt.isEmpty()) {
                for (var n : nbt.byteNbt.keySet()) {
                    NamespacedKey nbtNameKey = new NamespacedKey(mke, n);
                    if (persistentDataContainer.has(nbtNameKey, PersistentDataType.BYTE)) {
                        persistentDataContainer.remove(nbtNameKey);
                    }
                    persistentDataContainer.set(nbtNameKey, PersistentDataType.BYTE, nbt.byteNbt.get(n));
                }
            }
        }

    }
}
