package org.overrun.mechanicalkineticenergy.antlr.loadYaml;

public class Record {
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
