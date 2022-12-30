package org.overrun.mechanicalkineticenergy.antlr.loadYaml;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadVisitor {
    public static final List<Record1> record1s = new ArrayList<>();
    public static final VisitorYaml instance = new VisitorYaml();
    private static int i;
    public static void main(String[] args) {
        String str = """
                a:
                  a_a:
                    a_a_a: 1
                b:
                  b_b:
                    b_b: 1
                    c: 1
                    d:
                      - a
                      - b
                      - c
                """;
        CharStream stream = CharStreams.fromString(str);
        YamlLexer lexer = new YamlLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        YamlParser parser = new YamlParser(tokenStream);
        Map<String, Object> stringObjectMap = instance.visitYaml(parser.yaml());
        invoke(stringObjectMap);
//        instance.recordList.forEach(System.out::println);
    }

    public static void invoke(Map<String, Object> stringObjectMap) {
        stringObjectMap.forEach((s, o) -> {
            System.out.println(s + ":" + o);
            if (o instanceof Map<?,?> map) {
                Map<String, Object> objectMap = new HashMap<>();
                map.forEach((o1, o2) -> {
                    if (o1 instanceof String str) objectMap.put(str, o2);
                });
                invoke(objectMap);
            } else if (o instanceof List<?> list) {
                list.forEach(list1 -> System.out.println(s + ":" + list1));
            } else {
                System.out.println(s + ":" + o);
            }
        });
    }

}
