package org.overrun.mechanicalkineticenergy.antlr.loadYaml;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Record1 {
    private String pre;
    private String sub;
    private final List<Record1> record1s = new ArrayList<>();
    private final List<Object> list = new ArrayList<>();
    public Record1(String pre, String sub) {
        this.pre = pre;
        this.sub = sub;
    }

    public List<Record1> getRecord1s() {
        return record1s;
    }

    public void addRecord1s(@NotNull Record1 record1) {
        record1s.add(record1);
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
    public void add(String str) {
        try {
            Integer.parseInt(str);
            list.add(Integer.parseInt(str));
//            integers.add(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            try {
                Float.parseFloat(str);
                list.add(Float.parseFloat(str));
//                floats.add(Float.parseFloat(str));
            } catch (NumberFormatException ex) {
                try {
                    Double.parseDouble(str);
                    list.add(Double.parseDouble(str));
                } catch (NumberFormatException ex1) {
                    try {
                        Long.parseLong(str);
                        list.add(Long.parseLong(str));
                    } catch (NumberFormatException ex2) {
                        try {
                            Byte.parseByte(str);
                            list.add(Byte.parseByte(str));
                        } catch (NumberFormatException ex3) {
                            try {
                                Short.parseShort(str);
                                list.add(Short.parseShort(str));
                            } catch (NumberFormatException ex4) {
                                list.add(str);
                            }
                        }
                    }
                }
            }

        }
    }

    public List<?> getList() {
        return list;
    }

    @Override
    public String toString() {
        return pre + ":" + sub + ":" + Arrays.toString(record1s.toArray(new Record1[0])) + ":" + Arrays.toString(list.toArray(new Object[0]));
    }
}
