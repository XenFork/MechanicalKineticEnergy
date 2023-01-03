package org.overrun.mechanicalkineticenergy.utils;

import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;


public class YamlUtils {

    public static final List<RecordItem> ITEM_RECORD_ITEM = new ArrayList<>();
    public static final List<RecordShaped> shapedRecord = new ArrayList<>();

    public static MemorySection getMemorySection(MemorySection memorySection, String key) {
        Object o = memorySection.get(key);
        if (o instanceof MemorySection m1) {
            return m1;
        }
        return null;
    }
    public static List<String> getMKeyList(MemorySection memorySection) {
        return memorySection.getKeys(true).stream().filter(s -> !s.contains(".")).toList();
    }

    public static void invokeShaped(FileConfiguration mkeConfig) {
        MemorySection m = getMemorySection(mkeConfig, "Shaped");
        if (m != null) for (String key : getMKeyList(m)) {
            RecordShaped recordShaped = new RecordShaped();
            recordShaped.recipeName = key;
            MemorySection m1 = getMemorySection(m, key);
            if (m1 != null) for (String m1Key : getMKeyList(m1)) {
                switch (m1Key) {
                    case "out" -> {
                        MemorySection m2 = getMemorySection(m1, m1Key);
                        if (m2 != null) for (String m2Key : getMKeyList(m2)) {
                            recordShaped.outNameSpaceKey = m2Key;
                            recordShaped.outSubName = m2.getString(m2Key);
                        }
                    }
                    case "shaped" -> recordShaped.shape.addAll(m1.getStringList(m1Key));
                    case "ingredient" -> {
                        MemorySection m2 = getMemorySection(m1, m1Key);
                        if (m2 != null) for (String m2Key : getMKeyList(m2)) {
                            System.out.println(m2Key);
                            Object o2 = m2.get(m2Key);
                            RecordNameSpace nameSpace = new RecordNameSpace();
                            nameSpace.key = m2Key;
                            if (o2 instanceof MemorySection m3) for (String m3Key : getMKeyList(m3)) {
                                nameSpace.value = m3.getString(m3Key);
                                recordShaped.ingredientMap.put(m3Key.charAt(0), nameSpace);
                            }
                        }
                    }
                    case "mirror" -> recordShaped.mirror = m1.getBoolean("mirror");
                }
            }
            shapedRecord.add(recordShaped);
        }
    }

    public static void invokeItem(FileConfiguration mkeConfig) {
        MemorySection m = getMemorySection(mkeConfig, "Item");
        if (m != null) for (String key : getMKeyList(m)) {
            RecordItem recordItem = new RecordItem();
            recordItem.name = key;
            MemorySection m1 = getMemorySection(m, key);
            if (m1 != null) for (String m1Key : getMKeyList(m1)) {
                MemorySection m2 = getMemorySection(m1, m1Key);
                switch (m1Key) {
                    case "name" -> {
                        if (m2 != null) for (String m2Key : m2.getKeys(true)) {
                            recordItem.namespaceKey = m2Key;
                            recordItem.materialName = m2.getString(m2Key);
                        }
                    }
                    case "nbt" -> {
                        if (m2 != null) for (String m2Key : getMKeyList(m2)) {
                            MemorySection m3 = getMemorySection(m2, m2Key);
                            switch (m2Key) {
                                case "string" -> {
                                    if (m3 != null) for (String m3Key : m3.getKeys(true))
                                        recordItem.nbt.put(m3Key, m3.getString(m3Key));
                                }
                                case "int" -> {
                                    if (m3 != null) for (String m3Key : m3.getKeys(true))
                                        recordItem.nbt.put(m3Key, m3.getInt(m3Key));
                                }
                                case "double" -> {
                                    if (m3 != null) for (String m3Key : m3.getKeys(true))
                                        recordItem.nbt.put(m3Key, m3.getDouble(m3Key));
                                }
                                case "long" -> {
                                    if (m3 != null) for (String m3Key : m3.getKeys(true))
                                        recordItem.nbt.put(m3Key, m3.getLong(m3Key));
                                }
                            }
                        }
                    }
                    case "count" -> recordItem.count = m1.getInt(m1Key);
                }
            }
            ITEM_RECORD_ITEM.add(recordItem);
        }

    }

    public static final class RecordShaped {
        private String recipeName;
        private boolean mirror;
        private String outNameSpaceKey;
        private String outSubName;
        private final List<String> shape = new ArrayList<>();
        private final Map<Character, RecordNameSpace> ingredientMap = new HashMap<>();
        public RecordShaped() {

        }

        @Override
        public int hashCode() {
            return Objects.hash(recipeName, mirror, outNameSpaceKey, outSubName, shape, ingredientMap);
        }

        public String recipeName() {
            return recipeName;
        }

        public boolean mirror() {
            return mirror;
        }

        public String outNameSpaceKey() {
            return outNameSpaceKey;
        }

        public String outSubName() {
            return outSubName;
        }
        public Map<Character, RecordNameSpace> ingredientMap() {
            return ingredientMap;
        }

        public List<String> shape() {
            return shape;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            shape.forEach(s -> sb.append("-").append(s));
            sb.append(":");
            ingredientMap.forEach((character, recordNameSpace) -> {
                sb.append(character)
                        .append("->")
                        .append("{")
                        .append(recordNameSpace.key)
                        .append(',')
                        .append(recordNameSpace.value)
                        .append("}");

            });
            return recipeName + ":" + (mirror ? "mirror" : "")+ ":" + outNameSpaceKey + "->" + outSubName +
                    sb;
        }
    }

    public static final class RecordItem {
        private String name;
        private String namespaceKey;
        private String materialName;
        private int count;
        private final Map<String, Object> nbt = new HashMap<>();

        public RecordItem() {

        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            for (Map.Entry<String, Object> entry : nbt.entrySet()) {
                String s = entry.getKey();
                Object o = entry.getValue();
                str.append(s).append("--").append(o);
            }
            return name + ":" + namespaceKey + ":" + materialName + ":" + count + ":" + str;
        }

        public String name() {
            return name;
        }

        public String namespaceKey() {
            return namespaceKey;
        }

        public String materialName() {
            return materialName;
        }

        public int count() {
            return count;
        }

        public Map<String, Object> nbt() {
            return nbt;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (RecordItem) obj;
            return Objects.equals(this.name, that.name) &&
                    Objects.equals(this.namespaceKey, that.namespaceKey) &&
                    Objects.equals(this.materialName, that.materialName) &&
                    this.count == that.count &&
                    Objects.equals(this.nbt, that.nbt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, namespaceKey, materialName, count, nbt);
        }
    }
    public static final class RecordNameSpace {
        private String key;
        private String value;

        public String key() {
            return key;
        }
        public String value() {
            return value;
        }
    }
}
