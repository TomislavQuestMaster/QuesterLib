package net.thequester.model;

import net.thequester.model.Event.State;

import java.util.LinkedHashMap;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Tomo.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "game")
public class Game {

    private Node currentNode;

	@XmlElementWrapper(name = "visitedNodes")
	@XmlElement(name = "node", type = Node.class)
    private List<Node> visitedNodes;

    private LinkedHashMap<Integer, State> visitedNodesMap;

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public List<Node> getVisitedNodes() {
        return visitedNodes;
    }

    public void setVisitedNodes(List<Node> visitedNodes) {
        this.visitedNodes = visitedNodes;
    }

    public LinkedHashMap<Integer, State> getVisitedNodesMap() {
        return visitedNodesMap;
    }

    public void setVisitedNodesMap(LinkedHashMap<Integer, State> visitedNodesMap) {
        this.visitedNodesMap = visitedNodesMap;
    }
}
