package net.thequester.model;

import java.util.List;

/**
 * Created by Tomo.
 */
public class Game {

    private Node currentNode;
    private QuestLocation currentLocation;
    private List<Node> visitedNodes;

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

    public List<Node> getVisitedNodes() {
        return visitedNodes;
    }

    public void setVisitedNodes(List<Node> visitedNodes) {
        this.visitedNodes = visitedNodes;
    }
}
