import java.util.LinkedList;
import java.util.ArrayList;


public class SetOfNodes {
    private SetOfNodes previousLayer;
    private SetOfNodes nextLayer;
    private LinkedList<Node> nodes;
    private int layer;

    public SetOfNodes() {
        nodes = new LinkedList<Node>();
        nextLayer = null;
        previousLayer = null;
        layer = 0;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getLayer() {
        return this.layer;
    }

    public void setPreviousLayer(SetOfNodes layer) {
        this.previousLayer = layer;
    }

    public void setNextLayer(SetOfNodes layer) {
        this.nextLayer = layer;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public void removeNode(Node node) {
        this.nodes.remove(node);
    }

    public SetOfNodes getNextLayer() {
        return this.nextLayer;
    }

    public String getArrayOfNodes() {
        ArrayList<String> nodeArray = new ArrayList<>();
        Node currentNode = nodes.get(0);
        if(currentNode.getValue() == 0) {
            return Integer.toString(currentNode.getValue());
        }
        LinkedList<Node> currentSetOfNodes = this.nodes;
        if(currentNode.getValue() != 0) {
        	nodeArray.add("[ ");
            for(int i = 0; i < this.nodes.size(); i++) {
                if(currentSetOfNodes.get(i).getParent().getValue() != currentNode.getValue()) {
                    currentNode = nodes.get(i).getParent();
                    nodeArray.add((" Parent: " + currentNode.getValue()) + " [");
                }
                nodeArray.add((" Node: " + nodes.get(i).getValue()).toString());
                //nodeArray.add(Integer.toString(nodes.get(i).getValue()));
            }
        }
        nodeArray.remove(0);
        return nodeArray.toString() + " ]";
    }


    public void printNodes() {
        System.out.println("Layer 1 (root node): " + this.getArrayOfNodes());
        SetOfNodes currentSetOfNodes = this;
        while(currentSetOfNodes.nextLayer != null) {
            System.out.println("Layer " + currentSetOfNodes.nextLayer.getLayer() + ": " + currentSetOfNodes.nextLayer.getArrayOfNodes());
            currentSetOfNodes = currentSetOfNodes.nextLayer;
        }
    }
}
