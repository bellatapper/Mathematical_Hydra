package main;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

import java.util.ArrayList;

import static main.HydraTree.getNode;
import static main.HydraTree.getNodeValue;

public class myGame extends BasicGame{

    public myGame(String myGame) {
        super(myGame);
        int y = Mouse.getY();
        int x = Mouse.getX();
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer apCo = new AppGameContainer(new myGame("My Game"));
        apCo.setDisplayMode(1024,683,false);
        apCo.start();
    }

    public void init(GameContainer gaCo) throws SlickException{
        gaCo.setMouseCursor("pic/HerculesSword.jpg",100,100);
        HydraTree<Node> hydraTree = new HydraTree<>();
        Node root = new Node();
        SetOfNodes setOfNodes = new SetOfNodes();
        root.assignSetOfNodes(setOfNodes);
        root.getSetOfNodes().addNode(root);
        hydraTree.addChild(root);
        hydraTree.addChild(root);
        hydraTree.addChild(root);
        hydraTree.addChild(getNode(3));
        hydraTree.addChild(getNode(3));
        hydraTree.addChild(getNode(3));
        hydraTree.addChild(getNode(6));
        //hydraTree.removeNode(getNode(3));
        //hydraTree.cutNode(getNode(6));
        System.out.println("Begin print:");
        setOfNodes.printNodes();
        System.out.println("End print.");
        System.out.println("Node from HashMap: " + getNodeValue(1));
    }

    /**
     * This method runs all the time, parallellt with render.
     * @param gaCo
     * @param delta
     * @throws SlickException
     */
    public void update(GameContainer gaCo, int delta) throws SlickException {
        //int y = Mouse.getY();
        //int x = Mouse.getX();

        //if ((x > 100 && x < 401) && ((y > 200 && y < 389))){
        //    if (Mouse.isButtonDown(0)){

        //    }

    }

    public void render (GameContainer gaCo, Graphics gr) throws SlickException {
        Image cave = new Image("pic/Cave.png");
        cave.setFilter(Image.FILTER_NEAREST);
        gr.drawImage(cave, 0, 0);
        gr.drawString("Welcome Hercules! Your mission is to defeat the hideous and horrifying hydra, Helen.", 100, 100);
        gr.drawString("Choose a head to cut off! You can only cut off heads without children...", 100, 150);
        Image playButton = new Image("pic/playButton.png");
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("pic/playButton.png"));
        if(images != null) {
            gr.drawImage(playButton, 100, 200);
            int y = Mouse.getY();
            int x = Mouse.getX();
        }

        if ((Mouse.getX() > 100 && Mouse.getX() < 401) && ((Mouse.getY() > 200 && Mouse.getY() < 389))) {
            if (gaCo.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                images.remove(0);
            }
            gr.drawImage(cave, 0, 0);
            gr.drawString("Welcome Hercules! Your mission is to defeat the hideous and horrifying hydra, Helen.", 100, 100);
            gr.drawString("Choose a head to cut off! You can only cut off heads without children...", 100, 150);
        }
    }
}
