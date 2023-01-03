package org.overrun.mechanicalkineticenergy.utils;

import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class YamlUtils {

    public static final List<Record> itemRecord = new ArrayList<>();
    public static final List<RecordShaped> shapedRecord = new ArrayList<>();

    public static void invokeShaped(FileConfiguration mkeConfig) {
        Object shaped = mkeConfig.get("Shaped");
        if (shaped instanceof MemorySection m) {
            for (String key : m.getKeys(true).stream().filter(s -> !s.contains(".")).toList()) {
                RecordShaped recordShaped = new RecordShaped();
                recordShaped.recipeName = key;
                Object o = m.get(key);
                if (o instanceof MemorySection m1) {
                    for (String m1Key : m1.getKeys(true).stream().filter(s -> !s.contains(".")).toList()) {

                        switch (m1Key) {
                            case "out" -> {
                                Object o1 = m1.get(m1Key);
                                if (o1 instanceof MemorySection m2) {
                                    for (String m2Key : m2.getKeys(true).stream().filter(s -> !s.contains(".")).toList()) {
                                        recordShaped.outNameSpaceKey = m2Key;
                                        recordShaped.outSubName = m2.getString(m2Key);
                                    }
                                }
                            }
                            case "shaped" -> recordShaped.shape.addAll(m1.getStringList(m1Key));
                            case "ingredient" -> {

                                Object o1 = m1.get(m1Key);
                                if (o1 instanceof MemorySection m2) {
                                    for (String m2Key : m2.getKeys(true).stream().filter(s -> !s.contains(".")).toList()) {
                                        System.out.println(m2Key);
                                        Object o2 = m2.get(m2Key);
                                        RecordNameSpace nameSpace = new RecordNameSpace();
                                        nameSpace.key = m2Key;
                                        if (o2 instanceof MemorySection m3) {
                                            for (String m3Key : m3.getKeys(true).stream().filter(s -> !s.contains(".")).toList()) {
                                                nameSpace.value = m3.getString(m3Key);
                                                recordShaped.ingredientMap.put(m3Key.charAt(0), nameSpace);
                                            }
                                        }
                                    }
                                }

                            }
                            case "mirror" -> recordShaped.mirror = m1.getBoolean("mirror");
                        }
                    }
                }
                shapedRecord.add(recordShaped);
            }
        }
    }

    public static void invokeItem(FileConfiguration mkeConfig) {
        Object item = mkeConfig.get("Item");
        if (item instanceof MemorySection m) {
            for (String key : m.getKeys(true).stream().filter(s -> !s.contains(".")).toList()) {
                Record record = new Record();
                record.name = key;
                Object regItemName = m.get(key);
                if ( regItemName instanceof MemorySection m1) {
                    for (String m1Key : m1.getKeys(true).stream().filter(s -> !s.contains(".")).toList()) {
                        Object o = m1.get(m1Key);
                        switch (m1Key) {
                            case "name" -> {
                                if (o instanceof MemorySection m2) {
                                    for (String m2Key : m2.getKeys(true)) {
                                        record.namespaceKey = m2Key;
                                        record.materialName = m2.getString(m2Key);
                                    }
                                }
                            }
                            case "nbt" -> {
                                if (o instanceof MemorySection m2) {
                                    for (String m2Key : m2.getKeys(true).stream().filter(s -> !s.contains(".")).toList()) {
                                        switch (m2Key) {
                                            case "string" -> {
                                                Object o1 = m2.get(m2Key);
                                                if (o1 instanceof MemorySection m3) {
                                                    for (String m3Key : m3.getKeys(true)) {
                                                        record.nbt.put(m3Key, m3.getString(m3Key));
                                                    }
                                                }
                                            }
                                            case "int" -> {
                                                Object o1 = m2.get(m2Key);
                                                if (o1 instanceof MemorySection m3) {
                                                    for (String m3Key : m3.getKeys(true)) {
                                                        record.nbt.put(m3Key, m3.getInt(m3Key));
                                                    }
                                                }
                                            }
                                            case "double" -> {
                                                Object o1 = m2.get(m2Key);
                                                if (o1 instanceof MemorySection m3) {
                                                    for (String m3Key : m3.getKeys(true)) {
                                                        record.nbt.put(m3Key, m3.getDouble(m3Key));
                                                    }
                                                }
                                            }
                                            case "long" -> {
                                                Object o1 = m2.get(m2Key);
                                                if (o1 instanceof MemorySection m3) {
                                                    for (String m3Key : m3.getKeys(true)) {
                                                        record.nbt.put(m3Key, m3.getLong(m3Key));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            case "count" -> {
                                if (o instanceof Integer i) {
                                    record.count = i;
                                }
                            }
                        }
                    }
                }
                itemRecord.add(record);
            }
        }

    }

    public static final class RecordShaped {
        private String recipeName;
        private boolean mirror;
        private String outNameSpaceKey;
        private String outSubName;
        private List<String> shape = new ArrayList<>();
        private final Map<Character, RecordNameSpace> ingredientMap = new HashMap<>();
        public RecordShaped() {

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

    public static final class Record {
        private String name;
        private String namespaceKey;
        private String materialName;
        private int count;
        private final Map<String, Object> nbt = new HashMap<>();

        public Record() {

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
            var that = (Record) obj;
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
    }
}
