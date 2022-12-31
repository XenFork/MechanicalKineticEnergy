package org.overrun.mechanicalkineticenergy.utils;

import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;
import java.util.stream.Collectors;

import static org.overrun.mechanicalkineticenergy.MechanicalKineticEnergy.itemRecord;

public class YamlUtils {
    public static void invokeShaped(FileConfiguration mkeConfig) {
        Object shaped = mkeConfig.get("Shaped");
    }

    public static void invokeItem(FileConfiguration mkeConfig) {
        Object item = mkeConfig.get("Item");
        if (item instanceof MemorySection m) {
            for (String key : m.getKeys(true)) {
                if (!key.contains(".")) {
                    Record record = new Record();
                    record.name = key;
                    Object regItemName = m.get(key);
                    if ( regItemName instanceof MemorySection m1) {
                        for (String m1Key : m1.getKeys(true)) {
                            if (!m1Key.contains(".")) {
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
                                            for (String m2Key : m2.getKeys(true)) {
                                                if (!m2Key.contains(".")) {
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
                                    }
                                    case "count" -> {
                                        if (o instanceof Integer i) {
                                            record.count = i;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    itemRecord.add(record);
                }

            }
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
}
