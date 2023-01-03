package org.overrun.mechanicalkineticenergy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.overrun.mechanicalkineticenergy.recipes.ShapedRegister;
import org.overrun.mechanicalkineticenergy.utils.YamlUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import static org.overrun.mechanicalkineticenergy.utils.YamlUtils.ITEM_RECORD_ITEM;
import static org.overrun.mechanicalkineticenergy.utils.YamlUtils.shapedRecord;

public final class MechanicalKineticEnergy extends JavaPlugin {
    private final Logger log = getLogger();
    private File mkeConfigFile;

    private FileConfiguration mkeConfig;
    private NamespacedKeys spaces;

    public FileConfiguration getMkeConfig() {
        return mkeConfig;
    }

    public static final Map<String, ItemStack> items = new HashMap<>();
    public static final Map<String, ItemStack> mkeItems = new HashMap<>();

    public static void loadItems() {
        for (Material value : Material.values()) {
            ItemStack stack = new ItemStack(value);
            items.put(value.getKey().getKey().toLowerCase(), stack);
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
//        ItemStack stack = new ItemStack(Material.IRON_INGOT, 2);
//        ItemMeta itemMeta = stack.getItemMeta();
//
//        Objects.requireNonNull(itemMeta).setDisplayName("andesite_alloy");
//        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
//        if (persistentDataContainer.has(spaces.get("andesite_alloy_key"), PersistentDataType.STRING)) {
//            persistentDataContainer.remove(spaces.get("andesite_alloy_key"));
//        }
//        persistentDataContainer.set(spaces.get("andesite_alloy_key"), PersistentDataType.STRING, "andesite_alloy");
//        setLore(itemMeta, persistentDataContainer);
//        stack.setItemMeta(itemMeta);
//        ShapedRegister andesite_alloy = new ShapedRegister(spaces.get("andesite_alloy_key"), stack);
//        andesite_alloy.shape("xy", "yx");
//        andesite_alloy.setIngredient('x', Material.IRON_NUGGET);
//        andesite_alloy.setIngredient('y', Material.ANDESITE);
//        Bukkit.addRecipe(andesite_alloy);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.resetRecipes();
        log.warning("disable plugin");
    }

    public void accept(Map<String, ItemStack> mkeItems, YamlUtils.RecordItem item) {
        String regItemName = item.name();
        ItemStack stack = mkeItems.get(item.materialName());
        stack.setAmount(item.count());
        ItemMeta itemMeta = stack.getItemMeta();
        PersistentDataContainer per = Objects.requireNonNull(itemMeta).getPersistentDataContainer();
        item.nbt().forEach((s, o) -> {
            NamespacedKey key = new NamespacedKey(this, s);
            if (o instanceof String str) {
                if (per.has(key, PersistentDataType.STRING)) {
                    per.remove(key);
                }
                per.set(key, PersistentDataType.STRING, str);
            } else if (o  instanceof Integer i) {
                if (per.has(key, PersistentDataType.INTEGER)) {
                    per.remove(key);
                }
                per.set(key, PersistentDataType.INTEGER, i);
            } else if (o instanceof Float f) {
                if (per.has(key, PersistentDataType.FLOAT)) {
                    per.remove(key);
                }
                per.set(key, PersistentDataType.FLOAT, f);
            } else if (o instanceof Double d) {
                if (per.has(key, PersistentDataType.DOUBLE)) {
                    per.remove(key);
                }
                per.set(key, PersistentDataType.DOUBLE, d);
            } else if (o instanceof Long l) {
                if (per.has(key, PersistentDataType.LONG)) {
                    per.remove(key);
                }
                per.set(key, PersistentDataType.LONG, l);
            } else if (o instanceof Short ss) {
                if (per.has(key, PersistentDataType.SHORT)) {
                    per.remove(key);
                }
                per.set(key, PersistentDataType.SHORT, ss);
            } else if (o instanceof Byte b) {
                if (per.has(key, PersistentDataType.BYTE)) {
                    per.remove(key);
                }
                per.set(key, PersistentDataType.BYTE, b);
            }
        });
        setLore(itemMeta, per);
        stack.setItemMeta(itemMeta);
        mkeItems.put(regItemName, stack);
    }

    public void getYml() {
        String name = getMkeConfig().getString("Name");
        log.info(name);

        if (mkeConfig.contains("Item")) {
            YamlUtils.invokeItem(mkeConfig);
        }
        if (mkeConfig.contains("Shaped")) {
            YamlUtils.invokeShaped(mkeConfig);
        }
        ITEM_RECORD_ITEM.forEach(item -> {
            if (item.namespaceKey().equals("mke") && mkeItems.containsKey(item.materialName())) accept(mkeItems, item);
            else if (items.containsKey(item.materialName())) accept(items, item);
        });
        shapedRecord.forEach(recordShaped -> {
            ItemStack stack;
            if (recordShaped.outNameSpaceKey().equals("mke")) {
                stack = mkeItems.get(recordShaped.outSubName());
            } else {
                stack = items.get(recordShaped.outSubName());
            }
            invoke(recordShaped, stack);
            if (recordShaped.mirror()) {
                mirrorInvoke(recordShaped, stack);
            }

        });
//        ITEM_RECORD_ITEM.forEach(items -> log.info(items.toString()));
        shapedRecord.forEach(recordShaped -> log.info(recordShaped.toString()));
    }

    public void invoke(YamlUtils.RecordShaped recordShaped, ItemStack stack) {
        ShapedRegister shaped = new ShapedRegister(new NamespacedKey(this, recordShaped.recipeName()), stack);
        for (var shape : recordShaped.shape()) {
            shaped.shape(shape);
        }
        recordShaped.ingredientMap().forEach((character, recordNameSpace) -> {
            if (recordNameSpace.key().equals("mke") && mkeItems.containsKey(recordNameSpace.value())) {
                shaped.setIngredient(character, mkeItems.get(recordNameSpace.value()));
            } else if (items.containsKey(recordNameSpace.value())) {
                shaped.setIngredient(character, items.get(recordNameSpace.value()));
            }
        });
        Bukkit.addRecipe(shaped);
    }
    public void mirrorInvoke(YamlUtils.RecordShaped recordShaped, ItemStack stack) {
        ShapedRegister shaped = new ShapedRegister(new NamespacedKey(this, recordShaped.recipeName() + "_mirror"), stack);
        for (var shape : recordShaped.shape()) {
            shaped.shape(shape);
        }


        ListIterator<Map.Entry<Character, YamlUtils.RecordNameSpace>> i = new ArrayList<>(recordShaped.ingredientMap().entrySet()).listIterator(recordShaped.ingredientMap().size());
        List<Character> characters = recordShaped.ingredientMap().keySet().stream().toList();
        Map<Character, YamlUtils.RecordNameSpace> rec = new HashMap<>();
        int j = 0;
        while (i.hasPrevious()) {
            Map.Entry<Character, YamlUtils.RecordNameSpace> entry= i.previous();

            rec.put(characters.get(j), entry.getValue());
            j++;
        }

        rec.forEach((character, recordNameSpace) -> {
            if (recordNameSpace.key().equals("mke") && mkeItems.containsKey(recordNameSpace.value())) {
                shaped.setIngredient(character, mkeItems.get(recordNameSpace.value()));
            } else if (items.containsKey(recordNameSpace.value())) {
                shaped.setIngredient(character, items.get(recordNameSpace.value()));
            }
        });

        Bukkit.addRecipe(shaped);
    }

    private void setLore(ItemMeta itemMeta, PersistentDataContainer per) {
        for (var t : per.getKeys()) {
            List<String> lore = itemMeta.getLore();
            if (lore != null) {
                lore.add(per.get(t, PersistentDataType.STRING));
            } else {
                lore = new ArrayList<>();
                lore.add(per.get(t, PersistentDataType.STRING));
            }
            itemMeta.setLore(lore);
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
