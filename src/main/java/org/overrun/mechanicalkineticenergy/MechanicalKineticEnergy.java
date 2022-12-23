package org.overrun.mechanicalkineticenergy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public final class MechanicalKineticEnergy extends JavaPlugin {
    private final Logger log = getLogger();
    private File mkeConfigFile;
    private FileConfiguration mkeConfig;
    private NamespacedKeys spaces;

    public FileConfiguration getMkeConfig() {
        return mkeConfig;
    }

    @Override
    public void onEnable() {
        spaces = new NamespacedKeys(this);
        // Plugin startup logic
        log.info("load plugin...");
        createMkeConfig();
        getYml();
        ItemStack stack = new ItemStack(Material.IRON_INGOT, 2);
        ItemMeta itemMeta = stack.getItemMeta();

        Objects.requireNonNull(itemMeta).setDisplayName("andesite_alloy");
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        if (persistentDataContainer.has(spaces.get("andesite_alloy_key"), PersistentDataType.STRING)) {
            persistentDataContainer.remove(spaces.get("andesite_alloy_key"));
        }
        persistentDataContainer.set(spaces.get("andesite_alloy_key"), PersistentDataType.STRING, "andesite_alloy");
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
        ShapedRecipe andesite_alloy = new ShapedRecipe(spaces.get("andesite_alloy_key"), stack);
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

    public void getYml() {
        String name = getMkeConfig().getString("name");
        log.info(name);
        ShapedRecipe SRP;
        int mode = 0;
        String itemName = null, spaceName = null;
        int count = 0;
        Map<String, String> nbt = new HashMap<>();
        Map<String, String> ingredient = new HashMap<>();
        List<String> shape = new ArrayList<>();
        for (String key : getMkeConfig().getKeys(true)) {
//            getMkeConfig().getValues(true).get(key);
            if (key.contains("Shaped")) {
                var split = key.split("\\.");
                switch (mode) {
                    case 0 -> {
                        //初始化
                        if (split.length == 2) {
                            spaceName = split[split.length - 1];
                            mode = 2;
                        }
                    }
                    case 1 -> {
                        if (itemName != null && spaceName != null && count != 0) {
                            ItemStack stack = new ItemStack(Objects.requireNonNull(Material.getMaterial(itemName)), count);
                            ItemMeta meta = stack.getItemMeta();
                            Objects.requireNonNull(meta).setDisplayName(itemName);
                            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
                            if (!nbt.isEmpty()) {
                                for (var a : nbt.keySet()) {
                                    var s = new NamespacedKey(this, a);
                                    if (persistentDataContainer.has(s, PersistentDataType.STRING)) {
                                        persistentDataContainer.remove(s);
                                    }
                                    persistentDataContainer.set(s, PersistentDataType.STRING, nbt.get(a));
                                }
                            }
                            ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, spaceName), stack);
                            if (!shape.isEmpty()) {
                                recipe.shape(shape.toArray(new String[0]));
                                if (!ingredient.isEmpty()) {
                                    for (var ing : ingredient.keySet()) {
                                        Material material = Material.getMaterial(ingredient.get(ing));
                                        if (material)
                                        recipe.setIngredient(ing.charAt(0), )
                                    }
                                }
                            }
                        }
                    }
                    case 2 -> {
                        if (split[split.length - 1].equals("shape")) mode = 3;
                        else if (key.contains("nbt"))
                            if (split[split.length - 2].equals("nbt"))
                                nbt.put(split[split.length - 1], getMkeConfig().getString(key));
                            else if (key.contains("name"))
                                itemName = getMkeConfig().getString(key);
                            else count = getMkeConfig().getInt(key);
                    }
                    case 3 -> {
                        if (split.length == 2) {
                            mode = 1;
                            continue;
                        }
                        if (key.contains("ingredient")) {
                            if (split[split.length - 2].equals("ingredient")) {
                                ingredient.put(split[split.length - 1], getMkeConfig().getString(key));
                            }
                        } else if (split[split.length - 1].equals("shape")) {
                            shape.addAll(getMkeConfig().getStringList(key));
                        }

                    }
                }
            }

        }
    }

    private void createMkeConfig() {
        mkeConfigFile = new File(getDataFolder(), "mke.yml");
        if (!mkeConfigFile.exists()) {
            mkeConfigFile.getParentFile().mkdirs();
            saveResource("mke.yml", false);
        }
        mkeConfig = new YamlConfiguration();
        try {
            mkeConfig.load(mkeConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    public static class NamespacedKeys {
        public final Map<String, NamespacedKey> namespacedKeyMap = new HashMap<>();
        private final Plugin plugin;
        public NamespacedKeys(Plugin plugin) {
            this.plugin = plugin;
        }

        public void add(String name) {
            namespacedKeyMap.put(name, new NamespacedKey(plugin, name));
        }
        public NamespacedKey get(String name) {
            return namespacedKeyMap.containsKey(name) ? namespacedKeyMap.get(name) : NamespacedKey.minecraft("null");
        }

    }
}
