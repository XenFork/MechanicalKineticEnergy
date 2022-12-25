package org.overrun.mechanicalkineticenergy.antlr.loadYaml;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class LoadVisitor {
    public static void main(String[] args) {
        String str = """
                a_A:\s
                  你好:
                    c: a
                """;
        CharStream stream = CharStreams.fromString(str);
        YamlLexer lexer = new YamlLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        YamlParser parser = new YamlParser(tokenStream);
        YamlBaseVisitor_ yamlBaseVisitor = new YamlBaseVisitor_();
        yamlBaseVisitor.visitYaml(parser.yaml());
    }

    public static class YamlBaseVisitor_ extends YamlBaseVisitor<String> {
    }
}
