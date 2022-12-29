package org.overrun.mechanicalkineticenergy.antlr.loadYaml;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;

public class LoadVisitor {
    public static class Record {
        private String mode;
        private String pre;
        private String sub;
        private final int tabs;

        public Record(String mode, int tabs, String pre, String sub) {
            this.mode = mode;
            this.pre = pre;
            this.sub = sub;
            this.tabs = tabs;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
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

        public int getTabs() {
            return tabs;
        }

        @Override
        public String toString() {
            return mode + ":" + tabs + ":" + pre + ":" + sub;
        }
    }
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
        YamlBaseVisitor_ yamlBaseVisitor = new YamlBaseVisitor_();
        yamlBaseVisitor.visitYaml(parser.yaml());
        yamlBaseVisitor.recordList.forEach(System.out::println);
    }
    public static class YamlBaseVisitor_ extends YamlBaseVisitor<String> {
        public final List<Record> recordList = new ArrayList<>();
        @Override
        public String visitYaml(YamlParser.YamlContext ctx) {
            for (var y : ctx.y()) {
                visitY(y);
            }
            return "load " + ctx.y().size() + "y";
        }

        @Override
        public String visitY(YamlParser.YContext ctx) {

            int i = ctx.tabs != null ? YamlLexer.getspaceCount(ctx.tabs.getText()) / 2 : 0;
            recordList.add(ctx.code() != null ? new Record("code", i, ctx.code().pre.getText(), ctx.code().sub != null ? ctx.code().sub.getText() : null) :
                    new Record("list", i, null, ctx.listCode() != null ? ctx.listCode().list.getText() : null));
            return null;
        }
    }
}
