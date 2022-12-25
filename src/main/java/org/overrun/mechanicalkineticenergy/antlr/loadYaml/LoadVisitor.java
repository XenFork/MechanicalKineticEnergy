package org.overrun.mechanicalkineticenergy.antlr.loadYaml;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class LoadVisitor {
    public static void main(String[] args) {
        String str = """
                a:
                  a_a:
                    a_a_a: 1
                b:
                  b_b:
                    b_b: 1
                    c: 1
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
