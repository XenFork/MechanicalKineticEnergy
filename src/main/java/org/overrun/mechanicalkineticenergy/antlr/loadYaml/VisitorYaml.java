package org.overrun.mechanicalkineticenergy.antlr.loadYaml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitorYaml extends YamlBaseVisitor<Object> {
    public final List<Record> recordList = new ArrayList<>();
    public final Map<String, Object> objectMap = new HashMap<>();
    @Override
    public Map<String, Object> visitYaml(YamlParser.YamlContext ctx) {
        Map<String, Object> objectMap = new HashMap<>();
        for (var y : ctx.y()) {
            objectMap.putAll(visitY(y));
        }
        return objectMap;
    }

    @Override
    public Map<String, Object> visitY(YamlParser.YContext ctx) {
        Map<String, Object> objectMap = new HashMap<>();
        if (ctx.code() != null) {
            objectMap.putAll(visitCode(ctx.code()));
        }
        return objectMap;
    }

    @Override
    public Map<String, Object> visitCode(YamlParser.CodeContext ctx) {
        Map<String, Object> objectMap = new HashMap<>();
        String pre = ctx.pre.getText();
        Object obj = null;
        if (ctx.sub != null) {
            obj = ctx.sub.getText();
        } else {
            for (var tabCode : ctx.tabCode()) {
                obj = visitTabCode(tabCode);
            }
        }
        objectMap.put(pre, obj);
        return objectMap;
    }

    @Override
    public Map<String, Object> visitTabCode(YamlParser.TabCodeContext ctx) {
        Map<String, Object> objectMap = new HashMap<>();
        if (ctx.code() != null) {
            objectMap = visitCode(ctx.code());
        } else {
            List<Object> list = new ArrayList<>();
            for (YamlParser.ListCodeContext listCode : ctx.listCode()) {
                list.add(visitListCode(listCode));
            }
            objectMap.put("list", list);
        }
        return objectMap;
    }

    @Override
    public Object visitListCode(YamlParser.ListCodeContext ctx) {
        String str = ctx.ID().getText();
        try {
            Integer.parseInt(str);
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            try {
                Float.parseFloat(str);
                return Float.parseFloat(str);
            } catch (NumberFormatException ex) {
                try {
                    Double.parseDouble(str);
                    return Double.parseDouble(str);
                } catch (NumberFormatException ex1) {
                    try {
                        Long.parseLong(str);
                        return Long.parseLong(str);
                    } catch (NumberFormatException ex2) {
                        try {
                            Byte.parseByte(str);
                            return Byte.parseByte(str);
                        } catch (NumberFormatException ex3) {
                            try {
                                Short.parseShort(str);
                                return Short.parseShort(str);
                            } catch (NumberFormatException ex4) {
                                return str;
                            }
                        }
                    }
                }
            }
        }
    }
}
