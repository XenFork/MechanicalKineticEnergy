package org.overrun.mechanicalkineticenergy.antlr.loadYaml;

import java.util.ArrayList;
import java.util.List;

public class Record1 extends Record {

    private final List<String> strings = new ArrayList<>();//存储list
    private final List<Integer> integers = new ArrayList<>();//存储list
    public Record1(String mode, int tabs, String pre, String sub) {
        super(mode, tabs, pre, sub);
    }

    public List<String> getStrings() {
        return strings;
    }

    public List<Integer> getIntegers() {
        return integers;
    }
}
