package org.overrun.mechanicalkineticenergy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.overrun.mechanicalkineticenergy.recipes.ShapedRegister;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.logging.Logger;

public final class MechanicalKineticEnergy extends JavaPlugin {
    private final Logger log = getLogger();
    private File mkeConfigFile;
    private FileConfiguration mkeConfig;
    private NamespacedKeys spaces;
    private final Map<String, Rec> stringMapMap = new HashMap<>();

    public FileConfiguration getMkeConfig() {
        return mkeConfig;
    }

    public static final Map<String, Material> items = new HashMap<>();

    public static void loadItems() {
        for (Material value : Material.values()) {
            items.put(value.getKey().getKey().toLowerCase(), value);
        }
    }

    @Override
    public void onEnable() {
        spaces = new NamespacedKeys(this);
        // Plugin startup logic
        log.info("load plugin...");
        createMkeConfig();
        loadItems();
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
        ShapedRegister andesite_alloy = new ShapedRegister(spaces.get("andesite_alloy_key"), stack);
//                new ShapedRecipe(spaces.get("andesite_alloy_key"), stack);
        andesite_alloy.shape("xy", "yx");
        andesite_alloy.setIngredient('x', Material.IRON_NUGGET);
        andesite_alloy.setIngredient('y', Material.ANDESITE);
        Bukkit.addRecipe(andesite_alloy);
//        ShapedRecipe test = new ShapedRecipe(new NamespacedKey(this, "test"), stack);
//        test.shape("xxx");
//        RecipeChoice.ExactChoice choice = new RecipeChoice.MaterialChoice.ExactChoice(stack);
//        test.setIngredient('x', choice);
//        Bukkit.addRecipe(test);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.resetRecipes();
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
            var split = key.split("\\.");
            System.out.println(key);
            if (split[0].equals("item")) {
                switch (split.length) {
                    case 3 -> {

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

    public static class Nbt {
        public String nbt;
        public final Map<String, String> stringNbt = new HashMap<>();
        public final Map<String, Integer> intNbt = new HashMap<>();
        public final Map<String, Float> floatNbt = new HashMap<>();
        public final Map<String, Double> doubleNbt = new HashMap<>();
        public final Map<String, Long> longNbt = new HashMap<>();
        public final Map<String, Byte> byteNbt = new HashMap<>();
        public final Map<String, Short> shortNbt = new HashMap<>();
    }

    public static class Rec {
        public String pre, sub, obj;
        public List<String> listObj;
        public Map<String, String> mapObj;
        public final Map<String, Rec> rec = new HashMap<>();
        public String key;


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
