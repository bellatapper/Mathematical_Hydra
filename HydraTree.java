package main;
import java.util.LinkedList;

public class HydraTree<T> {

    public int uniqueID;
    private int size;
    private static NodeID nodeID;
    private static NodeHashMap nodeHashMap;

    public HydraTree() {
        uniqueID = 0;
        nodeID = new NodeID();
        nodeHashMap = new NodeHashMap();
    }

    public int getSize() {
        return size;
    }

    public void increaseSize() {
        size++;
    }

    public static Integer getNodeValue(int value) {
        return nodeHashMap.get(value).getValue();
    }

    public static Node getNode(int value) {
        return nodeHashMap.get(value);
    }

    public static void removeNode(Node node) {
        if (node.getChildren().isEmpty()) {
            node.getSetOfNodes().removeNode(node);
            nodeHashMap.remove(node.getValue());
            System.out.println("går in i if satsen i removeNode");
        }
        else {
            System.out.println("Remove a leaf! Not a head with children! Please."); //exception
        }
    }

    /**
     * newCopy is used to add a branch.
     */
    public void newCopy(Node mommy){
        System.out.println(mommy.getArrayOfChildren() + " is number "+ mommy.getValue() + "'s children");
        Node newBranch = new Node();
        if (mommy.getParent() != null) { //Om det finns en grandparent så ska kloning ske!
            if(mommy.getArrayOfChildren().size() == 0){
                System.out.println("ny nod till " + mommy.getParent().getValue());
                addChild(mommy.getParent());
            }
            else {
                copyTree(mommy);
            }
        }
        else if (mommy.getChildren()==null && mommy.getParent() == null){ //Om noden är ensam rot kommer man vinna så fort man kallar på remove
            System.out.println("You won!");
            return;
        }
        mommy.addNewChild(newBranch); //lägg till helt träd till nytt träd
        nodeHashMap.add(newBranch.getValue(), newBranch); //lägg till en nod i hashmap
    }

    /**
     * copyTree is used to get a branch. Helper method to newCopy.
     */
    public void copyTree(Node mommy) {
        if (mommy.getChildren().size() == 0){
            return;
        }
        else {
            for (Node eachChild : mommy.getChildren()) {
                System.out.println("copyTree");
                addChild(eachChild);
                copyTree(eachChild);
            }
        }
    }

    public void cutNode(Node node){
        int parent = node.getParent().getValue();
        removeNode(node);
        Node parentChild = getNode(parent).getArrayOfChildren().getNode(index 0);
        removeNode(parentChild);
        newCopy(getNode(parent));
        newCopy(getNode(parent));
        System.out.println(getNode(parent).getArrayOfChildren() + " är barnet till " + getNode(parent));
        System.out.println("Congrats, 1 less head to kill..."); //Removing a head closest to root.
    }

    //returning the new node added to parentNode
    public void addChild(Node parentNode) {
        Node node = new Node();
        node.setParent(parentNode);
        node.setValue(nodeID.getNodeID());
        node.setLayer(parentNode.getLayer() + 1);
        nodeID.updateID();
        int parentLayer = parentNode.getLayer();
        node.setLayer(parentLayer + 1);
        if(parentNode.getArrayOfChildren().size() == 0) {
            SetOfNodes setOfNodes = new SetOfNodes();
            setOfNodes.setLayer(node.getLayer());
            setOfNodes.setPreviousLayer(parentNode.getSetOfNodes());
            setOfNodes.addNode(node);
            node.assignSetOfNodes(setOfNodes);
            parentNode.getSetOfNodes().setNextLayer(setOfNodes);
        }
        if(parentNode.getArrayOfChildren().size() > 0) {
            parentNode.getSetOfNodes().getNextLayer().addNode(node);
            node.assignSetOfNodes(parentNode.getSetOfNodes().getNextLayer());
        }
        node.getParent().addNewChild(node);
        nodeHashMap.add(node.getValue(), node);
    }

    public void init() {

    }

    public static void main(String[] args) {
        HydraTree<Node> hydraTree = new HydraTree<>();
        Node root = new Node();
        SetOfNodes setOfNodes = new SetOfNodes();
        root.assignSetOfNodes(setOfNodes);
        root.getSetOfNodes().addNode(root);
        hydraTree.addChild(root);
        hydraTree.addChild(root);
        hydraTree.addChild(root); // nod 3
        hydraTree.addChild(getNode(3)); // nod 4
        //hydraTree.addChild(getNode(3));
        //hydraTree.addChild(getNode(3));
        //hydraTree.addChild(getNode(6));
        hydraTree.removeNode(getNode(4));
        //System.out.println(getNode(4).getValue());
        //hydraTree.cutNode(getNode(7));
        System.out.println("Begin print:");
        setOfNodes.printNodes();
        System.out.println("End print.");
        System.out.println("Node from HashMap: " + getNodeValue(1));
    }
}
