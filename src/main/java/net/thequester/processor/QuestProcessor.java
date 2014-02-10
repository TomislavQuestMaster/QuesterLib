package net.thequester.processor;

import net.thequester.model.Game;
import net.thequester.model.Node;
import net.thequester.model.Quest;
import net.thequester.model.QuestLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tdubravcevic
 */
public class QuestProcessor {

    private Quest quest;

    public QuestProcessor(Quest quest) {
        this.quest = quest;
    }

    /**
     * @param node currently visited node
     * @return list of nodes you can go to from the current
     */
    public List<Node> getChildren(Node node){

        List<Node> children = new ArrayList<Node>();

        for(Integer nodeId : quest.getConnections().get(node.getId()).getChildren()){
             children.add(quest.getNodes().get(nodeId));
        }

        return children;
    }

    /**
     * @param node currently visited node
     * @return list of nodes from which you can visit the current node
     */
    public List<Node> getParents(Node node){

        List<Node> parents = new ArrayList<Node>();

        for(Integer nodeId : quest.getConnections().get(node.getId()).getParents()){
            parents.add(quest.getNodes().get(nodeId));
        }

        return parents;
    }


    public boolean isNodeAtLocation(Node node, QuestLocation location){

         return false;

    }

    public Node gotoNext(Game game) {

        for(Node child : getChildren(game.getCurrentNode())){

            if(isNodeAtLocation(child,game.getCurrentLocation())){
                return child;
            }

        }
        return null;
    }
}
