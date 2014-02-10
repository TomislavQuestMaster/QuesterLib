package net.thequester.model;

/**
 * Created by Tomo on 10.02.14..
 */
public class Game {

    private Node currentNode;
    private QuestLocation currentLocation;

    public Node getCurrentNode() {
        return currentNode;
    }

    public QuestLocation getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public void setCurrentLocation(QuestLocation currentLocation) {
        this.currentLocation = currentLocation;
    }
}
