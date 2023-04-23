package ast.variables;

import ast.nodes.Node;

public class BinaryExpr extends Node {
boolean value;

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public BinaryExpr(int line, String parent, String type, int childCount, boolean value) {
        super(line, parent, type, childCount);
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinaryExpr{" +
                "value=" + value +
                ", line=" + line +
                ", col=" + col +
                ", type='" + type + '\'' +
                ", childCount=" + childCount +
                ", parent='" + parent + '\'' +
                '}';
    }
}
