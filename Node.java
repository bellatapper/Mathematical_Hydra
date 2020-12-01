package main;

import java.util.LinkedList;
import java.util.ArrayList;

public class Node {
    private Node parent;
    private LinkedList<Node> children;
    private SetOfNodes setOfNodes;
    private int value;
    private int layer;

    public Node() {
        this.parent = null;
        children = new LinkedList<>();
        setOfNodes = null;
        value = 0;
        layer = 1;
    }

    public int getValue() {
        return this.value;
    }

    public ArrayList<Integer> getArrayOfChildren() {
        ArrayList<Integer> valueArray = new ArrayList<>();
        for (Node nodes : children) {
            valueArray.add(nodes.value);
        }
        return valueArray;
    }

    public LinkedList<Node> getChildren() {
        LinkedList<Node> valueList = new LinkedList<>();
        for(Node nodes : children) {
            valueList.add(nodes);
        }
        return valueList;
    }

    public SetOfNodes getSetOfNodes() {
        return this.setOfNodes;
    }

    public void assignSetOfNodes(SetOfNodes setOfNodes) {
        this.setOfNodes = setOfNodes;
    }

    public void addNewChild(Node node) {
        this.children.add(node);
    }

    public int getLayer() {
        return this.layer;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}
